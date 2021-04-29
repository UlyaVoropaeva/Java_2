package lesson_7;

import java.io.IOException;

public class ServerApp {


    public static void main(String[] args) throws IOException, InterruptedException {
        new com.GB.chat2021.server.Server(8189);
    }

}
