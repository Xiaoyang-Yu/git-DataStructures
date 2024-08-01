package com.basics.generics;

import org.junit.jupiter.api.Test;

import java.util.*;

public class homework2 {

    @Test
    public void testDao(){
        Dao<User> userDao = new Dao<User>();
        User user1 = new User(1, 18, "张三");
        User user2 = new User(2, 18, "李四");

        //保存用户
        userDao.save("1", user1);
        userDao.save("2", user2);

        //根据id获取用户
        User user = userDao.get("1");
        System.out.println(user);

        //根据id修改用户
        user1.setName("张三改");
        userDao.update("1", user1);

        List<User> list = userDao.list();
        System.out.println(list);

        userDao.delete("1");
        list = userDao.list();
        System.out.println(list);



    }
}

class Dao<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity){
        map.put(id, entity);
    }

    public T get(String id){
        return map.get(id);
    }

    public void update(String id, T entity){
        map.put(id, entity);
    }
    public List<T> list(){
        Set<String> keys = map.keySet();
        List<T> list = new ArrayList<>();
        for (String key : keys) {
            list.add(map.get(key));
        }
        return list;
    }
    public void delete(String id){
        map.remove(id);
    }
}
class User {
    private int id;
    private int age;
    private String name;

    public User() {
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
