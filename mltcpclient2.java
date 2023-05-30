/*
Name - Yash Koshti
R.No - 19
Course - MCA-2
Subject - Networking
Assignment - Practical Assignment-1
----------------------------------------------------------------------------------------------------------------------------
Program - 8 : BMI Calculator
Client-Side
*/

import java.io.*;
import java.net.*;

public class TCPClient {

    public static void main(String[] args) throws IOException {
        double height = 175; // Height in centimeters
        double weight = 70; // Weight in kilograms

        Socket socket = new Socket("localhost", 8000);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println(height);
        out.println(weight);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String bmiString = in.readLine();
        double bmi = Double.parseDouble(bmiString);

        System.out.println("BMI: " + bmi);

        socket.close();
    }
}

/*
-----OUTPUT-----
BMI: 22.857142857142858
*/