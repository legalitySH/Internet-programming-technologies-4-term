package com.lab8.lab_8.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Reciever {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(12345);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            socket.receive(receivePacket);

            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Получено сообщение: " + message);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
