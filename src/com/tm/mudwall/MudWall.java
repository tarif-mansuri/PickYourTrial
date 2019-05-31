package com.tm.mudwall;

import java.util.Scanner;

public class MudWall {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int positions[] = new int[n];
		int sticks[] = new int[n];
		for (int i = 0; i < n; i++) {
			positions[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			sticks[i] = sc.nextInt();
		}
		int maxHeight = 0;
		for (int i = 0; i < n - 1; i++) {
			int gap = positions[i + 1] - positions[i] - 1;
			int stickDiff = sticks[i + 1] - sticks[i];
			int smallerStick = sticks[i];
			int biggerStick = sticks[i + 1];
			if (stickDiff < 0) {
				stickDiff = -stickDiff;
				smallerStick = sticks[i + 1];
				biggerStick = sticks[i];
			}
			if (gap == stickDiff) {
				maxHeight = maxHeight > biggerStick + 1 ? maxHeight : biggerStick + 1;
			} else if (gap > stickDiff) {
				int temp = biggerStick + (int) ((gap - biggerStick + smallerStick + 1) / 2);
				maxHeight = maxHeight > temp ? maxHeight : temp;
			} else {
				maxHeight = maxHeight > gap + smallerStick ? maxHeight : gap + smallerStick;
			}
		}
		System.out.println(maxHeight);
		sc.close();

	}

}
