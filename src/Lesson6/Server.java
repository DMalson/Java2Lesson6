package Lesson6;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            int port = 5555;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server application started...");
            System.out.println("Waiting for a client connection...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection with client established.\n"+"Ваша беседа\n" + "==============");

            NetService serverService = new NetService(clientSocket);
            serverService.run();
            System.out.println("Server application closed");
        } catch (Exception e) {
            System.out.println("Ошибка сервера");
            e.printStackTrace();
        }
    }
}
