package com.basics.Collections_;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class homework2 {
    public static void main(String[] args) {

        HashMap<Object, Object> map = new HashMap<>();
        map.put("jack", 650);
        map.put("tom", 1200);
        map.put("smith", 2900);

        //1. 将jack的工资改为2600
        map.put("jack", 2600);
        //2.
        // 遍历所有员工，为每个员工薪水+100
        Set keys = map.keySet();
        for (Object key : keys) {
            map.put(key, (Integer)map.get(key) + 100);
        }
        System.out.println(map);
        //3. 遍历所有工资
        Collection<Object> values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }


    }
}
