package com.cjean.zoo.algorithm.redixsort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 基数排序：Java
 *
 * @author skywang
 * @date 2014/03/15
 */

public class RadixSort {

    /**
     * 基数排序
     *
     * @param array
     * @return
     */
    public static int[] RadixSort2(int[] array) {
        if (array == null || array.length < 2)
            return array;
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0; //几位数，各位数为1 ，十位数为2
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
        return array;
    }

    /*
     * 获取数组a中最大值
     *
     * 参数说明：
     *     a -- 数组
     *     n -- 数组长度
     */
    private static int getMax(int[] a) {
        int max;

        max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];

        return max;
    }

    /*
     * 对数组按照"某个位数"进行排序(桶排序)
     *
     * 参数说明：
     *     a -- 数组
     *     exp -- 指数。对数组a按照该指数进行排序。
     *
     * 例如，对于数组a={50, 3, 542, 745, 2014, 154, 63, 616}；
     *    (01) 当exp=1表示按照"个位"对数组a进行排序
     *    (02) 当exp=10表示按照"十位"对数组a进行排序
     *    (03) 当exp=100表示按照"百位"对数组a进行排序
     *    ...
     */
    private static void countSort(int[] a, int exp) {
        //int output[a.length];    // 存储"被排序数据"的临时数组
        int[] output = new int[a.length];    // 存储"被排序数据"的临时数组
        int[] buckets = new int[10];

        // 将数据出现的次数存储在buckets[]中
        for (int i = 0; i < a.length; i++)
            buckets[(a[i] / exp) % 10]++;

        // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
        for (int i = 1; i < 10; i++)
            buckets[i] += buckets[i - 1];

        // 将数据存储到临时数组output[]中
        for (int i = a.length - 1; i >= 0; i--) {
            output[buckets[(a[i] / exp) % 10] - 1] = a[i];
            buckets[(a[i] / exp) % 10]--;
        }

        // 将排序好的数据赋值给a[]
        for (int i = 0; i < a.length; i++)
            a[i] = output[i];

        output = null;
        buckets = null;
    }

    /*
     * 基数排序
     *
     * 参数说明：
     *     a -- 数组
     */
    public static void radixSort(int[] a) {
        int exp;    // 指数。当对数组按各位进行排序时，exp=1；按十位进行排序时，exp=10；...
        int max = getMax(a);    // 数组a中的最大值

        // 从个位开始，对数组a按"指数"进行排序
        for (exp = 1; max / exp > 0; exp *= 10)
            countSort(a, exp);
    }

    public static int[] RadixSort22(int[] array) {
        if (null == array || array.length < 2) return array;
        int arrLen = array.length;
        int max = array[0];
        for (int temp : array) {
            max = Math.max(max, temp);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }

        //由于每次比较都要创建10个桶，浪费空间，因此将桶拿出来进行重复使用,但是每次比较完后，都要将桶 “洗”赶紧
            ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
                buckets.add(new ArrayList<Integer>());
            }

        int mod = 10, div = 1;
        for (int k = 0; k < maxDigit; k++, mod *= 10, div *= 10) {
            //每次位比较 都是10个数，所以构建一个10个大小的 桶
//            ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(10);
//            for (int i = 0; i < 10; i++) {
//                buckets.add(new ArrayList<Integer>());
//            }
            // 开始 位数 比较,每次比较后都会形成一个有序 组
            for (int i = 0; i < arrLen; i++) {
                // 可以获取这个数应该 在 1 - 10中哪个位置
                int num = (array[i] % mod) / div;
                buckets.get(num).add(array[i]);
            }
            int index = 0;
            for (int i = 0; i < buckets.size(); i++) {
                for (int j = 0; j < buckets.get(i).size(); j++) {
                    array[index++] = buckets.get(i).get(j);
                }
                buckets.get(i).clear(); // 此次位数比较时，将临时桶内出现的数据清空，进而下次使用
            }
            // 结束 位数 比较
            System.out.println("---------结束 位数 比较----------");
        }
        return array;
    }

    public static void main(String[] args) {
//        int i;
//        int a[] = {53, 3, 542, 748, 14, 214, 154, 63, 616};
////        int a[] = {-53, -3, -542, -748, -14, -214, 154, 63, 616}; //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: -3
//        System.out.printf("before sort:");
//        for (i = 0; i < a.length; i++)
//            System.out.printf("%d ", a[i]);
//        System.out.printf("\n");
//
//        radixSort(a);    // 基数排序
//
//        System.out.printf("after  sort:");
//        for (i = 0; i < a.length; i++)
//            System.out.printf("%d ", a[i]);
//        System.out.printf("\n");
//
        System.out.println("*************");
//        int[] ints = {53, 3, 542, 748, 14, 214, 154, 63, 616};
        int[] ints = {53, 3, 14, 63};
//        int[] ints = {-53, -3, -542, -748, -14, -214, 154, 63, 616};// Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: -3
        System.out.println(Arrays.toString(ints));
//        ints = RadixSort2(ints);
        ints = RadixSort22(ints);
        System.out.println(Arrays.toString(ints));
//        System.out.println(23 % 10);
//        System.out.println((23 % 10) / 1);
//        System.out.println((233 % 100));
//        System.out.println((233 % 100) / 10);
//        System.out.println((234 % 100) / 10);
    }
}