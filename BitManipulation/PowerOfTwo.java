package BitManipulation;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(5));
    }

    public static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;

    }
}
