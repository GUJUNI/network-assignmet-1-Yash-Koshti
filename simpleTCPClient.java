/*
Name - Yash Koshti
R.No - 19
Course - MCA-2
Subject - Networking
Assignment - Practical Assignment-1
----------------------------------------------------------------------------------------------------------------------------
Program-3 : Sort an array using selection sort
Client-Side
*/

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class TCPClient {

    public static void main(String[] args) throws IOException {
        int[] arr = {5, 2, 8, 3, 9};

        Socket socket = new Socket("localhost", 8000);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println(Arrays.toString(arr));

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message = in.readLine();
        String[] arrString = message.substring(1, message.length() - 1).split(", ");
        int[] sortedArr = new int[arrString.length];
        for (int i = 0; i < arrString.length; i++) {
            sortedArr[i] = Integer.parseInt(arrString[i]);
        }

        System.out.println("Sorted array: " + Arrays.toString(sortedArr));

        socket.close();
    }
}

/*
-----OUTPUT-----
Sorted array: [2, 3, 5, 8, 9]
*/