# import classes defined in question 5
from question5 import Shape, Circle, Rhombus, Ellipse

# initialize counters for statistics
circleCount = 0
ellipseCount = 0
rhombusCount = 0
shapeCount = 0

# open txt file
with open("file.txt", "r") as file:
    data = file.readlines()  # reads one line at the time
    for line in data:
        # splits the each group of characters.
        word = line.split()
        # Circle
        if word[0].lower() == "circle":
            try:
                aCircle = Circle(int(word[1]))
                aCircle.print()
                circleCount += 1
            except:
                print("Error occured while trying to create a CIRCLE")

        # Ellipse
        elif word[0].lower() == "ellipse":
            try:
                anEllipse = Ellipse(int(word[1]), int(word[2]))
                if anEllipse.area() == "undefined":
                    print("Error: Invalid Ellipse")
                    anEllipse.print()
                    ellipseCount += 1
                else:
                    anEllipse.print()
                    print(
                        "Linear eccentricity: {:<6.4f}".format(anEllipse.eccentricity())
                    )
            except:
                print("Error occured while trying to create an ELLIPSE")
        # Rhombus
        elif word[0].lower() == "rhombus":
            try:
                aRhombus = Rhombus(int(word[1]), int(word[2]))
                if aRhombus.area() == "undefined":
                    print("Error: Invalid Rhombus")
                    aRhombus.print()
                    rhombusCount += 1
                else:
                    aRhombus.print()
                    print("in-radius: {:<6.4f}".format(aRhombus.inradius()))
            except:
                print("Error occured while trying to create a RHOMBUS")
        # Shape
        elif word[0].lower() == "shape":
            aShape = Shape()
            aShape.print()
            shapeCount += 1
        else:
            print('"{0}" is not a known shape.'.format(word[0]))

# how many shapes were created
shapeCount += circleCount + ellipseCount + rhombusCount

thisDict = {
    "Circle(s)": circleCount,
    "Ellipse(s)": ellipseCount,
    "Rhombus(es)": rhombusCount,
    "Shape(s)": shapeCount,
}

# display the statistics using a dictionnary
print("statistics")
for x in thisDict:
    print("\t{0}: {1}".format(x, thisDict[x]))
