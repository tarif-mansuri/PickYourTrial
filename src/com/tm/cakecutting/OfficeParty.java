package com.tm.cakecutting;

import java.text.DecimalFormat;
import java.util.Scanner;

public class OfficeParty {
	private static final double PI = 3.14159265359;

	public static String getMaxRadiusCake(int[] cakes, int noOfGuest) {
		double maxArea = 0.0;
		int noOfCakes = cakes.length;
		for (int i = 0; i < noOfCakes; i++) {
			Integer iCakeRadius = cakes[i];
			double iAreaOfCake = PI * iCakeRadius * iCakeRadius;

			for (int j = noOfCakes - 1; j >= i; j--) {
				Integer jCakeRadius = cakes[j];
				double jAreaOfCake = PI * jCakeRadius * jCakeRadius;

				double sol1 = jAreaOfCake / (noOfGuest / (noOfCakes - j));
				double sol2 = jAreaOfCake / (int) sol1;

				if (sol1 <= iAreaOfCake && sol1 > maxArea) {
					maxArea = sol1;
					break;
				} else if (sol2 <= iAreaOfCake && sol2 > maxArea) {
					maxArea = sol2;
					break;
				}
			}
		}

		DecimalFormat DoubleToStringFormat = new DecimalFormat("#.####");
		return DoubleToStringFormat.format(maxArea);
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int numOfCakes = sc.nextInt();
		int[] cakes = new int[numOfCakes];
		for (int i = 0; i < cakes.length; i++) {
			cakes[i] = sc.nextInt();
		}
		int numOfGuest = sc.nextInt();
		System.out.println(getMaxRadiusCake(cakes, numOfGuest));
		sc.close();
	}
}