package creational.factorymethod;

import java.util.Map;
import java.util.Scanner;

public class WiseClient {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("화면선택(2d, 3d): ");
        String dimension = scanner.nextLine();

        System.out.print("도형번호: ");
        int shapeNo = scanner.nextInt();

        Screen screen = "3d".equals(dimension) ? new Screen3d() : new Screen2d();
        screen.display(shapeNo);
    }

    // Screen3D
    private static class Screen3d extends Screen {
        private Map<Integer, Drawable> mapShape = Map.of(
                1, new Sphere(),
                2, new Cube()
        );

        @Override
        public Drawable getShape(int shapeNo) {
            return mapShape.get(shapeNo);
        }
    }

    private static class Sphere implements Drawable {
        @Override
        public void draw() {
            System.out.println("구를 그렸습니다.");
        }
    }

    private static class Cube implements Drawable {
        @Override
        public void draw() {
            System.out.println("직육면체를 그렸습니다.");
        }
    }

    private static class Screen2d extends Screen {
        private Map<Integer, Drawable> mapShape = Map.of(
               1, new Triangle(),
               2, new Rectangle()
        );

        @Override
        public Drawable getShape(int shapeNo) {
            return mapShape.get(shapeNo);
        }
    }

    private static class Triangle implements Drawable {
        @Override
        public void draw() {
            System.out.println("삼각형을 그렸습니다.");
        }
    }

    private static class Rectangle implements Drawable {
        @Override
        public void draw() {
            System.out.println("사각형을 그렸습니다.");
        }
    }
}
