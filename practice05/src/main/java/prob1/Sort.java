package prob1;

public class Sort {
	
	public static void main(String[] arg) {
	
		int array[] = {5, 9, 3, 8, 60, 20, 1};
		int count =  array.length;
		
		System.out.println("Before sort.");
		
		for (int i=0; i<count; i++) {
			System.out.print(array[i] + " ");
		}

		// 정렬 알고리즘이 적용된 코드를 여기에 작성합니다.
		for (int j=0; j< array.length-1; j++) {
			// 정렬된 리스트 제외
			for (int k=0; k<array.length-1-j; k++) {
				if (array[k] > array[k+1] ) {
					int temp = array[k];
					array[k] = array[k+1];
					array[k+1] = temp;
				}
			}
		}

		
		// 결과 출력
		System.out.println("\nAfter Sort.");
		
		for (int i=0; i<count; i++) {
			System.out.print(array[i] + " ");
		}		
	}
}