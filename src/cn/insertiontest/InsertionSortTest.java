package cn.insertiontest;

public class InsertionSortTest {

	public static void main(String[] args) {
		// Integer a[] = { 290, 931, 292, 963, 944, 515 };
		Integer a[] = { 81, 51, 97, 15, 41 };
		// Integer a[] = { 70, 851, 972, 643, 314, 285 };
		// Integer a[] = { 96, 43, 84, 89, 72, 43 };
		InsertionSort(a, a.length);
	}

	public static void InsertionSort(Integer[] a, int n) {
		int q = 0;
		int l = 1;
		int x, j;
		for (int i = 1; i < n; i++) {
			x = a[i];
			j = i - 1;
			while (j >= 0 && a[j] > x) {
				a[j + 1] = a[j];
				q++;
				System.out.print(i + "\t" + j + "\t");
				for (int k = 0; k < a.length; k++) {
					System.out.print(a[k] + "\t");
				}
				System.out.println(x + "\t" + l + "\t" + q + "\t");
				l++;
				j--;
			}
			a[j + 1] = x;
			if (!(j >= 0 && a[j] > x)) {
				System.out.print(i + "\t" + j + "\t");
				for (int k = 0; k < a.length; k++) {
					System.out.print(a[k] + "\t");
				}
				System.out.println(x + "\t" + l + "\t" + q + "\t");
				l++;
			}
		}
	}
}
