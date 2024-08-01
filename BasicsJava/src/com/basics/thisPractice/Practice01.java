package com.basics.thisPractice;


public class Practice01 {
    public static void main(String[] args) {

        //double[] dArr = {0.12, 3.13, 4.14, 51.2, 55};
        double[] dArr = {};
        A01 a01 = new A01();
        Double maxNum = a01.max(dArr);
        if (maxNum != null){
            System.out.println(maxNum);
        }else {
            System.out.println("...");
        }

        String[] strs = {"jack","jack4","jack3","jack2","jack1"};
        A02 a02 = new A02();
        System.out.println(a02.find(strs,"jack1"));

        A03 a03 = new A03("三国演义", 300);
        a03.info();
        a03.updatePrice();
        a03.info();

    }

}
//作业1： 编写A01类，定义方法max，实现求某个double数组的最大值，并返回
class A01 {

    public Double max(double[] db) {
        if (db != null && db.length > 0){
            double maxNum = db[0];
            for (int i = 0; i < db.length; i++) {
                if (maxNum < db[i]) {
                    maxNum = db[i];
                }
            }
            return maxNum;
        }else {
            return null;
        }

    }
}
//作业2： 编写A02类，定义方法find， 实现查找某个字符串数组中的元素查找，并返回索引，如果找不到，返回-1
class A02{

    public int find(String[] str, String elm){
        if (str.length > 0 && str != null){
            for (int i = 0; i< str.length; i++){
                if (str[i].equals(elm)){
                    return i;
                }
            }
        }
        return -1;

    }

}
//作业3：编写A03类，定义方法updatePrice，实现更改某本书的价格，具体：如果价格>150，则改为150. 如果>100 更改为100. 否则不变
class A03{

    String name;
    double price;
    public A03(String name, double price){
        this.name = name;
        this.price = price;
    }
    public void updatePrice(){
        if (this.price > 150){
            this.price = 150;
        }else if (this.price > 100){
            this.price = 100;
        }
    }
    public void info(){
        System.out.println("书名= " + this.name + " 价格= " + this.price);
    }
}
