/*
Name - Yash Koshti
R.No - 19
Course - MCA-2
Subject - Networking
Assignment - Practical Assignment-1
----------------------------------------------------------------------------------------------------------------------------
Program-9 : UDP program which returns the ASCII numbers of each letters from the given string
Server-Side
*/

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

    private static final int SERVER_PORT = 8000;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT);
        System.out.println("Server started on port " + SERVER_PORT);

        byte[] receiveBuffer = new byte[BUFFER_SIZE];

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            serverSocket.receive(receivePacket);

            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from client: " + message);

            String asciiNumbers = getAsciiNumbers(message);

            byte[] sendBuffer = asciiNumbers.getBytes();
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);
        }
    }

    private static String getAsciiNumbers(String message) {
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            sb.append((int) c).append(" ");
        }
        return sb.toString().trim();
    }
}

/*
-----OUTPUT-----
Server started on port 8000
Received from client: Hello, World!
*/