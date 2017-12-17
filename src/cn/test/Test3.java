package cn.test;

import java.math.BigDecimal;
import java.util.Arrays;

import cn.util.RandomSeeds;
import cn.util.WriteToExcelUtil;

public class Test3 { // 第三题

	@SuppressWarnings("null")
	public static void main(String[] args) throws Exception {
		// 获取随机种子数
		// int scale = 280000;
		int s[] = { 3750, 7500, 37500, 75000 };
		String title[][] = new String[4][6];
		double context[][] = new double[20][6];
		int i = 0;
		int j = 0;
		int len = s.length;
		for (; i < len; i++) {
			int scale = s[i];

			title[j][0] = String.valueOf(scale);
			System.out.println(title[i][0] + " ");
			title[j][1] = "冒泡排序";
			title[j][2] = "插入排序";
			title[j][3] = "快速排序";
			title[j][4] = "合并排序";
			title[j][5] = "堆排序";
			j++;

			double[][] temp = new double[5][6];
			for (int k = 0; k < 5; k++) {
				temp[k][0] = k + 1;
				int[] arr = new int[scale];
				arr = RandomSeeds.RandSeeds(scale);
				Sort.QuickSort(arr, 0, scale - 1);

				// 计算运行时间
				long begintime = System.currentTimeMillis();
				Sort.BubbleSort(arr, scale);
				long endtime = System.currentTimeMillis();
				long costTime = (endtime - begintime);
				BigDecimal b = new BigDecimal(costTime);
				double cost = b.divide(new BigDecimal(1000), 10, BigDecimal.ROUND_HALF_UP).doubleValue();
				System.out.print(cost + " ");
				temp[k][1] = cost;

				// 计算运行时间
				begintime = System.currentTimeMillis();
				Sort.InsertionSort(arr, scale);
				endtime = System.currentTimeMillis();
				costTime = (endtime - begintime);
				b = new BigDecimal(costTime);
				cost = b.divide(new BigDecimal(1000), 10, BigDecimal.ROUND_HALF_UP).doubleValue();
				System.out.print(cost + " ");
				temp[k][2] = cost;

				// 计算运行时间
				begintime = System.currentTimeMillis();
				Sort.NonrecursiveQuick(arr, 0, arr.length - 1);
				endtime = System.currentTimeMillis();
				costTime = (endtime - begintime);
				b = new BigDecimal(costTime);
				cost = b.divide(new BigDecimal(1000), 10, BigDecimal.ROUND_HALF_UP).doubleValue();
				System.out.print(cost + " ");
				temp[k][3] = cost;

				// 计算运行时间
				begintime = System.currentTimeMillis();
				Sort.MergeSort(arr, 0, scale - 1);
				// Sort.HeapSort(arr, scale);
				endtime = System.currentTimeMillis();
				costTime = (endtime - begintime);
				b = new BigDecimal(costTime);
				cost = b.divide(new BigDecimal(1000), 10, BigDecimal.ROUND_HALF_UP).doubleValue();
				System.out.print(cost + " ");
				temp[k][4] = cost;

				// 计算运行时间
				begintime = System.currentTimeMillis();
				Sort.HeapSort(arr, scale);
				endtime = System.currentTimeMillis();
				costTime = (endtime - begintime);
				b = new BigDecimal(costTime);
				cost = b.divide(new BigDecimal(1000), 10, BigDecimal.ROUND_HALF_UP).doubleValue();
				System.out.print(cost + " \n");
				temp[k][5] = cost;
			}
			System.out.println("******");
			System.arraycopy(temp, 0, context, i * 5, temp.length);
		}
		System.out.println(Arrays.deepToString(title));
		System.out.println(Arrays.deepToString(context));
		WriteToExcelUtil.write(title, context, s);
	}
}
