package com.besafe.besafebackend.modals.Classes.Authentication;
import java.util.Random;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Utils {

    private static final int NUM_DIGITS = 4;
    public static int generateOtp() {
        Random rand = new Random();
        int min = (int) Math.pow(10, NUM_DIGITS - 1); // minimum value for a 4-digit number
        int max = (int) Math.pow(10, NUM_DIGITS) - 1; // maximum value for a 4-digit number
        return rand.nextInt(max - min + 1) + min;
    }

    public static String convertToHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hashBuilder = new StringBuilder();
            for (byte b : hashBytes) {
                hashBuilder.append(String.format("%02x", b)); // convert byte to hexadecimal string
            }
            return hashBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
