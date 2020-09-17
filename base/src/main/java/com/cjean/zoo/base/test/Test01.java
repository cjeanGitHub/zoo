package com.cjean.zoo.base.test;


import com.cjean.zoo.base.domian.User01;
import com.cjean.zoo.base.domian.User02;

import java.util.ArrayList;
import java.util.List;

public class Test01 {


    public static void main(String[] args) {

        String s1 = "222";

        List<Object> list = new ArrayList<Object>();

        list.add(s1);
        list.add(s1);

        list.add(s1);

        System.out.println("222");



        //测试对象与对象之间的赋值
        testDomainChangeNil();


        //测试 每32个字节打印一次
//        testPrint();
    }

    static void testDomainChangeNil() {
        User01 user01 = new User01();
        user01.setAge(11);
        user01.setName("haha");
        user01.setId(0);

        User02 user02 = new User02();
        user02.setAge(user01.getAge());
        user02.setName(user01.getName());
        System.out.println("before nil..." + user01.toString());
        System.out.println("before nil..." + user02.toString());
        user01 = null;

        System.out.println("after  nil..." + user02.toString());
//        System.out.println("after  nil..."+user01.toString()); //java.lang.NullPointerException
        System.out.println("after  nil..." + user02.toString());
    }

    static void testPrint() {

        List<String> codeStr = new ArrayList<>();
        int mark = 0;

        for (int i = 0; i < 126; i++) {
            codeStr.add("add...: " + i);
        }

        String code = "";
        for (int i = 0; i < codeStr.size(); i++) {
            code += codeStr.get(i);

            // 大于32的情况
            if (codeStr.size() >= 32) {
                // 被32整除的情况
                if (codeStr.size() % 32 == 0) {
                    if ((i + 1) % 32 == 0) {
                        // 说明是32个，发送一次命令
                        System.out.println("总数超过32，总数是32的倍数.........");
                        // 清空code，准备下一次
                        code = "";
                    }
                } else {

                    //获取不足32个数。开始装填数据的数组下标位置
                    if (0 == mark) {
                        mark = codeStr.size() / 32 * 32;
                    }

                    // 不能被32整除的情况
                    if (i == mark) {
                        // 最后一次发送
                        System.out.println("总数超过32，不满32个发一次........." + (codeStr.size() - i));
                        // 清空code，准备下一次
                        code = "";
                    } else {
                        if ((i + 1) % 32 == 0) {
                            System.out.println("总数超过32，装满32个发一次.........");
                            // 清空code，准备下一次
                            code = "";
                        }
                    }
                }
            } else {
                // 小于32 的情况
                if (i == (codeStr.size() - 1))
                    System.out.println("总数 不到 32，发一次.........");
            }
        }
    }

}
