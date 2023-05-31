/*
Name - Yash Koshti
R.No - 19
Course - MCA-2
Subject - Networking
Assignment - Practical Assignment-1
----------------------------------------------------------------------------------------------------------------------------
Program - 8 : BMI Calculator
Server-Side
*/

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started on port 8000");

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getInetAddress().getHostAddress());

            ClientHandler clientHandler = new ClientHandler(clientSocket);
            executorService.execute(clientHandler);
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String heightString = in.readLine();
                String weightString = in.readLine();

                double height = Double.parseDouble(heightString);
                double weight = Double.parseDouble(weightString);

                double bmi = calculateBMI(height, weight);

                out.println(bmi);

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private double calculateBMI(double height, double weight) {
            double heightInMeters = height / 100; // Convert height to meters
            return weight / (heightInMeters * heightInMeters);
        }
    }
}
/*
-----OUTPUT-----
Server started on port 8000
Client connected from 127.0.0.1
*/