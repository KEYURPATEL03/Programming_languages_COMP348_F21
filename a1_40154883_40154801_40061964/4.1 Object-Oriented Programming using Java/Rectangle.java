//--------------------------------------------------------------------------
// Comp 348 Assignment 1 Question 1
// Written by- Julien Gilbert 40061964, Nirmal Ghinaiya 40154801, Keyur Patel 40154883
// This class extends the PrintableObject abstract class and implements the
// Shape interface. One of two shapes implemented.
//--------------------------------------------------------------------------
public class Rectangle extends PrintableObject implements Shape {
    // parse method which reads a string and returns a Rectangle object with the
    // defined width and length
    public static Rectangle parse(String stringToParse) {
        int indexOfFirstComma = stringToParse.indexOf(",", 0);
        int indexOfSecondComma = stringToParse.indexOf(",", indexOfFirstComma + 1);
        double length = Double.parseDouble(stringToParse.substring(indexOfFirstComma + 1, indexOfSecondComma));
        double width = Double.parseDouble(stringToParse.substring(indexOfSecondComma + 1, stringToParse.length()));
        return new Rectangle(width, length);
    }

    // instance variable needed to define a rectangle
    private double width;
    private double length;

    // no argument constructor
    public Rectangle() {
        setWidth(0);
        setLength(0);
    }

    // Constructor with arguments
    public Rectangle(double width, double length) {
        setWidth(width);
        setLength(length);
    }

    // getters and setters
    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double newWidth) {
        this.width = newWidth;
    }

    public void setLength(double newLength) {
        this.length = newLength;
    }

    // toString method
    public String toString() {
        return super.toString() + " width: " + this.getWidth() + ", length: " + this.getLength();
    }

    // implementation of getArea() from Shape interface
    public double getArea() {
        return width * length;
    }

    // implementation of getPerimeter() from Shape interface
    public double getPerimeter() {
        return 2 * (width + length);
    }

}
