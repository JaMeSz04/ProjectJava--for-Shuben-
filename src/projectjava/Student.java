/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.util.ArrayList;

/**
 *
 * @author Patipon
 */
public class Student extends Person {

    int studentId;
    StudentType type;
    int grade; //level
    ArrayList<Course> courseList;
    Room room;

    public Student(String name, int age, int grade) {
        super(name, age);
        generateUserId();
        generateType();
        generateRoom();

    }

    public double getGPS() {
        double sum = 0;
        for (Course c : courseList) {
            try {
                sum += c.getStudentGrade(this);
            } catch (IllegalArgumentException e) {
                return -1;
            }
        }
        return sum / courseList.size();
    }

    private void generateType() {
        if (grade < 7) {
            type = StudentType.PRIMARY;
        } else {
            type = StudentType.SECONDARY;
        }
    }

    private void generateRoom() {
        //
    }

    private void generateUserId() {
        //set value to studentID;
    }
    
    public void addCourse(Course c)
    {
        if (c.hasStudent(this))
            throw new IllegalArgumentException("Student is already registered on this course");
        else{
            c.addStudent(this);
            courseList.add(c);
        }
    }
    

}
