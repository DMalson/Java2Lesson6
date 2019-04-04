package Lesson6;

import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try {
            int serverPort = 5555;
            InetAddress ipAddress = InetAddress.getLocalHost();
            System.out.println("Client application started...");

            Socket socket = new Socket(ipAddress, serverPort);
            System.out.println("Connection to server established.\n"+"Ваша беседа\n" + "==============");

            NetService clientService =new NetService(socket);
            clientService.run();
            System.out.println("Client application closed");
        } catch (Exception e) {
            System.out.println("Ошибка клиента");
            e.printStackTrace();
        }

    }

}
