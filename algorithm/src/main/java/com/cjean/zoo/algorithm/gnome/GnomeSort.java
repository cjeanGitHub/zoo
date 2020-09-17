package com.cjean.zoo.algorithm.gnome;

import java.util.Arrays;

/**
 * 地精算法
 *  拿到一个数 从右往左找比他大的，找到就互换，
 *  这样的算法保证 i 右边的数据都是排过序的
 *
 * @author chu_c
 */
public class GnomeSort {

    public static void gnome(int[] array) {
        int i = 0;
        while (i < array.length) {
            if (i == 0 || array[i - 1] <= array[i]) {
                i++;
            } else {
                int temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
                i--;
            }
        }
        System.out.println(Arrays.toString(array));

    }

    public static void main(String[] args) {
        int[] args1 = {12, 134, 195, 21, 1, 61, 981, 88};
        gnome(args1);
    }


}