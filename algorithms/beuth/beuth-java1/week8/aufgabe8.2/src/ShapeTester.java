/**
 * Class used to test Shape.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 10/2018
 *
 */

public class ShapeTester {
    public static void main(String[] args) {
       Shape shape = new Shape(10, 40);
       Rectangle rect = new Rectangle(20, 30, 35, 15);
       Square square = new Square(30, 20, 5);
       Circle circle = new Circle(50, 10, 25);

       Reporter.report(shape);
       Reporter.report(rect);
       Reporter.report(square);
       Reporter.report(circle);
    }
}
