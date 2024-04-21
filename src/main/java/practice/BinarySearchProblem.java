package practice;

public class BinarySearchProblem {

	static int banana() {
		int[] piles = { 30, 11, 23, 4, 20 };
		int hours = 6;
		int totalBananas = 0;
		int leftEdge = piles[0];
		for (int pile : piles) {
			totalBananas += pile;
			if (leftEdge > pile) {
				leftEdge = pile;
			}
		}
		int rightEdge = totalBananas;
		int result = 0;

		while (leftEdge <= rightEdge) {
			int midPoint = (leftEdge + rightEdge) / 2;
			if (check(midPoint, hours, piles)) {
				result = midPoint;
				rightEdge = midPoint - 1;
			} else {
				leftEdge = midPoint + 1;
			}
		}
		return result;
	}

	private static boolean check(int midPoint, int hours, int[] piles) {
		int processingHours = 0;
		for (int i = 0; i < piles.length; i++) {
			int quotient = piles[i] / midPoint;
			int reminder = piles[i] % midPoint;
			processingHours += quotient;
			if (reminder != 0) {
				processingHours++;
			}
		}
		return processingHours <= hours;
	}
	
	public static int shipWithinDays() {
		int[] input = { 1, 2, 3, 1, 1 };
		int days = 4;
		int max = input[0];
		int totSum = 0;
		for (int num : input) {
			totSum += num;
			if (num > max) {
				max = num;
			}
		}
		int left = max;
		int right = totSum;
		int ans = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (canWePlace(input, mid, days)) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return ans;
	}

	static boolean canWePlace(int[] input, int mid, int days) {
		int dayC = 1;
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];
			if (sum > mid) {
				dayC++;
				sum = input[i];
			}
		}
		return dayC <= days;
	}
	
}
