package RecursionBasics;

public class SumNNaturalno {
    public static void main(String[] args) {
        System.out.println(sum(10));
    }

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        int Snm1 = sum(n - 1);
        int sn = n + Snm1;
        return sn;
    }
}
