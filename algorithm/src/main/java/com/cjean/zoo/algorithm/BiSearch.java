package com.cjean.zoo.algorithm;

/**
 * 二分法查找
 *
 * @author chu_c
 */
public class BiSearch {

    public static int funBinSearch2(int[] array, int data) {

        int low = 0;
        int hight = array.length - 1;
        while (low <= hight) {
            int mid = (low + hight) / 2;
            if (array[mid] == data) {
                return mid;
            } else if (data < array[mid]) {
                hight = mid - 1;
            } else if (data > array[mid]) {
                low = mid + 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 66};
        int data = 5;

        //预想结果return 4 ，位置是第四个
        System.out.println(funBinSearch2(array, data));
    }


}