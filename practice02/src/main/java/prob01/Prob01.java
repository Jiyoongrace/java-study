package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		System.out.print("금액: ");
		int money = scanner.nextInt();
		/* 코드 작성 */
		for (int i : MONEYS) {
			System.out.println(i + "원 : " + money/i + "개");
			money %= i;
		}
		
		scanner.close();
 	}
}