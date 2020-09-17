package com.cjean.zoo.jvm.jvm;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

public class TestResp {
    public static void main(String[] args) {
//        testJvm01();
//        testJvm02();
        testJvm05();
        testJvm06();
//        for (int i = 0; i < 11; i++) {
////            testJvm03();
////            testJvm04();
//            testJvm05();
//            testJvm06();
//            System.out.println("num:" + i);
//            System.out.println();
//        }

    }

    public static void testJvm0() {
        // 虚拟机级内存情况查询
        long vmFree = 0;
        long vmUse = 0;
        long vmTotal = 0;
        long vmMax = 0;
        int byteToMb = 1024 * 1024;
        Runtime rt = Runtime.getRuntime();
        vmTotal = rt.totalMemory() / byteToMb;
        vmFree = rt.freeMemory() / byteToMb;
        vmMax = rt.maxMemory() / byteToMb;
        vmUse = vmTotal - vmFree;
        System.out.println("JVM内存已用的空间为：" + vmUse + " MB");
        System.out.println("JVM内存的空闲空间为：" + vmFree + " MB");
        System.out.println("JVM总内存空间为：" + vmTotal + " MB");
        System.out.println("JVM总内存空间为：" + vmMax + " MB");

        System.out.println("======================================");
        // 操作系统级内存情况查询
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        String os = System.getProperty("os.name");
        long physicalFree = osmxb.getFreePhysicalMemorySize() / byteToMb;
        long physicalTotal = osmxb.getTotalPhysicalMemorySize() / byteToMb;
        long physicalUse = physicalTotal - physicalFree;
        System.out.println("操作系统的版本：" + os);
        System.out.println("操作系统物理内存已用的空间为：" + physicalFree + " MB");
        System.out.println("操作系统物理内存的空闲空间为：" + physicalUse + " MB");
        System.out.println("操作系统总物理内存：" + physicalTotal + " MB");

        // 获得线程总数
        ThreadGroup parentThread;
        int totalThread = 0;
        for (parentThread = Thread.currentThread().getThreadGroup(); parentThread
                .getParent() != null; parentThread = parentThread.getParent()) {
            totalThread = parentThread.activeCount();
        }
        System.out.println("获得线程总数:" + totalThread);

    }


    public static void testJvm01() {
        long vmFree = 0;
        long vmUse01 = 0;
        long vmUse02 = 0;
        long vmTotal = 0;
        Runtime rt = Runtime.getRuntime();
        vmTotal = rt.totalMemory();
        vmFree = rt.freeMemory();
        vmUse01 = vmTotal - vmFree;
        System.out.println("JVM内存已用的空间为：" + vmUse01 + " MB");
        System.out.println("-----------------------------------");

        buildStr();

        Runtime rt1 = Runtime.getRuntime();
        vmTotal = rt1.totalMemory();
        vmFree = rt1.freeMemory();
        vmUse02 = vmTotal - vmFree;
        System.out.println("占用的空间为：" + (vmUse01 - vmUse02) + " MB");
        System.out.println("JVM内存已用的空间为：" + vmUse02 + " MB");
        System.out.println("----------------test01-------------------");
    }

    public static void testJvm02() {
        long vmFree = 0;
        long vmUse01 = 0;
        long vmUse02 = 0;
        long vmTotal = 0;
        Runtime rt = Runtime.getRuntime();
        vmTotal = rt.totalMemory();
        vmFree = rt.freeMemory();
        vmUse01 = vmTotal - vmFree;
        System.out.println("JVM内存已用的空间为：" + vmUse01 + " MB");
        System.out.println("-----------------------------------");

        String s = buildStr();
        System.out.println(s);

        Runtime rt1 = Runtime.getRuntime();
        vmTotal = rt1.totalMemory();
        vmFree = rt1.freeMemory();
        vmUse02 = vmTotal - vmFree;
        System.out.println("JVM内存已用的空间为：" + vmUse02 + " MB");
        System.out.println("占用的空间为：" + (vmUse01 - vmUse02) + " MB");
        System.out.println("------------test02-----------------------");
    }

