package com.cjean.zoo.algorithm.countsoft;

import java.util.Arrays;

/**
 *排序数据 ：缺点 占空间，计数数组大小未知
 * 优点：一定程度上比 归并算法，冒泡算法要快
 */
public class CountSoft01 {

    private static void soft(int[] arr) {
        //获取排序数组最大值 最小值
        int min = arr[0];
        int max = arr[0];
        int arrLen = arr.length;
        for (int i = 1; i < arrLen; i++) {
            if (min > arr[i]) min = arr[i];
            if (max < arr[i]) max = arr[i];
        }

        //构建计数数组
        int countLen = max - min + 1;
        int[] countArr = new int[countLen];

        //赋值 计数数组
        for (int i = 0; i < arrLen; i++) {
            countArr[arr[i] - min]++;
        }
//        根据 计数数组 和 排序数组之间的关系，对排序数组进行重新赋值
        int j = 0; // 计数数组下标
        for (int i = 0; i < arrLen; ) { //这 i 其实是排序数据的下标
            while (countArr[j] > 0) {
                arr[i] = min + j;
                countArr[j]--;
                i++;
            }
            j++;
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 5, 4, 9, 1, 2, 7, 8,1,3, 6, 5, 3, 4, 0, 10, 9, 7, 9};
        soft(arr);

    }

}
