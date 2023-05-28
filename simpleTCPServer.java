/*
Name - Yash Koshti
R.No - 19
Course - MCA-2
Subject - Networking
Assignment - Practical Assignment-1
----------------------------------------------------------------------------------------------------------------------------
Program-3 : Sort an array using selection sort
Server-Side
*/

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class TCPServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started on port 8000");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getInetAddress().getHostAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();

            String[] arrString = message.split(",");
            int[] arrInt = new int[arrString.length];
            for (int i = 0; i < arrString.length; i++) {
                arrInt[i] = Integer.parseInt(arrString[i]);
            }

            selectionSort(arrInt);

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(Arrays.toString(arrInt));

            clientSocket.close();
        }
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}

/*
-----OUTPUT-----
Server started on port 8000
Client connected from 127.0.0.1:55189
*/