//--------------------------------------------------------------------------
// Comp 348 Assignment 1 Question 1
// Written by- Julien Gilbert 40061964, Nirmal Ghinaiya 40154801, Keyur Patel 40154883
// This interface makes sure classes that implement it will also implement 
// a print() method.
//--------------------------------------------------------------------------
public interface Printable {
    // to print many shape object
    static void print(Printable... args) {
        for (Printable element : args)
            element.print();
    };

    // to print a single object
    void print();// Prints object's info to the console

}
