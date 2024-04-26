package com.poscodx.paint.point;

public class ColorPoint extends Point {
    // 상속 후 아무것도 없을 때 에러나는 이유
    // 부모에 기본 생성자가 없으면 자식 클래스에서 에러가 난다.
    private String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y); // 명시하면 부모의 기본 생성자 없어도 됨
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void show() {
        System.out.println("점(x=" + getX() + ", y=" + getY() + ", color=" + color + ")을 그렸습니다.");
    }
}
