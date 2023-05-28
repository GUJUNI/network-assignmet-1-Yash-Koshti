/*
Name - Yash Koshti
R.No - 19
Course - MCA-2
Subject - Networking
Assignment - Practical Assignment-1
----------------------------------------------------------------------------------------------------------------------------
Program - 1 : Program to manage linked list using TCP protocol in Java
Server-Side
*/
import java.io.*;
import java.net.*;
import java.util.*;

public class TCPServer {

    private LinkedList<String> data = new LinkedList<>();

    public void start(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getInetAddress().getHostAddress());

            new Thread(() -> {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String message;
                    while ((message = in.readLine()) != null) {
                        synchronized (data) {
                            data.add(message);
                            System.out.println("Received message: " + message);
                        }
                    }
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void main(String[] args) throws IOException {
        TCPServer server = new TCPServer();
        server.start(8000);
    }
}
/*
-----OUTPUT-----
Server started on port 8000
Client connected from 127.0.0.1
Received message: Hello, server!
*/