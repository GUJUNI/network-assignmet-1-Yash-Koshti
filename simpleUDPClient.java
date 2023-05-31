/*
Name - Yash Koshti
R.No - 19
Course - MCA-2
Subject - Networking
Assignment - Practical Assignment-1
----------------------------------------------------------------------------------------------------------------------------
Program - 2 : Program to count number of occurences of a specific word.
Client-Side
*/
import java.io.*;
import java.net.*;
import java.util.*;

public class UDPClient {

    public static void main(String[] args) throws IOException {
        DatagramSocket clientSocket = new DatagramSocket();

        List<String> sentences = Arrays.asList(
                "This is an example sentence.",
                "Another example sentence.",
                "Yet another example sentence.");

        String word = "example"; // The word to count occurrences of

        for (String sentence : sentences) {
            byte[] sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("localhost"), 8000);
            clientSocket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            int count = Integer.parseInt(new String(receivePacket.getData(), 0, receivePacket.getLength()));
            System.out.println("Occurrences of '" + word + "' in sentence '" + sentence + "': " + count);
        }

        clientSocket.close();
    }
}
/*
-----OUTPUT-----
Occurrences of 'example' in sentence 'This is an example sentence.': 1
Occurrences of 'example' in sentence 'Another example sentence.': 1
Occurrences of 'example' in sentence 'Yet another example sentence.': 1
*/