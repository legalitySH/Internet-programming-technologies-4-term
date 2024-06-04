package com.lab8.lab_8.Game;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8030)) {
            System.out.println("Подключено к серверу.");

            int number = socket.getInputStream().read();
            System.out.println("Угадайте число от 1 до 100.");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                if (!socket.isConnected()) {
                    break;
                }

                int guess = scanner.nextInt();
                socket.getOutputStream().write(guess);

                int response = socket.getInputStream().read();
                if (response == 1) {
                    System.out.println("Поздравляю! Вы угадали число");
                    break;
                } else if (response == -1) {
                    System.out.println("Предполагаемое число меньше загаданного");
                } else {
                    System.out.println("Предполагаемое число больше загаданного.");
                }
            }

        } catch (IOException e) {
            return;
        }
    }
}