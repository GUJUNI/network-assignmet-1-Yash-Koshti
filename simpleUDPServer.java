/*
Name - Yash Koshti
R.No - 19
Course - MCA-2
Subject - Networking
Assignment - Practical Assignment-1
----------------------------------------------------------------------------------------------------------------------------
Program - 2 : Program to count number of occurences of a specific word.
Server-Side
*/
import java.io.*;
import java.net.*;
import java.util.*;

public class UDPServer {

    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(8000);
        System.out.println("Server started on port 8000");

        byte[] receiveData = new byte[1024];

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received sentence: " + sentence);

            String word = "example"; // The word to count occurrences of
            int count = countOccurrences(sentence, word);

            byte[] sendData = String.valueOf(count).getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
            serverSocket.send(sendPacket);
        }
    }

    private static int countOccurrences(String sentence, String word) {
        int count = 0;
        int index = 0;
        while ((index = sentence.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }
}
/*
-----OUTPUT-----
Server started on port 8000
Received sentence: This is an example sentence.
Received sentence: Another example sentence.
Received sentence: Yet another example sentence.
*/