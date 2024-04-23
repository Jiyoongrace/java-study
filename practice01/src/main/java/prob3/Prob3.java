package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		/* 코드 작성 */


		for (int i=0; i<3; i++) {
			int sum = 0;
			System.out.print("숫자를 입력하세요: ");
			int num = scanner.nextInt();
			if (num % 2 == 0) {
				for (int j=0; j<=num; j+=2) {
					sum += j;
				}
			} else {
				for (int k=1; k<=num; k+=2) {
					sum += k;
				}
			}
			System.out.println("결과 값: " + sum);
		}
		
		scanner.close();
	}
}
