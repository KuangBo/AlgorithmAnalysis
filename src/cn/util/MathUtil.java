package cn.util;

public class MathUtil {
	// 计算均值
	public static double getAverage(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return (double) (sum / arr.length);
	}

	// 计算方差
	public static double Variance(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {// 求和
			sum += arr[i];
		}
		double dAve = sum / arr.length;// 求平均值
		// double dAve = getAverage(arr);
		double dVar = 0;
		for (int i = 0; i < arr.length; i++) {// 求方差
			dVar += (arr[i] - dAve) * (arr[i] - dAve);
		}
		return dVar / arr.length;
	}
}
