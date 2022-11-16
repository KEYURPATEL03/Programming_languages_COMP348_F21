
//--------------------------------------------------------------------------
// Comp 348 Assignment 1 Question 2
// Written by- Julien Gilbert 40061964, Nirmal Ghinaiya 40154801, Keyur Patel 40154883
// Driver class which Read a file containing at least 7 shapes, parse and 
//store the shapes in an array of Shapes, sort the shapes by name then by area
//and finally prints the sorted element.
//--------------------------------------------------------------------------
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in); // create scanner input stream
        System.out.print("How many shapes are in the file document?: ");
        int numOfShapes = in.nextInt();
        System.out.print("\nWhat is the name of the file from which the shapes will be read?: ");
        String fileName = in.next();

        Shape[] shapes = new Shape[numOfShapes];

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            for (int i = 0; i < numOfShapes; i++) {

                String aString = br.readLine();
                int indexOfFirstComma = aString.indexOf(",", 0);

                String shape = aString.substring(0, indexOfFirstComma);
                switch (shape) {
                    case "Rectangle":
                        Rectangle aRectangle = Rectangle.parse(aString);
                        shapes[i] = aRectangle;
                        break;

                    case "Circle":
                        Circle aCircle = Circle.parse(aString);
                        shapes[i] = aCircle;
                        break;
                    default:
                        System.out.println("Not a valid shape.");
                }
            }
            // sorts the shapes by name
            Arrays.sort(shapes, new Comparator<Shape>() {
                public int compare(Shape a, Shape b) {
                    String nameA = a.getName();
                    String nameB = b.getName();
                    int v = nameA.compareTo(nameB);
                    return v;
                }
            });
            // sorts the shapes by area, from the smallest value to the largest
            Arrays.sort(shapes, new Comparator<Shape>() {
                public int compare(Shape a, Shape b) {
                    if (a.getName().compareTo(b.getName()) != 0)
                        return 0;
                    return (int) (a.getArea() - b.getArea());
                }
            });

            Printable.print(java.util.Arrays.copyOf(shapes, shapes.length, Printable[].class));
        } finally {
            in.close(); // close scanner input.
        }
    }
}
