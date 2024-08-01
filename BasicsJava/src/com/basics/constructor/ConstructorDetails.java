package com.basics.constructor;

public class ConstructorDetails {
    public static void main(String[] args) {
        Person person = new Person();
        Person person1 = new Person("jack",18);

    }
}

class Person{
    String name;
    int age;
    //int age = 12;
    public Person(){
        System.out.println("no parameters constructor called");
        System.out.println(age);
    }
    public Person(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("name=" + name + "\t" + "age=" + age );
    }


}
