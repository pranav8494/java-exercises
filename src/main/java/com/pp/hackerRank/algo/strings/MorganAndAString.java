package com.pp.hackerRank.algo.strings;

public class MorganAndAString {

	public static void main(String[] args) {

		String a = "AAA";
		String aa = "AAA";
		String b = "BBB";

		char aChar = 'A';
		char bChar = 'B';

		if (aChar > bChar) {
			System.out.println("a is bigger");
		} else {
			System.out.println("b is bigger");
		}

		String tempA = a.substring(0, 1);
		String tempB = b.substring(0, 1);
		String tempAA = aa.substring(2, 3);
		System.out.println(tempA.compareTo(tempB));
		System.out.println(tempB.compareTo(tempA));
		System.out.println(tempA.compareTo(tempAA));

		System.out.println("DAJACKNIEL".equals(morganAndString("JACK", "DANIEL")));
		System.out.println("AABABACABACABA".equals(morganAndString("ABACABA", "ABACABA")));

		System.out.println("DAJACKNIEL".equals(morganAndStringWithChar("JACK", "DANIEL")));
		System.out.println("AABABACABACABA".equals(morganAndStringWithChar("ABACABA", "ABACABA")));
	}

	static String morganAndStringWithChar(String a, String b) {

		StringBuffer resultSb = new StringBuffer();
		char[] aCharArray = a.toCharArray();
		char[] bCharArray = b.toCharArray();

		int i = 0, j = 0;

		while (i < a.length()) {
			while (j < b.length()) {
				if (bCharArray[j] < aCharArray[i]) {
					resultSb.append(bCharArray[j++]);
				} else {
					resultSb.append(aCharArray[i++]);
					break;
				}
			}
			if (j >= b.length()) {
				for (; i < a.length(); i++) {
					resultSb.append(aCharArray[i]);
				}
			}
		}
		if (j < b.length()) {
			for (; j < b.length(); j++) {
				resultSb.append(bCharArray[j]);
			}
		}
		return resultSb.toString();
	}

	static String morganAndString(String a, String b) {

		int i = 0, j = 0;
		StringBuffer resultSb = new StringBuffer();

		while (i < a.length() && j < b.length()) {
			if (a.charAt(i) < b.charAt(j)) {
				resultSb.append(a.charAt(i++));
			} else if (a.charAt(i) > b.charAt(j)) {
				resultSb.append(b.charAt(j++));
			} else {
				int tempI = i, tempJ = j;
				char aChar = a.charAt(i);
				for (; tempI < a.length() && tempJ < b.length(); tempI++, tempJ++) {
					if (a.charAt(tempI) != b.charAt(tempJ)) {
						break;
					} else if (a.charAt(tempI) > aChar) {
						resultSb.append(a.substring(i, tempI)).append(b.substring(j, tempJ));
						i = tempI;
						j = tempJ;
						aChar = a.charAt(tempI);
					}
				}

				if (tempI == a.length()) {
					resultSb.append(b.charAt(j));
					j++;
				} else if (tempJ == b.length()) {
					resultSb.append(a.charAt(i));
					i++;
				} else {
					if (a.charAt(tempI) < b.charAt(tempJ)) {
						resultSb.append(a.charAt(i));
						i++;
					} else {
						resultSb.append(b.charAt(j));
						j++;
					}
				}
			}
		}

		resultSb.append(a.substring(i)).append(b.substring(j));

		return resultSb.toString();
	}

}
