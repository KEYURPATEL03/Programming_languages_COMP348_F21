//--------------------------------------------------------------------------
// Comp 348 Assignment 4 Question 1
// Written by- Julien Gilbert 40061964
// This class extends the PrintableObject abstract class and implements the
// Shape interface.
//--------------------------------------------------------------------------
public interface NamedObject {

    // returns the name of the object (provides a default implementation)
    default String getName() {
        return this.getClass().getName(); // will return patate no matter who calls it ****
    }

}
// FROM A1