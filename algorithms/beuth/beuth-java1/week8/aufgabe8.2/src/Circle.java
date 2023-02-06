/**
 * Class to test Rectangle.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 11/2018
 */

public class Circle extends Shape {
    public double radius;
    public double pi = 3.14;
    public String name = "Circle";

    public Circle(int xOrigin, int yOrigin, double radius) {
        super(xOrigin, yOrigin);
        this.radius = radius;
    }

    @Override
    public double circumference() {
        return 2 * pi * this.radius;
    }

    @Override
    public double area() {
        return pi * this.radius * this.radius;
    }

    @Override
    public String toString() {
        return this.name + " with origin: (" + this.xOrigin  + ", " + this.yOrigin + ") and radius:" + this.radius + ", / Area: " + this.area() + " / Circumference:" + this.circumference();
    }

    public String getName() {
        return this.name;
    }
}
