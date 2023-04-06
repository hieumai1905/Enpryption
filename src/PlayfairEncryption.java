import java.util.Arrays;
import java.util.Scanner;

public class PlayfairEncryption {
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Tìm vị trí của ký tự trong bảng chữ cái
    public static int position(char a) {
        if (a > 'Z') {
            return a - 'a';
        } else {
            return a - 'A';
        }
    }

    // Tạo ma trận khóa từ khóa nhập vào
    public static String createMatrixKey(String key) {
        String MatrixKey = "";
        int flag[] = new int[26];
        Arrays.fill(flag, 0);
        for (char c : key.toCharArray()) {
            int p = position(c);
            if (flag[p] == 0) {
                MatrixKey += c;
                flag[p] = 1;
            }
        }
        if (flag[position('j')] == 1) {
            flag[position('i')] = 1;
        } else {
            flag[position('j')] = 1;
        }
        for (int i = 0; i < 26; i++) {
            if (flag[i] == 0) {
                MatrixKey += alphabet.charAt(i);
            }
        }
        return MatrixKey;
    }

    // Tách chuỗi plaintext thành các cặp ký tự
    public static String split(String input) {
        String plaintext = "";
        int len = input.length();
        int i = 0;
        while (i < len) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                plaintext += input.charAt(i);
                plaintext += "X";
                i++;
            } else {
                plaintext += input.charAt(i);
                if (i + 1 < len) {
                    plaintext += input.charAt(i + 1);
                }
                i += 2;
            }
        }
        if (plaintext.length() % 2 == 1) {
            plaintext += "X";
        }
        return plaintext;
    }

    // Tạo mảng chứa vị trí của ký tự trong ma trận khóa
    public static int[] createIndex(String matrixKey) {
        int index[] = new int[26];
        for (int i = 0; i < 25; i++) {
            int pos = position(matrixKey.charAt(i));
            index[pos] = i;
        }
        index[position('j')] = index[position('i')];
        return index;
    }

    // Mã hóa Playfair
    public static String PlayFairEncryption(String input, String key) {
        String plaintext = split(input);
        System.out.println("Plaintext after Split: " + plaintext + " " + plaintext.length());
        String matrixKey = createMatrixKey(key);
        int index[] = createIndex(matrixKey);
        String ciphertext = "";
        for (int i = 0; i < input.length(); i += 2) {
            int p1 = index[position(plaintext.charAt(i))];
            int p2 = index[position(plaintext.charAt(i + 1))];
            int row1 = p1 / 5, col1 = p1 % 5;
            int row2 = p2 / 5, col2 = p2 % 5;
            int c1, c2;
            if (row1 == row2) {
                col1 = (col1 + 1) % 5;
                col2 = (col2 + 1) % 5;
                c1 = row1 * 5 + col1;
                c2 = row2 * 5 + col2;
            } else if (col1 == col2) {
                row1 = (row1 + 5) % 5;
                row2 = (row2 + 5) % 5;
                c1 = row1 * 5 + col1;
                c2 = row2 * 5 + col2;
            } else {
                c1 = row1 * 5 + col2;
                c2 = row2 * 5 + col1;
            }
            ciphertext += matrixKey.charAt(c1);
            ciphertext += matrixKey.charAt(c2);
        }
        return ciphertext;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "SOFARSOGOODSO";
        String key = "EASTORW";
        System.out.println("Plaintext: " + split("SOFARSOGOODSO"));
        System.out.println("PlayFair Encryption: " + PlayFairEncryption(input, key));
        sc.close();
    }

}
