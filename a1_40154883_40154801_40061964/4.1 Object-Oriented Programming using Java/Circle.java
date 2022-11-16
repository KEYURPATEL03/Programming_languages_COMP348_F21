//--------------------------------------------------------------------------
// Comp 348 Assignment 1 Question 1
// Written by- Julien Gilbert 40061964, Nirmal Ghinaiya 40154801, Keyur Patel 40154883
// This class extends the PrintableObject abstract class and implements the
// Shape interface. One of two shapes implemented.
//--------------------------------------------------------------------------
public class Circle extends PrintableObject implements Shape {
    // parse method which reads a string and returns a Circle object with the
    // defined radius
    public static Circle parse(String stringToParse) {
        int indexOfFirstComma = stringToParse.indexOf(",", 0);
        double radius = Double.parseDouble(stringToParse.substring(indexOfFirstComma + 1, stringToParse.length()));
        return new Circle(radius);
    }

    // only instance variable for an Circle object
    private double radius;

    // no argument constructor
    public Circle() {
        setRadius(0);
    }

    // Constructor with arguments
    public Circle(double radius) {
        setRadius(radius);
    }

    // getters and setters
    public double getRadius() {
        return radius;
    }

    public void setRadius(double newradius) {
        this.radius = newradius;
    }

    // toString method
    public String toString() {
        return super.toString() + " Radius: " + this.getRadius();
    }

    // implementation of getArea() from Shape interface
    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    // implementation of getPerimeter() from Shape interface
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    // implementation of getName() from NamedObject interface
    public String getName() {
        return this.getClass().getName().toUpperCase();
    }
}
