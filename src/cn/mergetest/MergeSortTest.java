package cn.mergetest;

public class MergeSortTest {

	static int q = 0; // 比较次数
	static int l = 0; // 移动次数

	public static void main(String[] args) {
		// int a[] = { 290, 931, 292, 963, 944, 515 };
		// int a[] = { 81, 51, 97, 15, 41 };
		int a[] = { 19, 37, 95, 98, 39, 34 };
		System.out.println("【Dleft与Dright表示分解过程，M表示合并过程】");
		MergeSort(a, 0, 5);
	}

	public static void MergeSort(int a[], int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;

			System.out.print("---Dleft---,low = " + low + ",mid = " + mid + ",high = " + high + "\t");
			for (int i = low; i <= high; i++) {
				System.out.print(a[i] + "、");
			}
			System.out.println();
			MergeSort(a, low, mid);

			System.out.print("---Dright---,low = " + (mid + 1) + ",mid = " + high + ",high = " + high + "\t");
			for (int i = low; i <= high; i++) {
				System.out.print(a[i] + "、");
			}
			System.out.println();
			MergeSort(a, mid + 1, high);

			System.out.println("【M】进入排序的三个参数,low = " + low + ",mid = " + mid + ",high = " + high);
			Merge2SortedSubArr(a, low, mid, high);
		}
	}

	public static void Merge2SortedSubArr(int a[], int low, int mid, int high) {
		System.out.println();
		System.out.println("+++++++++++++开始++++++++++++");
		int[] b = new int[high + 1];
		int i = low, j = mid + 1, k = low;
		while (i <= mid && j <= high) {
			if (a[i] <= a[j]) {
				b[k++] = a[i++];

				q++;
				l++;
				System.out.print("***M***p = " + low + ",q = " + mid + ",r = " + high + ",i = " + i + ",j = " + j
						+ ",k = " + k + ",q = " + q + ",l = " + l + "\t");
				for (int aa = low; aa < k; aa++) {
					System.out.print(b[aa] + "、");
				}
				System.out.println();
			} else {
				b[k++] = a[j++];

				q++;
				l++;
				System.out.print("***M***p = " + low + ",q = " + mid + ",r = " + high + ",i = " + i + ",j = " + j
						+ ",k = " + k + ",q = " + q + ",l = " + l + "\t");
				for (int aa = low; aa < k; aa++) {
					System.out.print(b[aa] + "、");
				}
				System.out.println();
			}
		}
		if (i == mid + 1) {
			for (; j <= high; j++) {
				b[k++] = a[j];

				l++;
				System.out.print("***M***p = " + low + ",q = " + mid + ",r = " + high + ",i = " + i + ",j = " + j
						+ ",k = " + k + ",q = " + q + ",l = " + l + "\t");
				for (int aa = low; aa < k; aa++) {
					System.out.print(b[aa] + "、");
				}
				System.out.println();
			}
		} else {
			for (; i <= mid; i++) {
				b[k++] = a[i];

				l++;
				System.out.print("***M***p = " + low + ",q = " + mid + ",r = " + high + ",i = " + i + ",j = " + j
						+ ",k = " + k + ",q = " + q + ",l = " + l + "\t");
				for (int aa = low; aa < k; aa++) {
					System.out.print(b[aa] + "、");
				}
				System.out.println();
			}
		}
		for (i = low; i <= high; i++) {
			a[i] = b[i];

			l++;
			System.out.print("***M***p = " + low + ",q = " + mid + ",r = " + high + ",i = " + i + ",j = " + j + ",k = "
					+ k + ",q = " + q + ",l = " + l + "\t");
			for (int aa = low; aa < k; aa++) {
				System.out.print(b[aa] + "、");
			}
			System.out.println();
		}
		System.out.println("+++++++++++++结束++++++++++++");
		System.out.println();
	}
}
