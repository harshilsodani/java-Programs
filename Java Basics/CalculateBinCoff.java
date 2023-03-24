
public class CalculateBinCoff extends CalculateFactorial {
    public static void main(String args[]) {
        System.out.println(binCoff(10, 2));
    }

    public static int binCoff(int n, int r) {

        int nFact = calculateFactorial(n);
        int rFact = calculateFactorial(r);
        int nmrFact = calculateFactorial(n - r);
        int bc = nFact / (rFact * nmrFact);

        return bc;
    }

}
