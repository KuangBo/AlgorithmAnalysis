package cn.nonrecursivetest;

import java.util.Arrays;
import java.util.Stack;

public class Nonrecursive {

	/**
	 * 非递归实现快速排序
	 */
	public static void NonrecursiveQuick(int[] arr, int start, int end) {
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
	}

	public static void swap(int[] arr, int i, int j) {
		if (arr != null && i != j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 99, 100, 101, 102, 103, 104 };
		NonrecursiveQuick(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
