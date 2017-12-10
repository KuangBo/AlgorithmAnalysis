package cn.util;

import java.util.Random;

public class RandomSeeds {
	/**
	 * 进行测试数据的生成，其中Random(666)，创建一个种子为666的随机数生成器
	 * 
	 * @param scale测试数据个数
	 * @return返回需要的测试数据
	 */
	public static int[] RandSeeds(int scale) {
		int[] arr = new int[scale];
		Random random = new Random(666);
		for (int i = 0; i < scale; i++) {
			arr[i] = random.nextInt(Integer.MAX_VALUE);
		}
		return arr;
	}
}
