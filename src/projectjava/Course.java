/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Patipon
 */

public class Course {

    String courseName;
    String professorName;
    int id;
    Map<Student, Double> gradeList;

    public Course(String name, int id) {
        courseName = name;
        this.id = id;
        gradeList = new HashMap<Student, Double>();
    }

    public Course(String name, String professorName, int id) {
        courseName = name;
        this.professorName = professorName;
        this.id = id;
        gradeList = new HashMap<Student, Double>();
    }
    
    public boolean hasStudent(Student a)
    {
         for (Entry<Student, Double> entry : gradeList.entrySet()) {
            if (entry.getKey().equals(a))
                return true;
        }
        return false;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public int getCourseId() {
        return this.id;
    }

    public void addStudent(Student student) {
        if (!gradeList.containsKey(student)) {
            gradeList.put(student, 0.00);
        } else {
            throw new IllegalArgumentException("the student has already listed in this course");
        }
    }

    public void addStudent(Student student, double grade) {
        if (!gradeList.containsKey(student)) {
            gradeList.put(student, grade);
        } else {
            throw new IllegalArgumentException("the student has already listed in this course");
        }
    }

    public double getMean() {
        double sum = 0;
        for (Entry<Student, Double> entry : gradeList.entrySet()) {
            sum += entry.getValue();
        }
        return sum / gradeList.size();
    }

    public double getMax() {
        double maxVal = 0;
        for (Entry<Student, Double> entry : gradeList.entrySet()) {
            if (entry.getValue() > maxVal) {
                maxVal = entry.getValue();
            }
        }
        return maxVal;
    }

    public double getMin() {
        double minVal = getMax();
        for (Entry<Student, Double> entry : gradeList.entrySet()) {
            if (entry.getValue() < minVal) {
                minVal = entry.getValue();
            }
        }
        return minVal;
    }

    public int getRankByName(Student student) {
        int i = 1;
        if (gradeList.containsKey(student)) {
            ArrayList<Double> mapValue = new ArrayList(gradeList.values());
            Collections.sort(mapValue);
            
            for (; i <= mapValue.size(); i++) {
                if (getStudentFromGrade(mapValue.get(i)).equals(student)) {
                    return i;
                }
            }
        }
        else
            throw new IllegalArgumentException("There is no student on the list!!");
        return i;
    }

    private Student getStudentFromGrade(double grade) {
        Student temp = null;
        for (Entry<Student, Double> entry : gradeList.entrySet()) {
            if (entry.getValue().equals(grade)) {
                temp = entry.getKey();
            }
        }
        if (temp == null) {
            throw new IllegalArgumentException("There is no student with this grade found in the listed");
        } else {
            return temp;
        }
    }
    
    public double getStudentGrade(Student student)
    {
        for (Entry<Student, Double> entry : gradeList.entrySet()) {
            if (entry.getKey().equals(student)) {
                return entry.getValue();
            }
        }
        throw new IllegalArgumentException("There is no student name " + student.getName() + " in this course!!!");
    }

    public void addScore(Student student, double score) {
        for (Entry<Student, Double> entry : gradeList.entrySet()) {
            if (entry.getKey().equals(student)) {
                entry.setValue(entry.getValue() + score);
            }
        }
    }

    public void setScore(Student student, double score) {
        for (Entry<Student, Double> entry : gradeList.entrySet()) {
            if (entry.getKey().equals(student)) {
                entry.setValue(score);
            }
        }
    }

}
