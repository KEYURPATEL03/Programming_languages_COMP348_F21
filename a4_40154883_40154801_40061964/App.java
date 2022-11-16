
//--------------------------------------------------------------------------
// Comp 348 Assignment 4 Question 1
// Written by- Julien Gilbert 40061964
// Driver class which Read a file containing at least 7 shapes, parse and 
//store the shapes in an array of Shapes, sort the shapes by name then by area
//and finally prints the sorted element.
//--------------------------------------------------------------------------
import java.util.Arrays; //to convert the array of string into a stream
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;
import java.nio.file.*;

public class App {
    static Shape createShape(String aString) {

        int indexOfFirstComma = aString.indexOf(",", 0);

        String shape = aString.substring(0, indexOfFirstComma);
        switch (shape) {
            case "Rectangle":
                Rectangle aRectangle = Rectangle.parse(aString);
                return aRectangle;
            case "Circle":
                Circle aCircle = Circle.parse(aString);
                return aCircle;
            case "Rhombus":
                Rhombus aRhombus = Rhombus.parse(aString);
                return aRhombus;
            default:
                return new Rectangle();
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in); // create scanner input stream
        System.out.print("\nWhat is the name of the file from which the shapes will be read?: ");
        String fileName = in.next();
        // Shape[] shapesArr = new Shape[numOfShapes];
        // String[] shapes = new String[numOfShapes];

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            Stream<String> lines = br.lines(); // stream containing the input lines
            List<Shape> shapeList = lines.map(x -> createShape(x)).collect(Collectors.toList()); // list containing all
                                                                                                 // the shapes.
            // sorting by area.
            Collections.sort(shapeList, Comparator.comparingDouble(Shape::getArea));
            // sorting by name and outputting
            System.out.println("\n--- Sorted by name and area ---");
            shapeList.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).forEach(System.out::println);
            System.out.println("\n--- Sorted by perimeter only ---");
            Collections.sort(shapeList, Comparator.comparingDouble(Shape::getPerimeter));
            shapeList.forEach(e -> System.out.println(e));

            Map<String, Long> counting = shapeList.stream()
                    .collect(Collectors.groupingBy(Shape::getName, Collectors.counting()));

            System.out.println(counting);

            System.out.println("\n--- Average perimeter ---");

            Map<String, Double> perimeterAverage = shapeList.stream()
                    .collect(Collectors.groupingBy(Shape::getName, Collectors.averagingDouble(Shape::getPerimeter)));

            System.out.println(perimeterAverage);

            System.out.println("\n--- Average area ---");

            Map<String, Double> areaAverage = shapeList.stream()
                    .collect(Collectors.groupingBy(Shape::getName, Collectors.averagingDouble(Shape::getArea)));

            System.out.println(areaAverage);

            // Q3
            System.out.print("\n--- Q3 ---");
            shapeList.stream().forEach(System.out::println);

        } catch (Exception e) {
            String message = e.getMessage();
            System.out.println("there was an exception raised: " + message);
            System.exit(0);
        } finally {
            in.close(); // close scanner input.
        }

    }
}
