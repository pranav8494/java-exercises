/**
 * 
 */
package com.pp.hackerRank.euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author pranav8494
 *
 */
public class Euler225TribonacciNonDivisors {

	public static boolean isDivisorMultipleFound(List<Integer> alreadyFound, int div) {

		for (int i : alreadyFound) {
			if (div % i == 0) {
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) throws Exception {

		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();

		String[] token = input.split(" ");
		if (token.length == 4) {

			int t1 = Integer.parseInt(token[0]);
			int t2 = Integer.parseInt(token[1]);
			int t3 = Integer.parseInt(token[2]);
			int k = Integer.parseInt(token[3]);

			int currentDiv = 1;
			int numFound = 0;
			List<Integer> alreadyFound = new ArrayList<Integer>();
			while (numFound < k) {

				currentDiv += 2;
				boolean isDivisor = false;
				int tempT1 = t1;
				int tempT2 = t2;
				int tempT3 = t3;
				boolean goInLoop = !isDivisorMultipleFound(alreadyFound, currentDiv);

				while (goInLoop) {
					int nextT = tempT1 + tempT2 + tempT3;
					nextT %= currentDiv;
					if (nextT == 0) {
						isDivisor = true;
						break;
					}

					tempT1 = tempT2;
					tempT2 = tempT3;
					tempT3 = nextT;

					if (tempT1 == t1 && tempT2 == t2 && tempT3 == t3) {
						break;
					}
				}
				if (!goInLoop || !isDivisor) {
					alreadyFound.add(currentDiv);
					numFound++;
				}
			}

			System.out.println(currentDiv);
		}
	}
}
