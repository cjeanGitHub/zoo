package com.cjean.zoo.algorithm.BubbleSort;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSortMethod2(int[] args) {

        int len = args.length;
        int temp;

        // i 可以把当前循环范围内最大的数冒泡到范围内最后一个位置
        for (int i = 0; i < len; i++) { //控制循环多少次
            for (int j = 1; j < len - i; j++) {  // len - i ： 因为每经过一次 i 循环，i范围内的最后一个数一定是最大的，不需要再参与比较循环
//控制每次循环时，进行和前一个数据的大小对比，并且对比过的位置，不在进行对比j < len-i
                if (args[j - 1] > args[j]) {  //目前位置的数据比前一个小，进行数据交换
                    temp = args[j - 1];
                    args[j - 1] = args[j];
                    args[j] = temp;
                }
//                System.out.println(Arrays.toString(args));
            }
//            System.out.println("**************");
//            System.out.println(Arrays.toString(args));
//            System.out.println("**************");
        }
        System.out.println("-----------");
        System.out.println(Arrays.toString(args));
        System.out.println("-----------");

    }

    public static void main(String[] args) {
        int[] args1 = {12, 134, 195, 21, 1, 61, 981, 88};
        bubbleSortMethod2(args1);
    }

}