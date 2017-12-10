package cn.test;

import java.math.BigDecimal;

import cn.util.RandomSeeds;

public class TestDemo {

	public static void main(String[] args) throws Exception {
		// 获取随机种子数
		// int scale = 280000;
		int scale = 75000;
		int[] arr = new int[scale];
		arr = RandomSeeds.RandSeeds(scale);
		Sort.QuickSort(arr, 0, scale - 1);

		// 计算运行时间
		long begintime = System.currentTimeMillis();

		Sort.BubbleSort(arr, scale);
		// Sort.InsertionSort(arr, scale);
		// Sort.QuickSort(arr, 0, scale - 1);
		// Sort.MergeSort(arr, 0, scale - 1);
		// Sort.HeapSort(arr, scale);

		long endtime = System.currentTimeMillis();
		long costTime = (endtime - begintime);
		BigDecimal b = new BigDecimal(costTime);
		double cost = b.divide(new BigDecimal(1000), 10, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(cost);

		// 计算运行时间
		begintime = System.currentTimeMillis();
		Sort.InsertionSort(arr, scale);
		endtime = System.currentTimeMillis();
		costTime = (endtime - begintime);
		b = new BigDecimal(costTime);
		cost = b.divide(new BigDecimal(1000), 10, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(cost);

		/*
		 * // 计算运行时间 begintime = System.currentTimeMillis(); Sort.QuickSort(arr,
		 * 0, scale - 1); endtime = System.currentTimeMillis(); costTime =
		 * (endtime - begintime); b = new BigDecimal(costTime); cost =
		 * b.divide(new BigDecimal(1000), 10,
		 * BigDecimal.ROUND_HALF_UP).doubleValue(); System.out.println(cost);
		 */

		// 计算运行时间
		begintime = System.currentTimeMillis();
		Sort.MergeSort(arr, 0, scale - 1);
		// Sort.HeapSort(arr, scale);
		endtime = System.currentTimeMillis();
		costTime = (endtime - begintime);
		b = new BigDecimal(costTime);
		cost = b.divide(new BigDecimal(1000), 10, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(cost);

		// 计算运行时间
		begintime = System.currentTimeMillis();
		Sort.HeapSort(arr, scale);
		endtime = System.currentTimeMillis();
		costTime = (endtime - begintime);
		b = new BigDecimal(costTime);
		cost = b.divide(new BigDecimal(1000), 10, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(cost);
	}
}
