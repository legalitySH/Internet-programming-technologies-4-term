package com.lab8.lab_8.Game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8030)) {
            System.out.println("Сервер запущен! Ожидание клиента...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился.");

            Random random = new Random();
            int number = random.nextInt(100) + 1;

            clientSocket.getOutputStream().write(number);

            while (true) {
                if (!clientSocket.isConnected()) {
                    break;
                }

                int guess = clientSocket.getInputStream().read();

                if (guess == number) {
                    clientSocket.getOutputStream().write(1);
                    serverSocket.close();
                    break;
                } else if (guess < number) {
                    clientSocket.getOutputStream().write(-1);
                } else {
                    clientSocket.getOutputStream().write(1);
                }
            }
            clientSocket.close();
            serverSocket.close();
            System.out.println("Игра завершена, сервер закрыт.");
        } catch (IOException e) {
            return;
        }
    }
}