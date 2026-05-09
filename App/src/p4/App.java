package p4;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // reads 5

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();   // reads 11 22 33 44 55
        }

        System.out.println(Arrays.toString(arr));
    }
}