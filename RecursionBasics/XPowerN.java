package RecursionBasics;

public class XPowerN {
    public static void main(String[] args) {

        // System.out.println(power(2, 30));
        System.out.println(optimizedPower(2, 30));

    }

    public static int power(int x, int n) {

        if (n == 0) {
            return 1;
        }

        return x * power(x, n - 1);
    }

    public static int optimizedPower(int x, int n) { // O(logn)

        if (n == 0) {
            return 1;
        }

        int halfPower = optimizedPower(x, n / 2);
        int haflPowerSq = halfPower * halfPower;

        if (n % 2 != 0) {
            haflPowerSq = x * haflPowerSq;
        }

        return haflPowerSq;

    }
}
