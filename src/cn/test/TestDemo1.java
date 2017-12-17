package cn.test;

import java.math.BigDecimal;

import cn.util.RandomSeeds;

public class TestDemo1 {

	public static void main(String[] args) {
		// 获取随机种子数
		int scale = 7500; // 通过修改scale的值更改个数

		int[] arr = new int[scale];
		arr = RandomSeeds.RandSeeds(scale);

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
		System.out.println("运行了" + cost + "秒");
	}

}
