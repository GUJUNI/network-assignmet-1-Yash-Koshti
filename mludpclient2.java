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

public class UDPClient {

    private static final int SERVER_PORT = 8000;
    private static final String SERVER_IP = "localhost";
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        int passwordLength = 10; // Length of the password to be generated

        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName(SERVER_IP);

        byte[] sendBuffer = String.valueOf(passwordLength).getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, SERVER_PORT);
        clientSocket.send(sendPacket);

        byte[] receiveBuffer = new byte[BUFFER_SIZE];
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        clientSocket.receive(receivePacket);

        String password = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Received password from server: " + password);

        clientSocket.close();
    }
}

/*
-----OUTPUT-----
Received password from server: GKQugK1lqu
*/