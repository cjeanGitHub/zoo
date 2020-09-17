package com.cjean.zoo.algorithm.SelectSort;

import java.util.Arrays;

/**
 * 选择排序算法
 *      选出最大的放到最后一个位置
 */
public class SelectSort {
    public static void sort2(int[] arr) {
        int len = arr.length;
        int temp;

        for (int i = 0 ; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        int[] args1 = { 12, 134, 195, 21, 1, 61, 981, 88};
        int[] args2 = null;
        sort2(args1);
    }
}
