package com.basics.extend_;

public class practice01 {
    public static void main(String[] args) {
        PC pc = new PC();
        pc.setBrand("Lenovo");
        pc.setCpu("1110");
        pc.setDisk("1111");
        pc.setMemory("1112");
        System.out.println(pc.getPCDetails());

        NotePad notePad = new NotePad("2110", "2111", "2112", "blue");
        System.out.println(notePad.getNotePadDetails());


    }

}
/**
 * 编写一个Computer类，包含CPU,内存，硬盘等属性，getDetails方法用于返回Computer的详细信息
 * 编写PC 子类，继承Computer类，添加特有属性【品牌brand】
 * 编写NotePad类子类，继承Computer类，添加特有属性color
 * 编写test类，在main方法中创建PC和NotePad对象，分别给对象中的特有属性赋值，
 * 以及从Computer类继承的属性赋值，并使用方法打印输出信息
 * */
class Computer{
    private String cpu;
    private String memory;
    private String disk;

    public Computer() {

    }
    public Computer(String cpu, String memory, String disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getDetails(){
        String info = "cpu: " + cpu + ". memory: " + memory + ". disk: " + disk;
        return info;
    }
}
//PC子类，继承Computer
class PC extends Computer{
    private String brand;

    public PC() {

    }

    public PC(String cpu, String memory, String disk, String brand) {
        super(cpu, memory, disk);
        this.setBrand(brand);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getPCDetails(){
        String infoPC = getDetails() + ". brand：" + brand;
        return infoPC;
    }
}
//NotePad子类，继承Computer
class NotePad extends Computer{
    private String color;

    public NotePad() {

    }

    public NotePad(String cpu, String memory, String disk, String color) {
        super(cpu, memory, disk);
        this.setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getNotePadDetails(){
        String infoNotePad = getDetails() + ". color：" + color;
        return infoNotePad;
    }
}

