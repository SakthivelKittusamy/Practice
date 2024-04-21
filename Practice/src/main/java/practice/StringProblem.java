package practice;

import java.util.Scanner;

public class StringProblem {
	static boolean uniqueChar() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		scanner.close();
		char[] charArray = input.toCharArray();
		boolean unique = true;
		for (int i = 0; i < charArray.length - 1; i++) {
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] == charArray[j]) {
					unique = false;
				}
			}
		}
		return unique;
	}

	static boolean uniqueCharSimple() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		scanner.close();
		int[] dummy = new int[256];
		boolean unique = true;
		for (int i = 0; i < input.length(); i++) {
			char aa = input.charAt(i);
			if (dummy[aa] == 0) {
				dummy[aa]++;
			} else {
				unique = false;
			}
		}
		return unique;
	}
}
