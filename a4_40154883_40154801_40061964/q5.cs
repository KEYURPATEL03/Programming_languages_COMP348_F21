using System;

namespace ExtensionMethods 
{
    public static class Extensions   
    {
        public static void Print(this Shape shape)   //print method to print objects info
        {
            Console.WriteLine(shape.ToString());
        }
    }
}
public partial class Rectangle
{
    public static Rectangle Parse(string input)     // rectangle method to parse the input string which is in comma separated format and return rectangle object.
    {
        string[] inputs = input.Split(',');
        return new Rectangle(Convert.ToDouble(inputs[1]), Convert.ToDouble(inputs[2]));
    }
}

public partial class Circle
{
    public static Circle Parse(string input)     // Circle method to parse the input string which is in comma separated format and return circle object.
    {
        string[] inputs = input.Split(',');
        return new Circle(Convert.ToDouble(inputs[1]));
    }
}