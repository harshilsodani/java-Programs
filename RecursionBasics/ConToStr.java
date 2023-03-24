package RecursionBasics;

public class ConToStr {
    public static void main(String[] args) {
        conToStr(1947);
    }

    public static void conToStr(int num) {
        String digitotalSubArrays[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
                "nine" };

        // base case
        if (num == 0) {
            return;
        }

        // work
        int n = num % 10;
        conToStr(num / 10);
        System.out.print(digitotalSubArrays[n] + " ");

    }
}
