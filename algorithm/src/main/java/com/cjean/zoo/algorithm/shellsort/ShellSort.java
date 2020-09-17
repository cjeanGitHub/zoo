package com.cjean.zoo.algorithm.shellsort;

import java.util.Arrays;

/**
 *希尔排序算法  数据按照比例分组后的插入算法（是插入算法的升级版）
 *
 */
public class ShellSort {

    public static int[] ShellSort(int[] array) {
        int len = array.length;
        int gra = len / 2;
        int temp;
        while (gra > 0) {
            // 当gra 为0 时，会有一次对以往分组排序的一次 大排序
            for (int i = gra; i < len; i++) {
                temp = array[i];
                int preIndex = i - gra;
                while (preIndex >= 0 && temp < array[preIndex]) {
                    array[preIndex + gra] = array[preIndex];
                    array[preIndex] = temp;
                    preIndex -= gra;
                }
            }
            gra /= 2;
        }
        System.out.println(Arrays.toString(array));
        return array;

    }

    public static void main(String[] args) {
        int[] args1 = {12, 134, 195, 21, 1, 61, 981, 88};
        int[] args2 = null;
        ShellSort(args1);
    }
}
