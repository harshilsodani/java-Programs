public class DecToBin {
    public static void main(String[] args) {
        decToBin(10);
    }

    public static void decToBin(int decNum) {
        int rem = 0;
        int myNum = decNum;
        long binNum = 0;
        int power = 0;

        while (decNum > 0) {
            rem = decNum % 2;
            binNum = binNum + rem * ((long) Math.pow(10, power));
            power++;
            decNum = decNum / 2;
        }

        System.out.println("The binary of " + myNum + "=" + binNum);
    }
}
