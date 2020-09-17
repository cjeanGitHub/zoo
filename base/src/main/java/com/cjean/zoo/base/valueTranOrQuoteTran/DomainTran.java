package com.cjean.zoo.base.valueTranOrQuoteTran;


import com.cjean.zoo.base.domian.User01;

public class DomainTran {
    public static void main(String[] args) {

        User01 user01 = new User01();
        user01.setName("tom");
        user01.setAge(12);

        changeAge(user01);
        System.out.println(user01.getAge());
        System.out.println("+-*-**-------------------------");
        changeName(user01);
        System.out.println(user01.getName());

    }

    public static void changeName(User01 val) {
        val.setName("mayun");
        System.out.println("changeName value:" + val.getName());
    }

    public static void changeAge(User01 val) {
        val.setAge(77);
        System.out.println("changeAge value:" + val.getAge());
    }
}
