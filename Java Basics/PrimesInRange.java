public class PrimesInRange extends IsPrime {
    public static void main(String[] args) {
        primesInRange(100);
    }
    public static void primesInRange(int n) {

        for (int i = 2; i <= n; i++) {

            if ((isPrime(i)) == true) {
                System.out.print(i + " ");
            }
        }

    }
}
