public class RSAEncryption {
    public static int inverse(int a, int n) {
        for (int i = 2; i <= a + n; i++) {
            if ((a * i) % n == 1)
                return i;
        }
        return -1;
    }

    public static int power(int a, int b, int c) {
        int x = 1;
        int y = a;
        while (b > 0) {
            if (b % 2 != 0)
                x = (x * y) % c;
            y = (y * y) % c;
            b = b / 2;
        }
        return x % c;
    }

    public static void main(String[] args) {
        int p, q, e, M;
        p = 37;
        q = 53;
        e = 47;
        M = 41;
        int n = p * q;
        int euler_n = (p - 1) * (q - 1);
        int d = inverse(e, euler_n);
        int C = power(M, d, n);
        int g = power(C, e, n);
        System.out.println("PU = {" + e + "," + n + "}");
        System.out.println("PR = {" + d + "," + n + "}");
        System.out.println("C = " + C);
        System.out.println("M = " + g);
    }
}
