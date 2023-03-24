package Strings;

public class Compare {
    public static void main(String[] args) {
        String fruitotalSubArrays[] = { "apple", "Magno", "banana" };
        String largest = fruitotalSubArrays[0];

        for (int i = 0; i < fruitotalSubArrays.length; i++) {
            if (largest.compareToIgnoreCase(fruitotalSubArrays[i]) < 0) { // lexicographical comparison

                largest = fruitotalSubArrays[i];
            }
        }
        System.out.println(largest);

    }

}
