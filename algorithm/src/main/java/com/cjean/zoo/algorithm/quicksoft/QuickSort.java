package com.cjean.zoo.algorithm.quicksoft;

import java.util.Random;

public class QuickSort {
    /**
     * 快速排序方法（假的，这个算法是从头到尾开始循环，与最后一个数比较，如果比最后一个数小于等于则记录小于等于时最后的数组下标（smallIndex++），
     * 如果循环下标大于记录下标（存在有比最后一个数大的数），则进入交换，比最后一个数大的和比最后一个数小于等于的进行交换
     * 当循环的数中有比最后一个数大的，则不进入循环 i++，smallIndex不变，
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] QuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        int smallIndex = partition(array, start, end);
//        if (smallIndex >= end) System.out.println(smallIndex);
        if (smallIndex > start)
            QuickSort(array, start, smallIndex - 1);//数组循环开始比较小大并交换，由右向左缩小循环比较范围,最后实现左边的比右边的小  C
        if (smallIndex < end)
            QuickSort(array, smallIndex + 1, end); //  与 C 相反
        return array;
    }

    /**
     * 快速排序算法——partition
     * <p>
     * 1 300 200 100
     * 1 100 300 200
     * 1 100 300 200
     * 1 100 200 300
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {

        // A: 在十次每次3万的排序下，加上这两句话的时间是10秒作用，不加是在3秒左右  ；但是 pivot 只是为了找个对比标准，并交换到数组end下标处
        // 获取基准
//        int pivot = (int) (start + Math.random() * (end - start + 1)); //基准没起作用  {A}
        int smallIndex = start - 1; //最后一次记录的符合条件的排序数数量
//        swap(array, pivot, end);  //蒙一下，随机的数是这个参数中最大的数的下标，大部分情况都是操蛋的  {A}
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) { //i出的数比end出的数小于等于
                smallIndex++;

                if (i > smallIndex)  //作用：在比较的时候 smallIndex 是在比较时小数的下标，执行下面的交换 实现
                    swap(array, i, smallIndex);
            }
        return smallIndex;
    }

    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * @param pData 需要排序的数组
     * @param left  左边的位置,初始值为0
     * @param right 右边的位置,初始值为数组长度
     */
    public static int[] QuickSort2(int[] pData, int left, int right) {

        int i, j;
        int first, temp;
        i = left;
        j = right;
        first = pData[left]; // 快速搜索算法的基准数，一般情况选择第一个数，但是也可以是数组内随机的数

        //无限循环 从左向右找比基准大的，从右向左找比基准小的，直至找到找完，寻找与基准比较后的数，并将每次循环出的数进行交换,
        while (true) {
            // 从左向右找一个比基准大的 并记录下标数
            while ((++i) < (right - 1) && pData[left] > pData[i]) ;
            // 从右向左  从第二个数开始找一个比基准小的 并记录下标数
            while ((--j) > left && pData[left] < pData[j]) ;
            //如果 循环完了，就结束
            if (i >= j) break;
            //每次找到一对大小数进行交换
            temp = pData[i];
            pData[i] = pData[j];
            pData[j] = temp;
        }
        //完成大小互换后，将基准与最后一次找到的最小的数进行交换，
        // 实现此次比较后，比基准大的在基准数的右边，小的在基准的左边
        pData[left] = pData[j];
        pData[j] = first;
        //将此次比较的数据进行以基准为中心进行比较
        if (j > left) QuickSort2(pData, left, j);
        if (i < right) QuickSort2(pData, i, right);
        return pData;

    }

    public static void main(String[] args) {
        // QuickSort 平均3秒左右
        // QuickSort2 平均2秒左右

        int[] args1 = {12, 134, 195, 21, 1, 61, 981, 88};
//        int[] args1 = { 123, 13};
        int[] args2 = null;
//        int[] args3 = {12, 134, 195, 21, 1, 61, 981, 88};
//        int[] args3 = {12, 134, 195, 21, 1, 61, 981, 88, 12};
//        int[] args3 = {134, 88};
//        int[] soft = QuickSort2(args3, 0, args3.length);
//        System.out.println(Arrays.toString(soft));

        int[] temp = new int[10000];
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int i1 = random.nextInt(10000) + 1;
            temp[i] = i1;
        }
        for (int j = 0; j < 10; j++) {
            long start = System.currentTimeMillis();
//            for (int i = 0; i < 30000; i++) {
            for (int i = 0; i < 300; i++) {
//                int[] args3 = {12, 134, 195, 21, 1, 61, 981, 88};
                int[] args3 = temp;
//                int[] soft = QuickSort(args3, 0, args3.length - 1);
                int[] soft = QuickSort2(args3, 0, args3.length);// 数量越多 这个越靠谱
//            System.out.println(Arrays.toString(soft));
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }


//        int[] soft = QuickSort(args1, 0 ,args1.length); // null
//        int[] soft = QuickSort(args1, 0, args1.length - 1); // [1, 12, 21, 61, 88, 134, 195, 981]
//        int[] soft1 = QuickSort2(args1, 0, args1.length - 1); // [1, 12, 21, 61, 88, 134, 195, 981]
//        int[] soft = QuickSort(args1, 0 ,args1.length-2); // [1, 12, 21, 61, 134, 195, 981, 88]
//        int[] soft = QuickSort(args1, 1 ,args1.length-1); // [12, 1, 21, 61, 88, 134, 195, 981]
//        int[] soft = QuickSort(args1, 2 ,args1.length-1); // [12, 134, 1, 21, 61, 88, 195, 981]
//        System.out.println(Arrays.toString(soft));
//        System.out.println(Arrays.toString(soft1));
    }
}
