/*
Name - Yash Koshti
R.No - 19
Course - MCA-2
Subject - Networking
Assignment - Practical Assignment-1
----------------------------------------------------------------------------------------------------------------------------
Program - 6 : W A P to compute a message digest for a file of any type and any size
*/

import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;

class FileMessageDigest {

    public static void main(String[] args) throws NoSuchFileException {
        String filePath = "demo.txt"; // Replace with the actual file path

        try {
            // Read the file content into a byte array
            byte[] fileContent = Files.readAllBytes(Paths.get(filePath));

            // Compute the message digest (SHA-256)
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(fileContent);

            // Convert the digest bytes to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            System.out.println("Message Digest (SHA-256) of " + filePath + ":");
            System.out.println(hexString.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
-----OUTPUT-----
Message Digest (SHA-256) of demo.txt:
a83df34fc4b9afe51875cf1749ade07680eca274e94ae7d5721290d8cba6cb66
*/