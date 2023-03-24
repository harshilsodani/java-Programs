package RecursionBasics;

public class LenStr {
    public static void main(String[] args) {
        System.out.println(lenOfStr("abcde"));
    }

    public static int lenOfStr(String str) {
        // base case 
        if(str.length()==0){
            return 0;
        }

        return lenOfStr(str.substring(1))+1;
    }
}
