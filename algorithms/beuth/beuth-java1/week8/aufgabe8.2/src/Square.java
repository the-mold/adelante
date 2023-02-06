/**
 * Class to test Square.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 11/2018
 */

public class Square extends Rectangle {
    public String name = "Square";
    public double delta;

    public Square(int xOrigin, int yOrigin, double delta) {
        super(xOrigin, yOrigin, delta, delta);
        this.delta = delta;
    }

    @Override
    public String toString() {
        return this.name + " with origin: (" + this.xOrigin  + ", " + this.yOrigin + ") and delta:" + this.delta + ", / Area: " + this.area() + " / Circumference:" + this.circumference();
    }
}
