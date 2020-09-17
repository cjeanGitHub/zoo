package com.cjean.zoo.algorithm.bucket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {
    public static void sort(int[] array, int bucketSize) {
        System.out.println("排序前：" + Arrays.toString(array));
        // TODO Auto-generated method stub
        //最大最小值
        int max = array[0];
        int min = array[0];
//        int length = array.length/4;
        int length = array.length / bucketSize;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            } else if (array[i] < min) {
                min = array[i];
            }
        }

        //最大值和最小值的差
        int diff = max - min;

        //桶列表
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            bucketList.add(new ArrayList<>());
        }

        //每个桶的存数区间
        float section = (float) diff / (float) (length - 1);

        //数据入桶
        for (int i = 0; i < array.length; i++) {
            //当前数除以区间得出存放桶的位置 减1后得出桶的下标
            int num = (int) (array[i] / section) - 1;
            if (num < 0) {
                num = 0;
            }
            bucketList.get(num).add(array[i]);
        }

        //桶内排序
        for (int i = 0; i < bucketList.size(); i++) {
            //jdk的排序速度当然信得过
            Collections.sort(bucketList.get(i));
        }

        //写入原数组
        int index = 0;
        for (ArrayList<Integer> arrayList : bucketList) {
            for (int value : arrayList) {
                array[index] = value;
                index++;
            }
        }

        System.out.println("排序后：" + Arrays.toString(array));
    }

    /**
     * 桶排序，计数排序的升级版，将计数排序的一个计数排序数组细化成多个（自定义），各个自定义数据自我排序后，在进行
     * 各个桶的拼接
     *
     * @param array      需排序的数组
     * @param bucketSize 每个桶装几个数
     */
    public static void sort2(int[] array, int bucketSize) {
        if (null == array || array.length < 2) return;
        System.out.println("排序前：" + Arrays.toString(array));
        int arrLen = array.length;
        //获取排序数据的排序范围
        int min = array[0];// 最大值
        int max = array[0]; // 最小值
        for (int i = 0; i < arrLen; i++) {
            if (min > array[i]) {
                min = array[i];
            } else if (max < array[i]) {
                max = array[i];
            }
        }
        //原数组的 数字范围
        int diff = max - min;
        // 需要几个桶
        int length = arrLen / bucketSize;
        // 每个桶放那些数（存数区间）
        float section = (float) diff / (float) length;

        //初始化所有的桶
//        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();

        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(length);
//        for (int i = 0; i < length; i++) {
//            buckets.add(new ArrayList<Integer>());
//        }
        //将多有的数放入桶中
        for (int i = 0; i < arrLen; i++) {
            int num = (int) (array[i] / section) - 1;
            if (0 > num) num = 0;
            buckets.get(num).add(array[i]);
        }
        //将各个桶中的数进行排序
        for (int i = 0; i < bucketSize; i++) {
            Collections.sort(buckets.get(i));
        }
        //将桶中的数据放入原数组中
        int index = 0;

        for (ArrayList<Integer> temp : buckets) {
            for (int temp2 : temp) {
                array[index] = temp2;
                index++;
            }
        }
        if ((index) != (arrLen - 1)) System.out.println("将桶中的数据放入原数组时出现问题...");
        System.out.println("排序后：" + Arrays.toString(array));
    }

    /**
     * 桶排序
     *
     * @param array
     * @param bucketSize
     * @return
     */
    public static ArrayList<Integer> BucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) { // 如果带排序数组中有重复数字时  感谢 @见风任然是风 朋友指出错误
                for (int j = 0; j < bucketArr.get(i).size(); j++)
                    resultArr.add(bucketArr.get(i).get(j));
            } else {
                if (bucketCount == 1)
                    bucketSize--;
                ArrayList<Integer> temp = BucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++)
                    resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }


    public static void main(String[] args) {
        int[] arr = {9, 3, 5, 4, 9, 1, 2, 7, 8, 1, 3, 6, 5, 3, 4, 0, 10, 9, 7, 9};
//        sort(arr);
        sort(arr, 4);

//        float a1 = 10f/3f;
//        System.out.println(a1); // 3.3333333
//        float a2 = (float)(10/3);
//        System.out.println(a2); //3.0

    }

}
