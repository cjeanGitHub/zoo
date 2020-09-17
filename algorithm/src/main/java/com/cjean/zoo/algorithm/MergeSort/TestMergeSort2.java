package com.cjean.zoo.algorithm.MergeSort;

import java.util.Arrays;

/**
 * 归并排序的是归并操做的一种思想,本质是
 * 分而治之: 将一个数组 先分成 只有2个大小的数组进行比较,再将所有排序后的数组进行合并排序
 */
public class TestMergeSort2 {

    public static int[] margeSoft(int[] arr) {

        int len = arr.length;
        if (len < 2) return arr;
        int mid = len / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, len);
        return marge(margeSoft(left), margeSoft(right));

    }

    /**
     * 如果一个数组已有2个数组 [2, 1]  [2, 1,4,5]
     * 进行比较
     *
     * @param left  [2]   [1, 2]
     * @param right [1]  [4,5]
     * @return
     */
    public static int[] marge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];

        for (int i = 0, R = 0, L = 0; i < result.length; i++) {

            //当L >= left.length 时，左数组全部对比完,那么把 右数组 直接全部追加到临时数组中
            if (L >= left.length)
                result[i] = right[R++];
                //当 R >= right.length 时，右数组全部对比完,那么把 左数组 直接全部追加到临时数组中
            else if (R >= right.length)
                result[i] = left[L++];
                //当只有一对左右数组（每个数组只有一个元素）对比时
            else if (left[L] < right[R])
                result[i] = left[L++];
            else
                result[i] = right[R++];

        }

        return result;

    }

    public static void main(String[] args) {
        int[] args1 = {12, 134, 195, 21, 1, 61, 981, 88};
        int[] args2 = {12, 134, 195, 21, 1, 61, 981, 88};
        System.out.println(Arrays.toString(margeSoft(args1)));
//        System.out.println(Arrays.toString(margeSoft(args2)));

    }
}
