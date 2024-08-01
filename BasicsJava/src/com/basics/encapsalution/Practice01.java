package com.basics.encapsalution;

public class Practice01 {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(2000);
        account.setName("jack11111");
        account.setPwd("123456");

        System.out.println(account.getBalance());
        System.out.println(account.getName());
        System.out.println(account.getPwd());
    }

}
/**
 * 创建程序，在其中定义两个类，Account 和 Test类，体会Java的封装
 * Account类要具有属性：姓名（长度为2-4位）, 余额（必须大于20）
 * 密码（必须是6位），如果不满足，则给出提示信息，并给默认值
 * 通过setXXX方法给Account的属性赋值
 * 在Test中测试
 * */
class Account{
    private String name;
    private double balance;
    private String pwd;

    public Account() {
    }

    public Account(String name, double balance, String pwd) {
        this.setName(name);
        this.setBalance(balance);
        this.setPwd(pwd);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() >= 2 && name.length() <= 4){
            this.name = name;
        }else{
            System.out.println("名字输入格式不对，默认名字为001");
            this.name = "001";
        }

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance > 20){
            this.balance = balance;
        }else{
            System.out.println("余额设置错误，默认余额为20元");
            this.balance = 20;
        }

    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        if (pwd.length() == 6){
            this.pwd = pwd;
        }else{
            System.out.println("密码输入错误，默认密码为000000");
            this.pwd = "000000";
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
