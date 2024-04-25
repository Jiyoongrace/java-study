package prob06;

abstract public class Arith {
    protected int a;
    protected int b;

    public Arith(int a, int b) {
        this.a = a;
        this.b = b;
    }

//    public void setValue(int a, int b) {
//        this.a = a;
//        this.b = b;
//    }

    abstract public int calculate();
}
