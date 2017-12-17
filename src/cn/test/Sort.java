package cn.test;

import java.util.Stack;

public class Sort {
	/**
	 * 冒泡排序
	 * 
	 * @param a
	 * @param n
	 */
	public static void BubbleSort(int[] arr, int n) {
		int i, temp, len = arr.length;
		boolean changed;
		do {
			changed = false;
			for (i = 0; i < len - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					changed = true;
				}
			}
		} while (changed);
	}

	/**
	 * 插入排序
	 * 
	 * @param a
	 * @param n
	 */
	public static void InsertionSort(int[] a, int n) {
		int x, j;
		for (int i = 1; i < n; i++) {
			x = a[i];
			j = i - 1;
			while (j >= 0 && a[j] > x) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = x;
		}
	}

	/**
	 * 快速排序
	 * 
	 * @param a
	 * @param low
	 * @param high
	 * @return
	 */
	public static int[] QuickSort(int a[], int low, int high) {
		if (low < high) {
			int p = partition(a, low, high);
			QuickSort(a, low, p - 1);
			QuickSort(a, p + 1, high);
		}
		return a;
	}

	public static int partition(int a[], int low, int high) {
		int pivot = a[high];
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			if (a[j] < pivot) {
				i = i + 1;
				if (i < j) {
					int temp1 = a[i];
					a[i] = a[j];
					a[j] = temp1;
				}
			}
		}
		if (a[high] < a[i + 1]) {
			int temp2 = a[i + 1];
			a[i + 1] = a[high];
			a[high] = temp2;
		}
		return i + 1;
	}

	/**
	 * 合并排序
	 * 
	 * @param a
	 * @param low
	 * @param high
	 */
	public static void MergeSort(int a[], int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			MergeSort(a, low, mid);
			MergeSort(a, mid + 1, high);
			Merge2SortedSubArr(a, low, mid, high);
		}
	}

	public static void Merge2SortedSubArr(int a[], int low, int mid, int high) {
		int[] b = new int[high + 1];
		int i = low, j = mid + 1, k = low;
		while (i <= mid && j <= high) {
			if (a[i] <= a[j]) {
				b[k++] = a[i++];
			} else {
				b[k++] = a[j++];
			}
		}
		if (i == mid + 1) {
			for (; j <= high; j++) {
				b[k++] = a[j];
			}
		} else {
			for (; i <= mid; i++) {
				b[k++] = a[i];
			}
		}
		for (i = low; i <= high; i++) {
			a[i] = b[i];
		}
	}

	/**
	 * 堆排序
	 * 
	 * @param H
	 * @param n
	 */
	public static void HeapSort(int H[], int n) {
		MakeHeap(H, n);
		for (int i = n - 1; i > 0; i--) {
			int temp = H[0];
			H[0] = H[i];
			H[i] = temp;
			SiftDown(H, i, 0);
		}
	}

	public static void MakeHeap(int H[], int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			SiftDown(H, n, i);
		}
	}

	public static void SiftDown(int H[], int n, int i) {
		boolean done = false;
		while (!done && ((i = 2 * i + 1) < n)) {
			if ((i + 1 < n) && (H[i + 1] > H[i])) {
				i = i + 1;
			}
			if (H[(i - 1) / 2] < H[i]) {
				int temp = H[(i - 1) / 2];
				H[(i - 1) / 2] = H[i];
				H[i] = temp;
			} else {
				done = true;
			}
		}
	}

	/**
	 * 非递归实现快速排序
	 */
	public static int[] NonrecursiveQuick(int[] arr, int start, int end) {
		if (start < end) {
			Stack<Integer> startStack = new Stack<Integer>();
			Stack<Integer> endStack = new Stack<Integer>();

			startStack.push(start);
			endStack.push(end);

			while (startStack.size() > 0 && endStack.size() > 0) {
				int tempStart = startStack.pop();
				int tempEnd = endStack.pop();
				if (tempStart < tempEnd) {
					int povit = tempEnd;
					int left = tempStart;
					int right = tempEnd;

					while (left < right) {
						while (left < right && left != povit && arr[left] <= arr[povit]) {
							left++;
						}
						if (left < right) {
							swap(arr, left, povit);
							povit = left;
						}
						while (left < right && right != povit && arr[right] >= arr[povit]) {
							right--;
						}
						if (left < right) {
							swap(arr, right, povit);
							povit = right;
						}
					}
					startStack.push(tempStart);
					startStack.push(left + 1);
					endStack.push(left - 1);
					endStack.push(tempEnd);
				}
			}
		}
		return arr;
	}

	public static void swap(int[] arr, int i, int j) {
		if (arr != null && i != j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

}
