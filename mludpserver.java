/*
Name - Yash Koshti
R.No - 19
Course - MCA-2
Subject - Networking
Assignment - Practical Assignment-1
----------------------------------------------------------------------------------------------------------------------------
Program-4 : UDP program that create Student Marksheet in java
Server-Side
*/
import java.net.*;
import java.io.*;

class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is running...");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket);
            new Thread(() -> {
                try {
                    InputStream in = clientSocket.getInputStream();
                    OutputStream out = clientSocket.getOutputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    PrintWriter writer = new PrintWriter(out, true);
                    String name = reader.readLine();
                    int roll = Integer.parseInt(reader.readLine());
                    int sub1 = Integer.parseInt(reader.readLine());
                    int sub2 = Integer.parseInt(reader.readLine());
                    int sub3 = Integer.parseInt(reader.readLine());
                    int totalMarks = sub1 + sub2 + sub3;
                    double percentage = (totalMarks / 3.0);
                    writer.println("Name: " + name);
                    writer.println("Roll No.: " + roll);
                    writer.println("Subject 1: " + sub1);
                    writer.println("Subject 2: " + sub2);
                    writer.println("Subject 3: " + sub3);
                    writer.println("Total Marks: " + totalMarks);
                    writer.println("Percentage: " + percentage + "%");
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

/*
-----OUTPUT-----
Server is running...
Client connected: Socket[addr=/127.0.0.1,port=49314,localport=5000]
*/