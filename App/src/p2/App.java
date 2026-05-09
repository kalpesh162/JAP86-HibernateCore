package p2;

import java.util.Arrays;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		int A[];
		int size;
		Scanner scanner = new Scanner(System.in);
		size=scanner.nextInt();
		A=new int[size];
		for (int i = 0; i < 5; i++) {
			A[i]=scanner.nextInt();
		}
		
		System.out.println(Arrays.toString(A));

	}

}
