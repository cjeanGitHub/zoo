package com.cjean.zoo.jvm.jvm;

public class TestDemo5 {
    public static void main(String[] args) {

        /**
         * 在堆中开辟一个内存空间存放TestDemo4对象，并且把引用地址 压栈 ，此时对象是半初始化状态
         * ，引用地址 数量：1
         * _new 'com/cjean/exercise/exercise01/jvm/TestDemo4'
         *     将栈顶的数据复制一份压到栈中  数据是对象的引用地址，目前有2份
         *     dup
         *      拿出栈顶的数据（引用地址）执行 <init>  方法，此时引用地址被消耗一份， 还有 1分
         *     INVOKESPECIAL com/cjean/exercise/exercise01/jvm/TestDemo4.<init> ()V
         *
         *     astore 1
         *     aload 1
         *     INVOKEVIRTUAL com/cjean/exercise/exercise01/jvm/TestDemo4.m9 ()V
         *     return
         */
        TestDemo4 testDemo4 = new TestDemo4();
        testDemo4.m9();


    }
}
