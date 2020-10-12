import java.lang.Math;

public abstract class Shape {
    public abstract double getArea();
    public abstract String getName();
}

abstract class Shape2D extends Shape {

}

abstract class Shape3D extends Shape {
    public abstract double getVolume();
}

class Square extends Shape2D {
    double sideLength;
    String shapeName;

    public Square(double sideLength) {
        this.shapeName = "square";
        this.sideLength = sideLength;
    }

    public String getName() {
        return this.shapeName;
    }

    public double getArea() {
        return this.sideLength * this.sideLength;
    }
}

class Triangle extends Shape2D {
    double base, height;
    String shapeName;

    public Triangle(double base, double height) {
        this.shapeName = "triangle";
        this.base = base;
        this.height = height;
    }

    public String getName() {
        return this.shapeName;
    }

    public double getArea() {
        return this.base * this.height * 0.5;
    }
}

class Circle extends Shape2D {
    double radius;
    String shapeName;

    public Circle(double radius) {
        this.shapeName = "circle";
        this.radius = radius;
    }

    public String getName() {
        return this.shapeName;
    }

    public double getArea() {
        return Math.PI * (this.radius * this.radius);
    }
}

class Cube extends Shape3D {
    double sideLength;
    String shapeName;

    public Cube(double sideLength) {
        this.shapeName = "cube";
        this.sideLength = sideLength;
    }

    public String getName() {
        return this.shapeName;
    }

    public double getArea() {
        return 6 * this.sideLength * this.sideLength;
    }

    public double getVolume() {
        return this.sideLength * this.sideLength * this.sideLength;
    }
}

class Pyramid extends Shape3D {
    double length, width, height;
    String shapeName;

    public Pyramid(double length, double width, double height) {
        this.shapeName = "pyramid";
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public String getName() {
        return this.shapeName;
    }

    public double getArea() {
        return (this.length * this.width)
                + (length * Math.sqrt(Math.pow(this.width / 2, 2) + Math.pow(this.height, 2)))
                + (width * Math.sqrt(Math.pow(this.length / 2, 2) + Math.pow(this.height, 2)));
    }

    public double getVolume() {
        return (this.length * this.width * this.height) / 3;
    }
}

class Sphere extends Shape3D {
    double radius;
    String shapeName;

    public Sphere(double radius) {
        this.radius = radius;
        this.shapeName = "sphere";
    }

    public String getName() {
        return this.shapeName;
    }

    public double getArea() {
        return 4 * Math.PI * this.radius * this.radius;
    }

    public double getVolume() {
        return (Math.pow(this.radius, 3) * Math.PI * 4 / 3);
    }
}