package ArrayList;

import java.util.ArrayList;

public class PairSum2 {

    // brutr force - O(n^2)
    // public static boolean pairSum2(ArrayList<Integer> list, int target) {
    // for (int i = 0; i < list.size(); i++) {
    // for (int j = i + 1; j < list.size(); j++) {
    // if ((list.get(i) + list.get(j)) == target) {
    // return true;
    // }
    // }
    // }
    // return false;
    // }

    // two pointer approach - O(n)
    // 1) find breaking point , breaking point == i
    // 2) lp=i+1 and rp=i
    // 3) use Modular Arithmatic
    // n=list.size();
    // if(sum< target){
    // lp=(lp+1)%n;
    // }else{
    // rp=(n+rp-1)%n;
    // }
    public static boolean pairSum2(ArrayList<Integer> list, int target) {

        int bp = 0;
        int n = list.size();
        // finding breaking point
        for (int i = 0; i < list.size() - 2; i++) {
            if (list.get(i) > list.get(i + 1)) { // breaking point
                bp = i;
                break;
            }
        }

        int lp = bp + 1; // smallest
        int rp = bp; // largest

        while (lp != rp) {
            // case 1
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }

            // case 2
            if (list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % n;
            } else { // case 3
                rp = (n + rp - 1) % n;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        System.out.println(pairSum2(list, target));
    }
}
