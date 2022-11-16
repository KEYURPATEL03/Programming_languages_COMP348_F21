using System.IO;
using System;

public interface Shape {
    // property to return object's name
    
     string Name{get;}
    
    // method to return shape's perimeter
    double GetPerimeter();
    // method to return shape's area
    double GetArea();
}

public class Rectangle : Shape{
    
    double length { 
        get ; 
        set ;
    }
    double breadth { 
        get ; 
        set ;
    }
    
    //constructor with no argument
    public Rectangle(){

        length=0;
        breadth=0;
    }
    
    //perameterised constructor
    public Rectangle( double side1,double side2){
        
        this.length=side1;
        this.breadth=side2;
    }
    
    public string Name{
        
        get{
            
            return this.GetType().Name ; 
        }
        
    }
    
    //Implementation of GetPerimeter and GetArea methods inherited from the Shape interface.
    public double GetPerimeter(){
        
        return (2*(length+breadth));
    }
    public double GetArea(){
        
        return(length*breadth);
    }
    
    //ToString method
    override public string ToString(){
        
        return (Name+"(length,breadth):"+length+" , "+breadth);
        
    }
}
    
    
public class Circle : Shape{
    
   public double Radius {
        get ;
        set ;
    }
    //constructor with no argument
    public Circle(){

        Radius=0;
    }
    
    //perameterised constructor
    public Circle( double rad){
        
        this.Radius=rad;
    
    }
    
    public string Name{
        
        get{
            
            return this.GetType().Name ; 
        }
        
    }
    
    //Implementation of GetPerimeter and GetArea methods inherited from the Shape interface.
    public double GetPerimeter(){
        
        return (2*Math.PI*Radius);
    }
    public double GetArea(){
        
        return(Math.PI*Radius*Radius);
    }
    
    //ToString method
    override public string ToString(){
        
        return (Name+","+Radius);
        
    }
    
    
    
}