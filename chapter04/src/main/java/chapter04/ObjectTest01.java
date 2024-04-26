package chapter04;

public class ObjectTest01 {
    public static void main(String[] args) {
        Point point1 = new Point();
        Point point2 = new Point(3, 4);
        Point point3 = new Point(3, 4);

        Class klass = point1.getClass(); // refrelection
        System.out.println(klass); // class chapter04.Point

        System.out.println(point1.hashCode()); // 990368553(8진수), address 기반의 해싱값
                                                // address X
                                                // reference X
        System.out.println(point3.hashCode());

        System.out.println(point1.toString()); // chapter04.Point@3b07d329, getClass() + "@" + hashCode()
        System.out.println(point1); // 위와 동일

        System.out.println(point2.toString());
    }
}
