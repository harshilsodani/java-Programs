package BitManipulation;

public class Swap {
    public static void main(String[] args) {
        int x = 3, y = 4;
        System.out.println("Befor swap, x:" + x + ",  y:" + y);
        // swap - using XOR operator
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("After swap, x:" + x + ",  y:" + y);
    }

}
