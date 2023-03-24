package BitManipulation;

public class OddOrEven {
    public static void main(String[] args) {
        oddOrEven(10);
    }
    // ODD OR EVEN 
    public static void oddOrEven(int n) {
        int bitMask = 1;

        if ((n & bitMask) == 0) {
            // even number
            System.out.println("Even Number");
        } else {
            // odd number
            System.out.println("Odd Number");
        }
    }
}
