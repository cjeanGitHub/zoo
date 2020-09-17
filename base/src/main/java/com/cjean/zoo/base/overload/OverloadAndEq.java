package com.cjean.zoo.base.overload;

import java.util.Objects;

/**
 * 本文测试 一个对象 重写equals和hashcode的影响
 *
 * PS：当遇到需要对项目的访问接口进行监控的这种情景，
 * 分析：对同一个接口进行保存，并记录连接通讯时长和项目运行访问接口总时长，可以将 接口和时长等参数构建一个 接口参数对象 visit
 * 在此种情况向需要对这个visit对象进行重写equals和和和和和和和hashcode，可以让同一个接口只新建一个，否则不重写的话，会导致
 * 每次访问接口都会新建new一个visit对象，一定会  造成内存溢出的情况
 *
 *
 * 最后：总感觉每个对象都需要重写equals和hashcode，原因：1.写了不会占太多的空间；不行会导致对象构建重复的问题
 */
public class OverloadAndEq {
    public static void main(String[] args) {
        //测试不重写equals和hashcode的效果
        test1();
        // false
        // false
        System.out.println("-----------");
        //测试重写equals和不重写hashcode的效果
        test2();
        // true
        // false
        System.out.println("-----------");
        //测试不重写equals和重写hashcode的效果
        test3();
        // false
        // true
        System.out.println("-----------");
        //测试重写equals和hashcode的效果
        test4();
        // true
        // true
        System.out.println("-----------");
    }

    static void test1(){
        Man1 tom1 = new Man1(1, "tom");
        Man1 tom2 = new Man1(1, "tom");
        System.out.println(tom1.equals(tom2)); // false
        System.out.println(tom1.hashCode()==tom2.hashCode()); // false
    }
    static void test2(){
        Man2 tom1 = new Man2(1, "tom");
        Man2 tom2 = new Man2(1, "tom");
        System.out.println(tom1.equals(tom2)); // true
        System.out.println(tom1.hashCode()==tom2.hashCode()); // false
    }
    static void test3(){
        Man3 tom1 = new Man3(1, "tom");
        Man3 tom2 = new Man3(1, "tom");
        System.out.println(tom1.equals(tom2)); // false
        System.out.println(tom1.hashCode()==tom2.hashCode()); // true
    }
    static void test4(){
        Man4 tom1 = new Man4(1, "tom");
        Man4 tom2 = new Man4(1, "tom");
        System.out.println(tom1.equals(tom2)); // true
        System.out.println(tom1.hashCode()==tom2.hashCode()); // true
    }
}



class Man1 {
    int id;
    String name ;

    public Man1(int id, String name) {
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
}
class Man2 {
    int id;
    String name ;

    public Man2(int id, String name) {
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
        Man2 man2 = (Man2) o;
        return id == man2.id &&
                Objects.equals(name, man2.name);
    }


}
class Man3 {
    int id;
    String name ;

    public Man3(int id, String name) {
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
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
class Man4 {
    int id;
    String name ;

    public Man4(int id, String name) {
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
        Man4 man4 = (Man4) o;
        return id == man4.id &&
                Objects.equals(name, man4.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
