package com.pp.hackerRank.algo.warmup;

import java.util.Scanner;

public class Staircase {

	// Complete the staircase function below.
	static void staircase(int n) {
		int check = n - 1;
		for (int row = 0; row < n; row++) {
			String ladderStep = "";

			for (int column = 0; column < n; column++) {
				if (column >= check) {
					ladderStep += "#";
				} else {
					ladderStep += " ";
				}
			}
			check--;
			System.out.println(ladderStep);
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		staircase(n);

		scanner.close();
	}

}
