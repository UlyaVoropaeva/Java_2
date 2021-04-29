package lesson_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends  Thread{

    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private com.GB.chat2021.server.Server server;
    private String username;



    public ClientHandler(Socket clientSocket, com.GB.chat2021.server.Server server) throws IOException {
        this.clientSocket = clientSocket;
        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());
        this.server = server;

        new Thread(() -> {
            try {
                //цикл авторизации
                while (true) {
                    String msg = in.readUTF();
                    if(msg.startsWith("/login ")) {
                        String usernameFromLogin = msg.split("\\s")[1];

                        if(server.isNickBusy(usernameFromLogin)) {
                            sendMessage("/login_failed Current nickname has already been occupied");
                            continue;
                        }
                        username = usernameFromLogin;
                        sendMessage("/login_ok " + username);
                        server.subscribe(this);
                        break;
                    }
                }

                //цикл общения
                while (true) {
                    String msg = in.readUTF();
                    if(msg.startsWith("/exit")) return;

                    if(msg.startsWith("/who_am_i")){
                        server.usernameMessage(username);
                        System.out.println("Клиент:" + username);
                        continue;
                    }

                    if(msg.startsWith("/w")){
                        String usernamePrivate = msg.split("\\s")[1];
                        String msgPrivate = msg.split("\\s")[2];
                        if(server.isNickBusy(usernamePrivate) == true){
                                server.privatUserMessage (this,usernamePrivate,msgPrivate);
                        } else this.sendMessage("В списке контактов отсуствует : " + usernamePrivate);
                        continue;
                    }

                    server.broadcastMessage(username + ": " + msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();
    }

    private void disconnect(){
        server.unsubscribe(this);
        if(in != null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        if(out != null){
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (clientSocket != null){
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void sendMessage(String message) throws IOException {
        out.writeUTF(message);
    }

    public String getUsername() {
        return username;
    }


}


