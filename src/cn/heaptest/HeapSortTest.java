package cn.heaptest;

public class HeapSortTest {
	static int comp = 0; // 比较次数
	static int chan = 0; // 交换次数

	public static void main(String[] args) {
		// int a[] = { 29, 93, 29, 96, 94, 51 };
		int a[] = { 81, 51, 97, 15, 41 };
		HeapSort(a, 5);
	}

	public static void HeapSort(int H[], int n) {
		MakeHeap(H, n);
		System.out.println("*************排序*************");
		for (int i = n - 1; i > 0; i--) {
			int temp = H[0];
			H[0] = H[i];
			H[i] = temp;
			chan++;
			// 需要更正
			System.out.println("------------------------------------------------------");
			System.out.print("\tn = " + n + ",i = " + i + ",comp = " + comp + ",chan = " + chan + "\t");
			for (int aa = 0; aa <= 4; aa++) {
				System.out.print(H[aa] + "、");
			}
			System.out.println();
			System.out.println("------------------------------------------------------");
			System.out.println("***排序阶段***" + "n = " + n + ",i = " + i + ",comp = " + comp + ",chan = " + chan + "\t");
			SiftDown(H, i, 0);
		}
	}

	public static void MakeHeap(int H[], int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			System.out.println("***建堆阶段***" + "n = " + n + ",i = " + i + ",comp = " + comp + ",chan = " + chan + "\t");
			SiftDown(H, n, i);
		}
	}

	public static void SiftDown(int H[], int n, int i) {
		boolean done = false;
		while (!done && ((i = 2 * i + 1) < n)) {
			if ((i + 1 < n) && (H[i + 1] > H[i])) {
				i = i + 1;
				comp++;
				System.out.print("\tn = " + n + ",i = " + i + ",comp = " + comp + ",chan = " + chan + "\t");
				for (int aa = 0; aa <= 4; aa++) {
					System.out.print(H[aa] + "、");
				}
				System.out.println();
			}
			if (H[(i - 1) / 2] < H[i]) {
				comp++;
				int temp = H[(i - 1) / 2];
				H[(i - 1) / 2] = H[i];
				H[i] = temp;
				chan++;
				System.out.print("\tn = " + n + ",i = " + i + ",comp = " + comp + ",chan = " + chan + "\t");
				for (int aa = 0; aa <= 4; aa++) {
					System.out.print(H[aa] + "、");
				}
				System.out.println();
			} else {
				done = true;
			}
		}
	}

}
