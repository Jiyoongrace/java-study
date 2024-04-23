package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 정답 랜덤하게 만들기
		Random random = new Random();

		while(true) {
			int correctNumber = random.nextInt(100) + 1;
			// System.out.println(correctNumber);
			System.out.println("수를 결정하였습니다. 맞추어 보세요.");

			int cnt = 1;
			int min = 1;
			int max = 100;
			/* 게임 작성 */
			while (true) {
				System.out.println(min + "-" + max);
				System.out.print(cnt + ">>");
				int num = scanner.nextInt();

				if (num > correctNumber) {
					System.out.println("더 낮게");
					max = num;
				} else if (num < correctNumber) {
					System.out.println("더 높게");
					min = num;
				} else if (num == correctNumber) {
					System.out.println("맞았습니다.");
					//새 게임 여부 확인하기
					System.out.print("다시 하겠습니까(y/n)>>");
					String answer = scanner.next();
					if ("y".equals(answer) == false) {
						break;
					} else {
						correctNumber = random.nextInt(100) + 1;
						min = 1;
						max = 100;
						cnt = 0;
						System.out.println("수를 결정하였습니다. 맞추어 보세요.");
					}
				}
				cnt++;
			}
			scanner.close();
			break;
		}
	}
}