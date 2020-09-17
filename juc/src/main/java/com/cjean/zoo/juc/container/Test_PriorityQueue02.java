package com.cjean.zoo.juc.container;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Test_PriorityQueue02 {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue<>();
        priorityQueue.add("c");
        priorityQueue.add("z");
        priorityQueue.add("a");
        priorityQueue.add("v");
        priorityQueue.add("b");
        int size = priorityQueue.size();

        Iterator iterator = priorityQueue.iterator();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
            priorityQueue.stream().forEach(s -> System.out.println("forEach: " + s));
            System.out.println("----------");

        }



    }
}
