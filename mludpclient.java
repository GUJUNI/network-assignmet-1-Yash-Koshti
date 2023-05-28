/*
Name - Yash Koshti
R.No - 19
Course - MCA-2
Subject - Networking
Assignment - Practical Assignment-1
----------------------------------------------------------------------------------------------------------------------------
Program-4 : UDP program that create Student Marksheet in java
Client-Side
*/
import java.net.*;
import java.io.*;

class Client {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        Socket socket = new Socket(serverAddress, 5000);
        System.out.println("Connected to server: " + socket);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Enter your name: ");
        String name = reader.readLine();
        System.out.println("Enter your roll no.: ");
        int roll = Integer.parseInt(reader.readLine());
        System.out.println("Enter marks for Subject 1: ");
        int sub1 = Integer.parseInt(reader.readLine());
        System.out.println("Enter marks for Subject 2: ");
        int sub2 = Integer.parseInt(reader.readLine());
        System.out.println("Enter marks for Subject 3: ");
        int sub3 = Integer.parseInt(reader.readLine());
        writer.println(name);
        writer.println(roll);
        writer.println(sub1);
        writer.println(sub2);
        writer.println(sub3);
        System.out.println("Mark sheet received from server:");
        System.out.println(serverReader.readLine());
        System.out.println(serverReader.readLine());
        System.out.println(serverReader.readLine());
        System.out.println(serverReader.readLine());
        System.out.println(serverReader.readLine());
        System.out.println(serverReader.readLine());
        socket.close();
    }
}

/*
-----OUTPUT-----
Connected to server: Socket[addr=/127.0.0.1,port=5000,localport=49314]
Enter your name:
Ruchit
Enter your roll no.:
28
Enter marks for Subject 1:
28
Enter marks for Subject 2:
25
Enter marks for Subject 3:
30
Mark sheet received from server:
Name: Ruchit
Roll No.: 28
Subject 1: 28
Subject 2: 25
Subject 3: 30
Total Marks: 83
*/