package prob06;

public class Add extends Arith {
	public Add(int a, int b) {
		super(a, b);
	}

	@Override
	public int calculate() {
		return a+b;
	}
}
