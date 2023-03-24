package RecursionBasics;

/*Given n friends, each one can remain single or can be paired up with some other friend . Each friend can be paired only once . Find out the total number of ways in which friends can remain single or can be paired up. */

public class FriendsPairing {
    public static void main(String[] args) {
        System.out.println(friendsPairing(3));
    }

    public static int friendsPairing(int n) {

        // base case
        if (n == 1 || n == 2) {
        return n;
        }

        // // choice to be single
        // int fnm1 = friendsPairing(n - 1);

        // // choice to be paired
        // int fnm2 = friendsPairing(n - 2);
        // int pairWays=(n-1)*fnm2;

        // // totalways
        // int totalways = fnm1 + pairWays;
        // return totalways;

        return friendsPairing(n - 1) + (n - 1) * friendsPairing(n - 2);
    }
}
