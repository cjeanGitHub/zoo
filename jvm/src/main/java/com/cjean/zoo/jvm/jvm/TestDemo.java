package com.cjean.zoo.jvm.jvm;

public class TestDemo {
    public static void main(String[] args) {
//        Integer a = 2;
//        Integer b= 3;
//        Integer c = null;
//        Boolean F = true;
//
//        Integer rs = F?c:a*b;

        int i = 8;//2
        /**
         *  当int取值-1~5采用iconst指令，取值-128~127采用bipush指令，取值-32768~32767采用sipush指令，
         *  取值-2147483648~2147483647采用 ldc 指令
         *  iconst_2   将 2 压入栈帧中的操作数栈
         *     istore 1 将 操作数栈中最上面的数赋值给 局部变量1
         *     iload 1  将 局部变量中 参数1 的值读出来 压入 操作数栈中
         *     iinc 1（参数1）,1（增加数） 将局部变量中  参数1  加1
         *     istore 1  将操作数栈中最上面的数弹出来（出栈） 赋值 给参数1
         *     return
         *
         *  i = i++;
         */
//        i = i++;

        /**
         *
         * iconst_2
         *     istore 1
         *     iinc 1,1
         *     iload 1
         *     istore 1
         *     return
         *
         * int i = 2;
         *  ++i;
         *  System.out.println((int)i);
         */
        i = ++i;
//        System.out.println(i);

//        String s = "123";
//        s = "234";
//        String s1 = new String("568");
//        System.out.println(s1);
//        System.out.println(s);


    }
}
