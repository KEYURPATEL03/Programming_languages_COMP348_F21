//--------------------------------------------------------------------------
// Comp 348 Assignment 4 Question 1
// Written by- Julien Gilbert 40061964
// This interface makes sure classes that implement it will also implement 
// a print() method.
//--------------------------------------------------------------------------
public interface Printable {

    // // to print many shape object
    // static void print(Printable... args) {
    // for (Printable element : args)
    // element.print();
    // };

    static void print(<? extends Shape> ... args) {
    for (Printable element : args)
    element.print();
    };
    // to print a single object
    void print();// Prints object's info to the console

}
// FROM A1