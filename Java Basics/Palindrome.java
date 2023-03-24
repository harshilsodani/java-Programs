public class Palindrome extends Reverse {
    public static void main(String[] args) {
        palindrome(1001);
    }
    public static void palindrome(int num) {
        int reverseNum = reverse(num);

        if (reverseNum == num) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

    }
}
