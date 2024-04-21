package practice;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationProblem {

	static void permutation() {
		Scanner scanner = new Scanner(System.in);
		String string1 = scanner.next();
		String string2 = scanner.next();
		scanner.close();
		stringPermutationCheck(string1, string2);
	}

	private static void stringPermutationCheck(String string1, String string2) {
		int[] dummy1 = new int[128];
		for (int i = 0; i < string1.length(); i++) {
			dummy1[string1.charAt(i)]++;
		}
		for (int i = 0; i < string2.length(); i++) {
			dummy1[string2.charAt(i)]--;
			if (dummy1[string2.charAt(i)] < 0) {
				System.out.println(false);
			}
		}
	}

	// works only for array length 3
	static void arrayPermutation() {
		Scanner scanner = new Scanner(System.in);
		int numbers = scanner.nextInt();
		int[] elements = new int[numbers];
		for (int i = 0; i < numbers; i++) {
			elements[i] = scanner.nextInt();
		}
		scanner.close();
		for (int i = 0; i < elements.length; i++) {
			int[] dummy = new int[elements.length];
			int k = 0;
			dummy[k] = elements[i];
			int j = 0;
			boolean forward = true;
			while (j >= 0) {
				if (i != j && j < elements.length) {
					dummy[++k] = elements[j];
				}
				if (j < elements.length && forward) {
					j++;
				} else if (j == elements.length) {
					System.out.println(Arrays.toString(dummy));
					dummy = new int[elements.length];
					j--;
					forward = false;
					k = 0;
					dummy[k] = elements[i];
				} else {
					j--;
				}
			}
			System.out.println(Arrays.toString(dummy));
		}
	}

	static void arrayPermutations() {
		Scanner scanner = new Scanner(System.in);
		int numbers = scanner.nextInt();
		int[] elements = new int[numbers];
		for (int i = 0; i < numbers; i++) {
			elements[i] = scanner.nextInt();
		}
		scanner.close();
		for (int i = 0; i < elements.length; i++) {
			int[] dummy = new int[elements.length];
			int k = 0;
			dummy[k] = elements[i];
			int j = 0;
			boolean forward = true;
			while (j >= 0) {
				if (i != j && j < elements.length) {
					dummy[++k] = elements[j];
				}
				if (j < elements.length && forward) {
					j++;
				} else if (j == elements.length) {
					System.out.println(Arrays.toString(dummy));
					dummy = new int[elements.length];
					j--;
					forward = false;
					k = 0;
					dummy[k] = elements[i];
				} else {
					j--;
				}
			}
			System.out.println(Arrays.toString(dummy));
		}
	}

	public static void permutationString() {
		Scanner scanner = new Scanner(System.in);
		int numbers = scanner.nextInt();
		int[] elements = new int[numbers];
		for (int i = 0; i < numbers; i++) {
			elements[i] = scanner.nextInt();
		}
		scanner.close();
		permutation(new int[0], elements);
	}

	private static void permutation(int[] dummy, int[] elements) {
		int n = elements.length;
		if (n == 0) {
			System.out.println(Arrays.toString(dummy));
		} else {
			for (int i = 0; i < n; i++) {
				int[] modified = new int[elements.length - 1];
				int k = 0;
				for (int j = 0; j < elements.length; j++) {
					if (elements[i] != elements[j]) {
						modified[k++] = elements[j];
					}
				}
				int[] newArray = new int[dummy.length + 1];
//				int[] newArray = Arrays.copyOf(dummy, dummy.length + 1);
				for (int a = 0; a < dummy.length; a++) {
					newArray[a] = dummy[a];
				}
				newArray[dummy.length] = elements[i];
				permutation(newArray, modified);
			}
		}
	}

}
