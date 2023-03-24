
public class IsEven {
    public static void main(String[] args) {
        System.out.println(isEven(10));
    }
    public static boolean isEven(int num) {
        if (num % 2 != 0) {
            return false;
        } else
            return true;
    }
}
