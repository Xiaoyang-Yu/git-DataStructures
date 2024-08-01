package com.basics.Collections_;

import java.util.HashSet;
import java.util.Objects;

public class homework3 {
    public static void main(String[] args) {
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");

        HashSet set = new HashSet();
        set.add(p1);
        set.add(p2);

        p1.setName("CC");

        /** 详细原因：
         * 添加 p1 和 p2 到 HashSet：
         *
         * 当你第一次将 p1 和 p2 添加到 HashSet 时，它们的哈希码是基于它们的 id 和 name 属性计算出来的。假设 p1 的哈希码为 h1，p2 的哈希码为 h2。
         * HashSet 使用这些哈希码来确定元素在集合中的位置。
         * 修改 p1 的 name 属性：
         *
         * 当你修改 p1 的 name 属性为 "CC" 时，如果 Person 类的 hashCode 方法是基于 name 属性计算哈希码，那么 p1 的哈希码也会随之改变。
         * 例如，修改后的 p1 的哈希码变成了 h3。
         * 从 HashSet 中删除 p1：
         *
         * 当你尝试删除 p1 时，HashSet 会使用当前 p1 的哈希码（即 h3）来查找它。
         * 由于 HashSet 中存储 p1 的位置是基于旧的哈希码 h1 确定的，因此使用新的哈希码 h3 找不到相应的位置。
         * 因此，HashSet 无法找到并删除 p1。
         *
         * 解决方法是避免在对象添加到 HashSet 后修改会影响 hashCode 和 equals 方法的属性，或者在 Person 类中仅使用不变的属性（如 id）来计算哈希码。
         */
        set.remove(p1); //这里删除不掉的原因是因为，下面的Person类中，重写了hashCode和equals方法

        System.out.println(set);

    }
}
class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
