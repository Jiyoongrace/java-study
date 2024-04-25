package prob06;

public class Mul extends Arith {
	public Mul(int a, int b) {
		super(a, b);
	}

	@Override
	public int calculate() {
		return a*b;
	}
}
