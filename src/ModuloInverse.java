public class ModuloInverse {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int inverse(int a, int n) {
        int q, a2 = 0, a3 = n, b2 = 1, b3 = a;
        while (b3 != 0 && b3 != 1) {
            q = a3 / b3;
            int b2_cp = b2, b3_cp = b3;
            b2 = a2 - b2 * q;
            b3 = a3 - b3 * q;
            a2 = b2_cp;
            a3 = b3_cp;
        }
        return (b2 + n) % n;
    }

    public static int inverse2(int a, int n) {
        for (int i = 1; i < n; i++) {
            if ((a * i) % n == 1) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println("a ^ -1 mod n = ?");
        int a = 2656;
        int n = 5141;
        System.out.println(a + "^-1 mod " + n);

        if (gcd(a, n) != 1) {
            System.out.println("Don't have inverse");
            return;
        }
        System.out.println("c1: Inverse " + a + "^-1 mod + " + n + " = " + inverse(a, n));
        System.out.println("c2: Inverse " + a + "^-1 mod + " + n + " = " + inverse2(a, n));
    }
}
