package com.basics.encapsalution;

public class Encap01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("asjlag");
        System.out.println(person.getName());
    }


}

class Person{
    //1. 属性用private，拒绝直接访问。
    private String name;
    private int age;
    private double salary;

    public Person() {

    }

    public Person(String name, int age, double salary) {
//        this.name = name;   这个位置，如果直接用这种方式， 在setName里面的验证效果失效了。
//        this.age = age;
//        this.salary = salary;
        setName(name);
        setAge(age);
        setSalary(salary);  //用这种方式，则验证依然有用
    }

    //2. 提供公共的set方法，用于对属性的判断并赋值
    public void setName(String name){
        //对数据的校验
        if(name.length() >= 2 && name.length() <=6){
            this.name = name;
        }else {
            System.out.println("名字格式不对");
            this.name = "Default Name";  // 名字格式不对，默认给个名字
        }

    }
    //3. 提供公共的get方法，用于获取属性的值
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age >= 1 && age <= 120){
            this.age = age;
        }else{
            System.out.println("设置的年龄不对");
            this.age = 18;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        //如果想设置，薪水不可以直接查看，需要权限，则在这个位置添加。
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
