package com.cjean.zoo.juc;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.strands.SuspendableCallable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FiberTest {
    public static void main(String[] args) throws Exception {
        List<Fiber<Integer>> fibers = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            final int count = i;
            Fiber<Integer> fiber = new Fiber<>((SuspendableCallable<Integer>) () -> {
                Fiber.sleep(1000);
                return count;
            });
            fiber.start();
            fibers.add(fiber);
        }

        for (Fiber fiber : fibers) {
            System.out.println(fiber.get() + "  " + LocalDateTime.now().toString());
        }
    }
}
