package com.basics.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

public class homework1 {
    public static void main(String[] args) {

        Employee e1 = new Employee("222", 15000, new MyDate(2023, 3, 13));
        Employee e2 = new Employee("222", 1100, new MyDate(2024, 2, 3));
        Employee e3 = new Employee("222", 35000, new MyDate(2023, 1, 2));

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int name = o1.getName().compareTo(o2.getName());
                //这里使用了 String 的 compareTo 方法来比较两个 Employee 对象的 name 属性。
                //如果 name 返回非零值，则表示两个名字不同，排序将根据名字的字母顺序进行。
                if (name != 0){
                    return name;
                }
                //是对birthday的比较，把整体的birthday比较的逻辑放在了MyDate类中。
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void junit(){

    }
}
class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal='" + sal + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate implements Comparable<MyDate>{

    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        int year = this.year - o.getYear();
        int month = this.month - o.getMonth();
        int day = this.day - o.getDay();
        //如果名字相同，则比较生日的年份。
        //如果 year 返回非零值，则表示出生年份不同，排序将根据出生年份进行。
        if (year != 0){
            return year;
        }
        //如果名字和出生年份相同，则比较出生月份。
        //如果 month 返回非零值，则表示出生月份不同，排序将根据出生月份进行。
        if (month != 0){
            return month;
        }
        //如果名字、出生年份和出生月份都相同，则比较出生日期。
        //如果 day 返回非零值，则表示出生日期不同，排序将根据出生日期进行
        return day;
    }
}
