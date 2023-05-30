/*
Name - Yash Koshti
R.No - 19
Course - MCA-2
Subject - Networking
Assignment - Practical Assignment-1
----------------------------------------------------------------------------------------------------------------------------
Program-7 : TCP program to convert Kilometers into Astronomical Units
Client-Side
*/

import java.io.*;
import java.net.*;

public class TCPClient {

    public static void main(String[] args) throws IOException {
        double km = 150000000; // Example value in kilometers to be converted

        Socket socket = new Socket("localhost", 8000);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println(km);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String auString = in.readLine();
        double au = Double.parseDouble(auString);

        System.out.println(km + " km is equal to " + au + " Astronomical Units (AU)");

        socket.close();
    }
}

/*
-----OUTPUT-----
1.5E8 km is equal to 1.002688068 Astronomical Units (AU)
*/