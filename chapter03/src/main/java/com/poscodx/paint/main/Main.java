package com.poscodx.paint.main;

import com.poscodx.paint.i.Drawable;
import com.poscodx.paint.point.ColorPoint;
import com.poscodx.paint.point.Point;
import com.poscodx.paint.shape.Circle;
import com.poscodx.paint.shape.Rectangle;
import com.poscodx.paint.shape.Shape;
import com.poscodx.paint.shape.Triangle;
import com.poscodx.paint.text.GraphicText;

public class Main {
    public static void main(String[] args) {
        Point point1 = new Point(10, 20);
//        point.setX(10);
//        point.setY(20);
//        drawPoint(point);
//        point.disappear();
        draw(point1);
        point1.show(false);

        ColorPoint point2 = new ColorPoint(100, 200, "red");
        // drawColorPoint(point2);
        // drawPoint(point2);
        // point2.show(true);
        draw(point2);

        // drawTriangle(new Triangle());
//        drawShape(new Triangle());
//        drawShape(new Rectangle());
//        drawShape(new Circle());
        draw(new Triangle());
        draw(new Rectangle());
        draw(new Circle());

        draw(new GraphicText("hello world"));

        // instanceof 연산자
        // 객체가 특정 클래스에 속하는지 아닌지 확인
        // 상속 관계도 확인
        // c instanceof Circle
        // -> c가 Class에 속하거나 Class를 상속받는 클래스에 속하면 true 반환
        // 생성자 함수, Array 같은 내장 클래스도 사용 가능
        Circle c = new Circle();
        System.out.println(c instanceof Circle);
        System.out.println(c instanceof Shape);
        System.out.println(c instanceof Object);

        // 오류: 연산자 우측항이 클래스인 경우,
        // 레퍼런스 하고 있는 class 타입의 hierachy 계층 상의 하위 상위만
        // instanceof 연산자를 사용할 수 있다.
        // System.out.println(c instanceof Point);

        Object o = new Circle();
        System.out.println(o instanceof String);

        // 연산자 우측항이 인터페이스인 경우
        // Hierachy 상관없이 instanceof 연산자를 사용할 수 있다.
        System.out.println(c instanceof Drawable);
        System.out.println(c instanceof Runnable);
    }

    private static void draw(Drawable drawable) {
        drawable.draw();
    }

//    private static void drawShape(Shape shape) {
//        shape.show();
//    }

//    private static void drawPoint(Point point) {
//        point.show();
//    }

    //    private static void drawColorPoint(ColorPoint colorPoint) {
//        colorPoint.show();
//    }

//    private static void drawTriangle(Triangle triangle) {
//        triangle.draw();
//    }
//
//    private static void drawRectangle(Rectangle rectangle) {
//        rectangle.draw();
//    }
//
}


