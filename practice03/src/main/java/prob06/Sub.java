package prob06;

public class Sub extends Arith {
	public Sub(int a, int b) {
		super(a, b);
	}

	@Override
	public int calculate() {
		return a-b;
	}
}
