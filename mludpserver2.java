/*
Name - Yash Koshti
R.No - 19
Course - MCA-2
Subject - Networking
Assignment - Practical Assignment-1
----------------------------------------------------------------------------------------------------------------------------
Program-10 : UDP program of password generator
Server-Side
*/

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UDPServer {

    private static final int SERVER_PORT = 8000;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT);
        System.out.println("Server started on port " + SERVER_PORT);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        while (true) {
            byte[] receiveBuffer = new byte[BUFFER_SIZE];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            serverSocket.receive(receivePacket);

            ClientHandler clientHandler = new ClientHandler(serverSocket, receivePacket);
            executorService.execute(clientHandler);
        }
    }

    private static class ClientHandler implements Runnable {
        private final DatagramSocket serverSocket;
        private final DatagramPacket receivePacket;

        public ClientHandler(DatagramSocket serverSocket, DatagramPacket receivePacket) {
            this.serverSocket = serverSocket;
            this.receivePacket = receivePacket;
        }

        @Override
        public void run() {
            try {
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                byte[] receiveData = receivePacket.getData();
                int passwordLength = Integer.parseInt(new String(receiveData, 0, receivePacket.getLength()));
                String password = generatePassword(passwordLength);

                byte[] sendData = password.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);

                System.out.println("Password sent to client: " + password);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String generatePassword(int length) {
            String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
            StringBuilder sb = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(chars.length());
                sb.append(chars.charAt(index));
            }

            return sb.toString();
        }
    }
}

/*
-----OUTPUT-----
Server started on port 8000
Password sent to client: GKQugK1lqu
*/