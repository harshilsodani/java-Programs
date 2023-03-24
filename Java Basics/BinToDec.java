public class BinToDec {

    public static void binToDec(long binNum) {
        long myNum = binNum;
        int decNum = 0;
        int power = 0;

        while (binNum > 0) {
            int lastDigit = (int) binNum % 10;
            decNum = decNum + lastDigit * ((int) Math.pow(2, power));
            power++;
            binNum = binNum / 10;
        }

        System.out.println("Decimal of " + myNum + " = " + decNum);

    }

    public static void main(String[] args) {
        binToDec(1010);
    }

}