    public static void testJvm03() {
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long physicalFree = osmxb.getFreePhysicalMemorySize();
        System.out.println("操作系统物理内存已用的空间为：" + physicalFree + " MB");
        System.out.println("-----------------------------------");

        buildStr();


        OperatingSystemMXBean osmxb2 = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long physicalFree2 = osmxb2.getFreePhysicalMemorySize();
        System.out.println("操作系统物理内存已用的空间为：" + physicalFree2 + " MB");
        System.out.println("占用的空间为：" + (physicalFree - physicalFree2) + " MB");
        System.out.println("----------------test01-------------------");
    }

    public static void testJvm04() {
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long physicalFree = osmxb.getFreePhysicalMemorySize();
        System.out.println("操作系统物理内存已用的空间为：" + physicalFree + " MB");
        System.out.println("-----------------------------------");

        String s = buildStr();


        OperatingSystemMXBean osmxb2 = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long physicalFree2 = osmxb2.getFreePhysicalMemorySize();
        System.out.println("操作系统物理内存已用的空间为：" + physicalFree2 + " MB");
        System.out.println("占用的空间为：" + (physicalFree - physicalFree2) + " MB");
        System.out.println("------------test02-----------------------");
    }

    public static void testJvm05() {
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long physicalFree = osmxb.getFreePhysicalMemorySize();
        System.out.println("操作系统物理内存已用的空间为：" + physicalFree + " MB");
        System.out.println("-----------------------------------");
        long vmFree = 0;
        long vmUse01 = 0;
        long vmUse02 = 0;
        long vmTotal = 0;
        Runtime rt = Runtime.getRuntime();
        vmTotal = rt.totalMemory();
        vmFree = rt.freeMemory();
        vmUse01 = vmTotal - vmFree;
        System.out.println("JVM内存已用的空间为：" + vmUse01 + " MB");
        System.out.println("-----------------------------------");

        buildStr();


        Runtime rt1 = Runtime.getRuntime();
        vmTotal = rt1.totalMemory();
        vmFree = rt1.freeMemory();
        vmUse02 = vmTotal - vmFree;
        System.out.println("占用的空间为：" + (vmUse01 - vmUse02) + " MB");
        System.out.println("JVM内存已用的空间为：" + vmUse02 + " MB");
        OperatingSystemMXBean osmxb2 = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long physicalFree2 = osmxb2.getFreePhysicalMemorySize();
        System.out.println("操作系统物理内存已用的空间为：" + physicalFree2 + " MB");
        System.out.println("占用的空间为：" + (physicalFree - physicalFree2) + " MB");
        System.out.println("----------------test01-------------------");
    }

    public static void testJvm06() {
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long physicalFree = osmxb.getFreePhysicalMemorySize();
        System.out.println("操作系统物理内存已用的空间为：" + physicalFree + " MB");
        System.out.println("-----------------------------------");
        long vmFree = 0;
        long vmUse01 = 0;
        long vmUse02 = 0;
        long vmTotal = 0;
        Runtime rt = Runtime.getRuntime();
        vmTotal = rt.totalMemory();
        vmFree = rt.freeMemory();
        vmUse01 = vmTotal - vmFree;
        System.out.println("JVM内存已用的空间为：" + vmUse01 + " MB");
        System.out.println("-----------------------------------");

        String s = buildStr();


        Runtime rt1 = Runtime.getRuntime();
        vmTotal = rt1.totalMemory();
        vmFree = rt1.freeMemory();
        vmUse02 = vmTotal - vmFree;
        System.out.println("占用的空间为：" + (vmUse01 - vmUse02) + " MB");
        System.out.println("JVM内存已用的空间为：" + vmUse02 + " MB");
        OperatingSystemMXBean osmxb2 = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long physicalFree2 = osmxb2.getFreePhysicalMemorySize();
        System.out.println("操作系统物理内存已用的空间为：" + physicalFree2 + " MB");
        System.out.println("占用的空间为：" + (physicalFree - physicalFree2) + " MB");
        System.out.println("------------test02-----------------------");
    }

    public static String buildStr() {
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < 9; i++) {
            s.append("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        }
        return s.toString();
    }
}
