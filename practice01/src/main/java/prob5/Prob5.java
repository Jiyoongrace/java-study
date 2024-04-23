package prob5;

public class Prob5 {

	public static void main(String[] args) {

		for (int i=1; i<=99; i++) {
			String str = Integer.toString(i);
			for (int j=0; j<str.length(); j++) {
				if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
					System.out.println(i + " 짝");
				}
			}

		}

	}
}
