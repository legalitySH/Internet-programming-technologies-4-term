package com.lab8.lab_8.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();

            String message = "привет от детей Донбасса";
            InetAddress receiverAddress = InetAddress.getByName("localhost");
            int receiverPort = 12345;

            byte[] sendData = message.getBytes();
            DatagramPacket packet = new DatagramPacket(sendData, sendData.length, receiverAddress, receiverPort);

            socket.send(packet);


            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
