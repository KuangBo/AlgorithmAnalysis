package cn.quicktest;

public class QuickSortTest {

	static int q = 0;
	static int l = 1;

	public static void main(String[] args) {
		int a[] = { 81, 51, 97, 15, 41 };
		// int a[] = { 290, 931, 292, 963, 944, 515 };
		// int a[] = { 96, 43, 84, 89, 72, 43 };
		QuickSort(a, 0, 4);
	}

	public static int[] QuickSort(int a[], int low, int high) {
		int p = 0;
		if (low < high) {
			p = partition(a, low, high);
			QuickSort(a, low, p - 1);
			QuickSort(a, p + 1, high);
		}
		return a;
	}

	public static int partition(int a[], int low, int high) {
		int pivot = a[high];
		int i = low - 1;
		int j = low;
		for (j = low; j <= high - 1; j++) {
			if (a[j] < pivot) {
				i = i + 1;
				if (i < j) {
					int temp1 = a[i];
					a[i] = a[j];
					a[j] = temp1;
					q++;
				}
			}
			System.out.print(i + "\t" + j + "\t");
			for (int k = 0; k < a.length; k++) {
				System.out.print(a[k] + "\t");
			}
			System.out.println(low + "\t" + high + "\t" + (i + 1) + "\t" + l + "\t" + q + "\t");
			l++;
		}
		if (a[high] < a[i + 1]) {
			int temp2 = a[i + 1];
			a[i + 1] = a[high];
			a[high] = temp2;
			q++;
			System.out.print(i + "\t" + j + "\t");
			for (int k = 0; k < a.length; k++) {
				System.out.print(a[k] + "\t");
			}
			System.out.println(low + "\t" + high + "\t" + (i + 1) + "\t" + l + "\t" + q + "\t");
			l++;
		}
		return i + 1;
	}

}
