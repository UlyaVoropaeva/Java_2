package lesson_8;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private int port;
    private List <com.GB.chat2021.server.ClientHandler> clients;

    public Server (int port){
        this.port = port;
        this.clients = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту" + port + "...");

            while (true){
                System.out.println("Ждем нового клиента...");
                Socket socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                new com.GB.chat2021.server.ClientHandler(socket, this);
            }


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public synchronized void subscribe(com.GB.chat2021.server.ClientHandler clientHandler) {
        clients.add(clientHandler);
        broadcastMessage("Клиент " + clientHandler.getUsername() + " подлючился \n");
        broadcastClientList();
    }

    public synchronized void unsubscribe(com.GB.chat2021.server.ClientHandler clientHandler) {
        clients.remove(clientHandler);
        broadcastMessage("Клиент " + clientHandler.getUsername() + " отключился \n");
        broadcastClientList();
    }
    public synchronized void broadcastMessage(String message) {
        for (com.GB.chat2021.server.ClientHandler clientHandler : clients) {
            clientHandler.sendMessage(message);
        }
    }

    public boolean isUserOnline(String nickname) {
        for (com.GB.chat2021.server.ClientHandler clientHandler : clients) {
            if(clientHandler.getUsername().equals(nickname)) {
                return true;
            }
        }
        return false;
    }

    public void usernameMessage(String nickname) {
        for (com.GB.chat2021.server.ClientHandler client: clients) {
            if(client.getUsername().equals(nickname)){
                client.sendMessage("Ваш никнейм: " + client.getUsername() + "\n");
                return;
            }
        }

    }

    public void privatUserMessage(com.GB.chat2021.server.ClientHandler clientHandler, String username, String massage) {

        for (com.GB.chat2021.server.ClientHandler client: clients) {
            if(client.getUsername().equals(username)){
                client.sendMessage("От "+ clientHandler.getUsername()+":  " + massage + " \n");
                clientHandler.sendMessage("Пользователю "+ username +":  " + massage + " \n");
                return;
            }

        }
        clientHandler.sendMessage("Невозможно отправить сообщение. В списке контактов отсуствует : " + username +"\n");
        return;
    }
    private void  broadcastClientList() {
        StringBuilder stringBuilder = new StringBuilder("/clients_list ");
        for (com.GB.chat2021.server.ClientHandler client : clients) {
            stringBuilder.append(client.getUsername()).append(" ");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        String clientsList = stringBuilder.toString();
        for (com.GB.chat2021.server.ClientHandler clientHandler : clients) {
            clientHandler.sendMessage(clientsList);
        }
    }
}
