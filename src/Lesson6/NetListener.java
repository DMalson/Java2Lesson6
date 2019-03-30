package Lesson6;

import java.io.DataInputStream;

public class NetListener implements Runnable {
    private DataInputStream dataInputStream;

    public NetListener(DataInputStream dataInputStream) {
        this.dataInputStream = dataInputStream;
    }

    public NetListener() {
    }


    @Override
    public void run() {
        try {
            String message = null;
            while (true) {
                try {
                    message = dataInputStream.readUTF();
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Собеседник покинул беседу.");
                    break;
                } else System.out.println("Собеседник: " + message);
            }
            dataInputStream.close();
            System.out.println("Service NetListener closed");
        }  catch (Exception e) {
            System.out.println("Ошибка сервиса NetListener");
            e.printStackTrace();
        }
    }
}
