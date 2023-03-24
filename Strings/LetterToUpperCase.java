package Strings;

public class LetterToUpperCase {
    public static void main(String[] args) {
        System.out.println(firstLetterToUppercase("my names is harshil."));
    }

    // // LETTER TO UPPER CASE
    public static String firstLetterToUppercase(String str) {

        StringBuilder sb = new StringBuilder(""); // created a new StringBuilder

        char ch = Character.toUpperCase(str.charAt(0)); // first letter of string str converted to uppercase

        sb.append(ch); // first uppercased letter appended to the StringBuilder

        for (int i = 1; i < str.length(); i++) { // loop from index 1 to length-1

            if (str.charAt(i) == ' ' && i < str.length() - 1) { // check whether the char at index i is space or not

                sb.append(str.charAt(i)); // append space to the StringBuilder
                i++; // i=i+1
                sb.append(Character.toUpperCase(str.charAt(i))); // converted the charAt (i+1) to uppercase and appended to the StringBuilder
            } else {
                sb.append(str.charAt(i)); // charAt i appended to StringBuilder
            }
        }

        return sb.toString(); // StringBuilder converted to string and returned
    }

}

