package cn.bubbletest;

public class BubbleSortTest {

	public static void main(String[] args) {
		// Integer a[] = { 29, 93, 29, 96, 94, 51 };
		Integer a[] = { 81, 51, 97, 15, 41 };
		BubbleSort(a, a.length);
	}

	public static void BubbleSort(Integer[] a, int n) {
		int q = 0;
		int l = 1;
		for (int i = 1; i <= n - 1; i++) {
			boolean hasSwap = false;
			for (int j = n - 1; j >= i; j--) {
				hasSwap = false;
				if (a[j] > a[j - 1]) {
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
					hasSwap = true;
					q++;
				}
				System.out.print(i + "\t" + j + "\t");
				for (int k = 0; k < a.length; k++) {
					System.out.print(a[k] + "\t");
				}
				System.out.println(hasSwap + "\t" + l + "\t" + q + "\t");
				l++;
			}
			if (!hasSwap)
				break;
		}
	}
}
