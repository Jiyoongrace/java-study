package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String text = scanner.nextLine();
		char[] array = new char[text.length()];

		for (int i=0; i<array.length; i++) {
			array[i] = text.charAt(i);
		}

		int k = array.length;
		for (int j=0; j<array.length; j++) {
			for (int m=0; m<=array.length-k; m++) {
				System.out.print(array[m]);
			}
			k--;
			System.out.println();
		}
		
		scanner.close();
	}

}
