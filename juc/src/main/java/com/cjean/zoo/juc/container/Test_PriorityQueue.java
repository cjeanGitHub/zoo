package com.cjean.zoo.juc.container;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Test_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue<>();
        priorityQueue.add("c");
        priorityQueue.add("z");
        priorityQueue.add("a");
        priorityQueue.add("v");
        priorityQueue.add("b");
        int size = priorityQueue.size();


        Iterator iterator = priorityQueue.iterator();
        while (iterator.hasNext()){ // a z c  2.a b c z v
            Object next = iterator.next();
            System.out.println(next);
        }

        System.out.println("--------------------");

        for (int i = 0; i < size; i++) {// a a a
            System.out.println(priorityQueue.peek());
        }
        System.out.println("--------------------");
        for (int i = 0; i < size; i++) {// a b c v z
            System.out.println(priorityQueue.poll());
        }
        System.out.println("--------------------");
        for (int i = 0; i < size; i++) {
//            System.out.println(priorityQueue);
        }
    }
}
