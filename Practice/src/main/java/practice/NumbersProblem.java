package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumbersProblem {

	static void printNumbers() {
		Scanner scanner = new Scanner(System.in);
		int limit = scanner.nextInt();
		scanner.close();
		callPrint(limit);
	}

	private static void callPrint(int limit) {
		if (0 < limit) {
			System.out.println(limit);
			limit--;
			callPrint(limit);
		}
	}

	static void fibonacci() {
		Scanner scanner = new Scanner(System.in);
		int limit = scanner.nextInt();
		scanner.close();
		int a1 = 0;
		int a2 = 1;
		callFibonacci(a1, a2, limit);
		System.out.println(callFibonaccis(limit));
	}

	private static void callFibonacci(int a1, int a2, int limit) {
		if (0 < limit) {
			int temp = a1 + a2;
			System.out.println(temp);
			a1 = a2;
			a2 = temp;
			limit--;
			callFibonacci(a1, a2, limit);
		}
	}

	private static int callFibonaccis(int limit) {
		if (limit <= 1) {
			return limit;
		} else {
			return callFibonaccis(limit - 1) + callFibonaccis(limit - 2);
		}
	}

	static void factorial() {
		Scanner scanner = new Scanner(System.in);
		int limit = scanner.nextInt();
		scanner.close();
		System.out.println(callFactorial(limit));
	}

	private static int callFactorial(int limit) {
		if (0 < limit) {
			return limit * callFactorial(limit - 1);
		} else {
			return 1;
		}
	}

	public static void subset() {
		Scanner scanner = new Scanner(System.in);
		int numbers = scanner.nextInt();
		List<Object> elements = new ArrayList<>();
		for (int i = 0; i < numbers; i++) {
			elements.add(scanner.nextInt());
		}
		scanner.close();
		List<Object> result = new ArrayList<>();
		for (int position = 0; position <= elements.size(); position++) {
			List<Object> temp = new ArrayList<>();
			callSubset(position, elements, result, temp, 0);
		}
		System.out.println(result);
	}

	private static void callSubset(int position, List<Object> elements, List<Object> result, List<Object> temp,
			int counter) {
		if (position == temp.size()) {
			result.add(temp);
		} else {
			for (int i = 0 + counter; i < elements.size(); i++) {
				temp.add(elements.get(i));
				callSubset(position, elements, result, temp, counter + 1);
				if (position == temp.size()) {
					temp = new ArrayList<>();
					counter = position;
				}
			}
		}
	}
	
	static int shipWeight() {
		int[] packageWeights = { 1, 2, 3, 1, 1 };
		int days = 4;
		int minimumWeight = packageWeights[0];
		for (int weight : packageWeights) {
			if (minimumWeight > weight) {
				minimumWeight = weight;
			}
		}
		int totalWeight = 0;
		for (int weight : packageWeights) {
			totalWeight += weight;
		}
		for (minimumWeight = 3; minimumWeight < totalWeight; minimumWeight++) {
			List<Integer> packages = new ArrayList<>();
			List<List<Integer>> container = new ArrayList<>();
			int subTotal = 0;
			for (int j = 0; j < packageWeights.length; j++) {
				subTotal = subTotal + packageWeights[j];
				if (minimumWeight > subTotal) {
					packages.add(packageWeights[j]);
					if (j == packageWeights.length - 1) {
						container.add(packages);
					}
				} else {
					if (minimumWeight == subTotal) {
						packages.add(packageWeights[j]);
					} else {
						if (j == packageWeights.length) {
							container.add(packages);
						} else {
							j--;
						}
					}
					container.add(packages);
					subTotal = 0;
					packages = new ArrayList<>();
				}
			}
			if (days == container.size()) {
				break;
			}
		}
		return minimumWeight;
	}

}
