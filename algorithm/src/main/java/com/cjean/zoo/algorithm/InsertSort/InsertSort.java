package com.cjean.zoo.algorithm.InsertSort;


import java.util.Arrays;

/**
 * 插入排序算法
 * 
 * @author chu_c
 *
 */
public class InsertSort {

	public static void sort2(int[] arr) {
		System.out.println("-----start------");
		System.out.println(Arrays.toString(arr));
		System.out.println("-----------");

		int len = arr.length;

		/**
		 * 从左边数第一个开始向左比较大小，如果左边的比临时变量大，
		 * 就把右边位置的值也赋成左边（大的数）的值，
		 * 依次类推，最后跳出循环，将临时变量赋值给0位置的或者临时变量比较后是小的
		 *
		 * 如：5 4 2 1 中
		 * 当比较到2为临时变量时
		 *
		 * 1.5 4 2 1   2
		 * 2.5 4 4 1   2
		 * 3.5 5 4 1   2
		 * 4.2 5 4 1   2
		 * 这个只是例子，
		 *
		 * 因为，插入算法的逻辑，是从最左边或最右边卡开始排序，当开始比较的数的左边或者右边的数必定是排序后的
		 * 1.5 4 2 1   4
		 * 2.5 5 4 1   4
		 * 3.4 5 2 1   4
		 *
		 * 1.4 5 2 1   2
		 * 2.4 5 5 1   2
		 * 3.4 4 5 1   2
		 * 4.2 4 5 1   2
		 */
		for (int i = 1; i < len; i++) {
			int temp = arr[i];
			int index = i - 1;
			while (index >= 0 && temp < arr[index]) {
				arr[index + 1] = arr[index];
				arr[index] = temp;
				index--;
			}

		}
		System.out.println("------end-----");
		System.out.println(Arrays.toString(arr));
		System.out.println("-----------");

	}

	public static void main(String[] args) {
		int[] args1 = { 12, 134, 195, 21, 1, 61, 981, 88};
		int[] args2 = null;
		sort2(args1);
	}

}