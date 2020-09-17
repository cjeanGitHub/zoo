package com.cjean.zoo.juc.syn;

public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {

        Person person = new Person();
        person.setName("miao");
        person.setAge(123);
        System.out.println(person.toString());
        System.out.println("------------------------");
        new T1("T3", person).start();

        new T2("T2", person).start();
//        TimeUnit.SECONDS.sleep(2);

        new T1("T3", person).start();
    }


}

class T4 extends Thread {
    private String name;
    ThreadLocal<Person> localMap = new ThreadLocal<>();


    public T4() {
    }

    public T4(String name) {
        this.name = name;
    }

    public void run() {


    }

}

class T3 extends Thread {
    private String name;
    ThreadLocal<Person> localMap = new ThreadLocal<>();


    public T3() {
    }

    public T3(String name) {
        this.name = name;
    }

    public void run() {


    }

}


class T2 extends Thread {
    private String name;
    private Person person;
    ThreadLocal<Person> localMap = new ThreadLocal<>();


    public T2() {
    }

    public T2(String name, Person person) {
        this.name = name;
        this.person = person;
    }

    public void run() {
        localMap.set(person);
        Person personLocal = localMap.get();
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        personLocal.setName("dog.....");
//        localMap.get().setName("dog....");
        System.out.println(person.toString());
        System.out.println(personLocal.toString());
        System.out.println(Thread.currentThread().getName() + "---" + this.name);
        System.out.println(personLocal.getName());
        System.out.println(localMap.get().getName());
        System.out.println(this.person.getName());
        System.out.println("------------------------");

    }

}

class T1 extends Thread {
    private String name;
    private Person person;
    ThreadLocal<Person> localMap = new ThreadLocal<>();


    public T1() {
    }

    public T1(String name, Person person) {
        this.name = name;
        this.person = person;
    }

    public void run() {
        System.out.println(person.toString());
        localMap.set(person);
        System.out.println(localMap.get().toString());
        System.out.println(Thread.currentThread().getName() + "---" + this.name);
        Person person = localMap.get();
        System.out.println(person.getName());
        System.out.println("------------------------");

    }

}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
