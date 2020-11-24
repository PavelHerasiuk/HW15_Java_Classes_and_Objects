package by.epam.triangle.main;

import java.util.Locale;

// 7. Описать класс, представляющий треугольник. Предусмотреть методы для создания
//  объектов, вычисления площади, периметра и точки пересечения медиан.

public class Triangle {
    private final Side A;
    private final Side B;
    private final Side C;

    private Triangle(Side a, Side b, Side c) {
        A = a;
        B = b;
        C = c;
    }

    private static Triangle createTriangle(Point a, Point b, Point c) {
        Side A = new Side(a, b);
        Side B = new Side(b, c);
        Side C = new Side(a, c);
        return new Triangle(A, B, C);
    }

    private double calculatePerimeter() {
        return A.calculateSide() + B.calculateSide() + C.calculateSide();
    }

    private double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - A.calculateSide()) * (p - B.calculateSide()) * (p - C.calculateSide()));
    }

    private Point pointMedianIntersection() {
        double x = (A.getA().getX() + A.getB().getX() + B.getB().getX()) / 3;
        double y = (A.getA().getY() + A.getB().getY() + B.getB().getY()) / 3;
        return new Point(x, y);
    }

    public static void main(String[] args) {
        Point a = new Point(-3, -3);
        Point b = new Point(5, 6);
        Point c = new Point(4, 2);
        System.out.printf(Locale.US, "Координаты треугольника: a(%.1f,%.1f); b(%.1f,%.1f); c(%.1f,%.1f).%n",
                a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY());

        Triangle triangle = createTriangle(a, b, c);

        double perimeter = triangle.calculatePerimeter();
        System.out.printf(Locale.US, "Периметр треугольника: %f.%n", perimeter);

        double area = triangle.calculateArea();
        System.out.printf(Locale.US, "Площадь треугольника: %f.%n", area);

        Point o = triangle.pointMedianIntersection();
        System.out.printf(Locale.US, "Точки пересечения медиан: o(%f,%f).", o.getX(), o.getY());
    }
}