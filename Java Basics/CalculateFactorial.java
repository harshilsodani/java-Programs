public class CalculateFactorial{
    public static void main(String args[]){
        System.out.println(calculateFactorial(5));
    }

    
    public static int calculateFactorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
}