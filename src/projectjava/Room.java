/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Room {

    Teacher teacherRoom;
    Teacher coTeacher;
    int roomNum;
    ArrayList<Student> studentList;
    ArrayList<Course> courseForRoom;

    public Room(ArrayList<Student> studentList, Teacher teacherRoom, Teacher coTeacher) {
        this.studentList = studentList;
        this.teacherRoom = teacherRoom;
        this.coTeacher = coTeacher;
        studentList = new ArrayList<Student>();
        courseForRoom = new ArrayList<Course>();
        addCourseToAllStudent();

    }

    public Room(Teacher teacherRoom, Teacher coTeacher) {
        this.teacherRoom = teacherRoom;
        this.coTeacher = coTeacher;
        studentList = new ArrayList<Student>();
        courseForRoom = new ArrayList<Course>();
        addCourseToAllStudent();

    }
    
    public String getRoomName()
    {
        return Integer.toString(roomNum);
    }

    public void addStudent(Student a) {
        studentList.add(a);
        addCourseToStudent(a);
    }

    private void addCourseToStudent(Student a) {
        if (courseForRoom.size() != 0) {
            for (Course c : courseForRoom) {
                a.addCourse(c);
            }
        }
    }

    public ArrayList<Student> getStudents() {
        return studentList;
    }

    private void addCourseToAllStudent() {
        if (courseForRoom.size() != 0) {
            for (Student a : studentList) {
                addCourseToStudent(a);
            }
        }
    }

    public ArrayList<Student> rankStudentByScore() {
        ArrayList<Student> a = new ArrayList<Student>();
        a = studentList;
        Collections.sort(a, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getGPS() > o2.getGPS()) {
                    return 1;
                } else if (o1.getGPS() < o2.getGPS()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return a;
    }

    public ArrayList<Student> rankStudentByID() {
        ArrayList<Student> a = new ArrayList<Student>();
        a = studentList;
        Collections.sort(a, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getID() > o2.getID()) {
                    return 1;
                } else if (o1.getID() < o2.getID()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return a;
    }

}
