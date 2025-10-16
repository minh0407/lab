






/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab211_2;

/**
 *
 * @author Personal
 */
public class Student {
    private String name  ; 
    private String classes ; 
    private float AVG;

    public Student(String name, String classes, float AVG) {
        this.name = name;
        this.classes = classes;
        this.AVG = AVG;
    }

    public Student() {
    }

    public float getAVG() {
        return AVG;
    }

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }

    

    public String getRate(){
    if(AVG>=9)return "A";
    else if(AVG>=7) return "B";
    else if(AVG>=5) return "C";
    else{return "F";}
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", classes=" + classes + ", AVG=" + AVG + '}';
    }

   
    
}
