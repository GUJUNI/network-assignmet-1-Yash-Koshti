/*
Name - Yash Koshti
R.No - 19
Course - MCA-2
Subject - Networking
Assignment - Practical Assignment-1
----------------------------------------------------------------------------------------------------------------------------
Program - 1 : Program to manage linked list using TCP protocol in Java
Client-Side
*/
import java.io.*;
import java.net.*;

public class TCPClient {

    public void send(String host, int port, String message) throws IOException {
        Socket socket = new Socket(host, port);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(message);
        System.out.println("Sent message: " + message);
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        TCPClient client = new TCPClient();
        client.send("localhost", 8000, "Hello, server!");
    }
}
/*
-----OUTPUT-----
Sent message: Hello, server!
*/