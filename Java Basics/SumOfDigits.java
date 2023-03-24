public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(1001));
    }
    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            n = n / 10;
            sum += lastDigit;
        }
        return sum;
    }
}
