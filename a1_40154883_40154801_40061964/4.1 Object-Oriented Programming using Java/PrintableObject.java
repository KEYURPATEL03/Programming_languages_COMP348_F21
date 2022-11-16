//--------------------------------------------------------------------------
// Comp 348 Assignment 1 Question 1
// Written by- Julien Gilbert 40061964, Nirmal Ghinaiya 40154801, Keyur Patel 40154883
// This abstract class implements NamedObject and Printable interfaces.
//--------------------------------------------------------------------------
public abstract class PrintableObject implements NamedObject, Printable {
    // returns the name of the class of the calling object
    public String toString() {
        return this.getName();
    }

    // prints on the console the name of the class of the calling object
    public void print() {
        System.out.println(this.toString());
    }
}
