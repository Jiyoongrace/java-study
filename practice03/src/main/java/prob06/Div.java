package prob06;

public class Div extends Arith {
	public Div(int a, int b) {
		super(a, b);
	}

	@Override
	public int calculate() {
		return a/b;
	}
}
