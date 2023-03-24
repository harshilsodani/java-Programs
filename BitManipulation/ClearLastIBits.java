package BitManipulation;

public class ClearLastIBits {
    public static void main(String[] args) {
        System.out.println(clearLastIBits(10, 2));
    }

    // CLEAR LAST I BITS
    public static int clearLastIBits(int n, int i) {
        int bitMask = (~0) << i;
        return n & bitMask;
    }
}
