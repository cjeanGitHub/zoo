package com.cjean.zoo.jvm.jvm;

public class TestDemo4 {

    public static void m0(){
        int a = 2;
    }

    public static int m1(){
        int a = 2;
        return a;
    }
    public static int m2(int a){
        int b = a+1;
        return b;
    }

    public static void m3(){
        String b = "123";
    }
    public static String m4(int a){
        String b = "123";
        return b;
    }
    public static int m5(int a){
        String b = "123";
        return a;
    }
    public static long m6(){
        long L = 2L;
        return L;
    }
    public static double m7(){
        double L = 2;
        return L;
    }
    public static float m8(){
        float L = 2;
        return L;
    }

    public void m9(){

    }

    /***
     *
     * lambda表达式/反射/CGLB ASM  在运行时动态产生class会使用到的指令
     *
     *  public void m10() {
     *     iconst_0
     *     istore 1
     *     return
     *   }
     *
     *   变量a居然不是 0， 是因为非static 方法，中自动内置一个 this 变量来指向方法所在类的引用地址
     *   而 static 方法 中没有this ，因为该方法是在类所在常量池中的
     */
    public void m10(){
        int a = 0;
    }

    public static void main(String[] args) {
        int i;
        int j = 0;

        i = m2(j);



    }
}
