package RecursionBasics;

import java.util.Scanner;

public class TowerOfHanoi {

    // steps:
    // 1) transfer (n-1) disks from source to helper
    // 2) transfer nth disk from source to destinatiion
    // 3) transfer (n-1) disks form helper to destinatiion

    public static void towerOfHanoi(int n, char source, char destinatiion, char helper) {

        if (n == 1) {
            System.out.println("Move disk " + n + " from " + source + " to " + destinatiion);
            return;
        }

        towerOfHanoi(n - 1, source, helper, destinatiion);
        System.out.println("Move disk " + n + " from " + source + " to " + destinatiion);
        towerOfHanoi(n - 1, helper, destinatiion, source);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int noOfRings = sc.nextInt();
        towerOfHanoi(noOfRings, 'A', 'C', 'B');
    }
}
