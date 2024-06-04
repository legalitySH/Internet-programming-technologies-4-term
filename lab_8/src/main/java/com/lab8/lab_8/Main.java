package com.lab8.lab_8;

import com.lab8.lab_8.Game.Client;
import com.lab8.lab_8.Game.Server;
import com.lab8.lab_8.UDP.Reciever;
import com.lab8.lab_8.UDP.Sender;

import java.io.IOException;
import java.net.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String html = HTMLParser.GetHTML("https://example.com");
        System.out.printf(html);


        Thread senderThread = new Thread(() -> Sender.main(null));
        senderThread.start();

        Thread recieverThread = new Thread(() -> Reciever.main(null));
        recieverThread.start();


        Thread.sleep(2000);


        Thread serverThread = new Thread(() -> Server.main(null));
        serverThread.start();

        Thread clientThread = new Thread(() -> Client.main(null));
        clientThread.start();
    }
}
