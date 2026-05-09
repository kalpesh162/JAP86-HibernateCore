package p3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class App {

	public static void main(String[] args) throws Exception {

		int[] A = new int[5];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nums = br.readLine().split(" ");

		for (int i = 0; i < 5; i++) {
			A[i] = Integer.parseInt(nums[i]);
		}

		System.out.println(Arrays.toString(A));
	}
}