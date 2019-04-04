package Lesson6;

import java.io.*;
import java.net.Socket;

public class NetService {
    private Socket socket;

    public NetService(Socket socket) {
        this.socket = socket;
    }

    public NetService() {
    }

    public void run() throws Exception {
        DataInputStream dataInputStream;
        DataOutputStream dataOutputStream;
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());

        Thread listenerThread = new Thread(new NetListener(dataInputStream));
        listenerThread.setDaemon(true);
        listenerThread.start();

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String message = null;
        while (true) {
            message = keyboard.readLine();
            if (!listenerThread.isAlive()) break;
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
            if (message.equalsIgnoreCase("exit")) break;
        }
        dataOutputStream.close();
        keyboard.close();
        System.out.println("NetService closed");
    }
}
