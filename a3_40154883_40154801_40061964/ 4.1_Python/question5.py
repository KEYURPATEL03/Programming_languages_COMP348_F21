import math

# Parent class
class Shape:
    count = 0

    # constructor with no parameter
    def __init__(self):
        Shape.count += 1  # increment the count of shapes
        self._id = Shape.count  # assign a unique ID to each new shape

    # default print() method.
    def print(self):
        if isinstance(self.perimeter(), str):  # is the perimeter well defined
            if isinstance(self.area(), str):  # is the area well defined
                print(
                    "{0}: {1}, perimeter: undefined, area: undefined".format(
                        self._id, self.__class__.__name__
                    )
                )
            else:
                print(
                    "{0}: {1}, perimeter: undefined, area: {2:<6.4f}".format(
                        self._id, self.__class__.__name__, self.area()
                    )
                )
        else:  # area and perimeter are both float, apply formating
            print(
                "{0}: {1}, perimeter: {2:<6.4f}, area: {3:<6.4f}".format(
                    self._id, self.__class__.__name__, self.perimeter(), self.area()
                )
            )
        return None

    # perimeter function
    def perimeter(self):
        return "undefined"

    # area function
    def area(self):
        return "undefined"


# Circle class, child of Shape class
class Circle(Shape):
    def __init__(self, radius):
        Shape.__init__(self)
        self._radius = radius

    # overrides parent function
    def perimeter(self):
        if self._radius > 0:
            return self._radius * 2 * math.pi
        else:
            return "undefined"

    # overrides parent function
    def area(self):
        if self._radius > 0:
            return self._radius ** 2 * math.pi
        else:
            return "undefined"


# Ellipse class, child of Shape class
class Ellipse(Shape):
    def __init__(self, a, b):
        Shape.__init__(self)
        if a > b:
            self._semiMajor = a
            self._semiMinor = b
        else:
            self._semiMajor = b
            self._semiMinor = a

    # overrides parent function
    def area(self):
        if self._semiMajor > 0 and self._semiMinor > 0:  # checks validity of attributes
            return math.pi * self._semiMajor * self._semiMinor
        else:
            return "undefined"

    def eccentricity(self):
        if self._semiMajor > 0 and self._semiMinor > 0:
            return math.sqrt(self._semiMajor ** 2 - self._semiMinor ** 2)
        else:
            return "undefined"


# Rhombus class, child of Shape class
class Rhombus(Shape):
    def __init__(self, p, q):
        Shape.__init__(self)
        self._p = p
        self._q = q

    # overrides parent class
    def perimeter(self):
        if self._p >= 0 and self._q >= 0:
            return 2 * (math.sqrt(self._p ** 2 + self._q ** 2))
        else:
            return "undefined"

    # overrides parent class
    def area(self):
        if self._p >= 0 and self._q >= 0:
            return (self._p * self._q) / 2
        else:
            return "undefined"

    def inradius(self):
        if self._p >= 0 and self._q >= 0:
            return self._p * self._q / (2 * math.sqrt(self._p ** 2 + self._q ** 2))
        else:
            return "undefined"
