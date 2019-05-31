package com.tm.palindrome;

import java.util.Scanner;

public class AllPalindromes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().trim();
		System.out.println(countPlindrom(str));
		sc.close();
	}

	private static int countPlindrom(String str) {
		String temp = "";
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				temp = str.substring(i, j);
				if (isPalindrome(temp)) {
					count++;
				}
			}
		}
		return count;
	}

	private static boolean isPalindrome(String temp) {
		int j = temp.length() - 1;
		for (int i = 0; i < j; i++) {
			if (temp.charAt(i) != temp.charAt(j)) {
				return false;
			}
			j--;
		}
		return true;
	}
}
