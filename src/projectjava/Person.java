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
public abstract class Person {
    String name;
    int age;
    protected Person(String name, int age){
        this.name = name;
        this.age = age;
        
    }

    protected String getName() {
        return name;
    }

    protected int getAge() {
        return age;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setAge(int age) {
        this.age = age;
    }
    
    public String toString()
    {
        return "Name : " + this.name + "\nAge : " + this.age;
    }
    
    
}
