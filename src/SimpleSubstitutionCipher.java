import java.util.Scanner;

public class SimpleSubstitutionCipher {
    public static String encrypt(String plaintext, String key) {
        String ciphertext = "";
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (Character.isLetter(c)) {
                int index = Character.toUpperCase(c) - 'A';
                if (Character.isUpperCase(c)) {
                    c = key.charAt(index);
                } else {
                    c = Character.toLowerCase(key.charAt(index));
                }
            }
            ciphertext += c;
        }
        return ciphertext;
    }

    public static void main(String[] args) {
        String plaintext = "DONTTROUBLETROUB";
        String key = "KGOXPMUHCAYTJQWZRIVESFLDNB";
        System.out.println("Plaintext: " + plaintext);
        System.out.println("Ciphertext: " + encrypt(plaintext, key));
    }
}
