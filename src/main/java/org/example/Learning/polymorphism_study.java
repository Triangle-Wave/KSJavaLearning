package org.example.Learning;

public class polymorphism_study {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

/**
 * shape
 */
// class shape {
//     void draw() {

//     }
// }

// class circle extends shape(){
//     void draw(){
//         System.out.println("This is a circle");
//     }
// }
class Shape {
    void draw() {}
}
class Circle extends Shape {
    void draw() {
        System.out.println("Circle.draw()");
    }
}