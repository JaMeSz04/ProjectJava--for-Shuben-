/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

/**
 *
 * @author Patipon
 */
public class BugTester {
    
    
    public static void main(String[] args)
    {
        Teacher teacherOne = new Teacher("Sun", 22);
        Teacher teacherTwo = new Teacher("Krit", 55);
        Student studentOne = new Student("ShubU", 19, 2);
        Student studentTwo = new Student("Shuben", 20, 2);
        Student studentThree = new Student("Shucoyss", 10, 2);
        Course math = new Course("Math3", 0);
        studentOne.addCourse(math);
        
        System.out.println(studentOne.getCourses());
        math.addStudent(studentTwo);
        System.out.println(studentTwo.getCourses());
        math.addStudent(studentThree);
        System.out.println(studentThree.getCourses());
        System.out.println(math.getListStudents());
        System.out.println(math.getMax());

        Room a = new Room(teacherOne, teacherTwo);
        a.addStudent(studentOne);
        a.addStudent(studentTwo);
        System.out.println(a.getStudents());
        
    }
}
