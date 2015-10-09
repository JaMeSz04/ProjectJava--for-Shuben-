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
public class Room {
    Teacher teacherRoom;
    Teacher coTeacher;
    ArrayList<Student> studentList;
    
    public Room(ArrayList<Student> studentList,Teacher teacherRoom,Teacher coTeacher)
    {
       this.studentList = studentList;
       this.teacherRoom = teacherRoom;
       this.coTeacher = coTeacher;
    }
    public Room(Teacher teacherRoom,Teacher coTeacher)
    {
        this.teacherRoom = teacherRoom;
        this.coTeacher = coTeacher;
        studentList = new ArrayList<Student>();
    }
    private void addCourseToStudent()
    {
        
    }
    
    
    
    
    
}
