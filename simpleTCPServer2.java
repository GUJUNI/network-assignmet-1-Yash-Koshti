/*
Name - Yash Koshti
R.No - 19
Course - MCA-2
Subject - Networking
Assignment - Practical Assignment-1
----------------------------------------------------------------------------------------------------------------------------
Program-7 : TCP program to convert Kilometers into Astronomical Units
Server-Side
*/

import java.io.*;
import java.net.*;

public class TCPServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started on port 8000");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getInetAddress().getHostAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String kmString = in.readLine();
            double km = Double.parseDouble(kmString);

            double au = convertKmToAu(km);

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(au);

            clientSocket.close();
        }
    }

    private static double convertKmToAu(double km) {
        return km * 6.68458712e-9; // Conversion factor from km to AU
    }
}

/*
-----OUTPUT-----
Server started on port 8000
Client connected from 127.0.0.1
*/