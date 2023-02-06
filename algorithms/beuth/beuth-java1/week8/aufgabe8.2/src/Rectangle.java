/**
 * Class to test Rectangle.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 11/2018
 */

public class Rectangle extends Shape {
    public double xDelta;
    public double yDelta;
    public String name = "Rectangle";

    public Rectangle(int xOrigin, int yOrigin, double xDelta, double yDelta) {
        super(xOrigin, yOrigin);
        this.xDelta = xDelta;
        this.yDelta = yDelta;
    }

    @Override
    public double circumference() {
       return 2 * this.xOrigin + 2 * this.yOrigin;
    }

    @Override
    public double area() {
        return this.xOrigin * this.yOrigin;
    }

    @Override
    public String toString() {
        return this.name + " with origin: (" + this.xOrigin  + ", " + this.yOrigin + ") xDelta:" + this.xDelta + ", yDelta: " + this.yDelta + " / Area: " + this.area() + " / Circumference:" + this.circumference();
    }

    public String getName() {
        return this.name;
    }
}
