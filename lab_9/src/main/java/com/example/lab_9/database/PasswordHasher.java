package com.example.lab_9.database;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public  class PasswordHasher {
    public static String hashPassword(String password, String algorithm) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] passwordBytes = password.getBytes();
            digest.update(passwordBytes);
            byte[] hashedBytes = digest.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte hashedByte : hashedBytes) {
                String hex = Integer.toHexString(0xff & hashedByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
