public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(2001));
    }
    public static int reverse(int num) {
        int reverse = 0;
        int lastDigit = 0;

        while (num > 0) {
            lastDigit = num % 10;
            reverse = reverse * 10 + lastDigit;
            num /= 10;

        }
        return reverse;
    }
}
