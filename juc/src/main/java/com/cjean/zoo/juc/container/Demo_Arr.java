package com.cjean.zoo.juc.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo_Arr {
    public static void main(String[] args) {
//        test_01();
//        test_02();
//        test_03();
//        test_04();
        test_05();
    }

    static void test_05() {

        Demo_Arr demo_arr = new Demo_Arr();
        List<String> s1 = demo_arr.getList();
        String[] strings = s1.toArray(new String[0]);
        System.out.println(Arrays.toString(strings));



    }

    static void test_04() {
        List<Object> objects = new ArrayList<>();
        System.out.println(objects.size());
        objects.stream().forEach(object -> {
            System.out.println(object);
        });


    }

    static void test_03() {
        Demo_Arr demo_arr = new Demo_Arr();
        List<String> s1 = demo_arr.getList();
        String[] strings = s1.toArray(new String[s1.size()]);
        System.out.println(Arrays.toString(strings));

    }

    public List getList() {
        List<String> s1 = new ArrayList<>();
        s1.add("hello");
        s1.add("hello2");
        s1.add("hello3");
        return s1;
    }

    static void test_02() {
        List<String> s1 = new ArrayList<>();
        s1.add("hello");
        s1.add("hello2");
        s1.add("hello3");

        String[] strings = s1.toArray(new String[s1.size()]);
        System.out.println(Arrays.toString(strings));


    }

    static void test_01() {
        int[] a = null;
        a = new int[]{1, 2, 3};
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}
