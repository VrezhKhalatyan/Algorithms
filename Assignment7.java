package algorithmHW;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Assignment7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(23);
		list.add(3);
		list.add(15);
		list.add(9);
		list.add(100);

		quickSort(list, 0, list.size() - 1);
		System.out.println("1) Implementation of the Randomized Quick Sort");
		System.out.print("[");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.print("]");
		System.out.println(" ");
		//////////////////////////////

		System.out.println(" ");
		System.out.println("2) Implementation of the Counting Sort");
		System.out.println("Please input k for upper_bound");
		int k = scan.nextInt();
		System.out.println("Please input n for the number of integers");
		int n = scan.nextInt();

		int[] cList = new int[n];

		for (int i = 0; i < n; i++) {
			int randNumbers = (int) (Math.random() * k + 1);
			cList[i] = randNumbers;
		}
		printArray(countingSort(cList, n, k));
		////////////////////////////////

		System.out.println(" ");
		System.out.println("3) Radix Sort");
		System.out.println("Please enter d for # of digits for each integer");
		int d = scan.nextInt();
		System.out.println("Please enter n for # of integers");
		int n2 = scan.nextInt();
		int[] rList = new int[n2];
		int lower_bound = (int) Math.pow(10, d - 1);
		int upper_bound = 9 * lower_bound;

		for (int i = 0; i < n2; ++i) {
			rList[i] = lower_bound + random.nextInt(upper_bound);
		}

		radixSort(rList, d);
		System.out.print("[");
		for (int i = 0; i < rList.length; i++) {
			System.out.print(rList[i] + " ");
		}
		System.out.println("]");
	}

	public static int partition(ArrayList<Integer> list, int beginning, int end) {
		int randomPivot = beginning + ((int) Math.random() * (list.size())) / (end - beginning + 1);
		int last = end;

		swap(list, randomPivot, end);
		end--;

		while (beginning <= end) {
			if (list.get(beginning) < list.get(last)) {
				beginning++;
			} else {
				swap(list, beginning, end);
				end--;
			}
		}

		swap(list, beginning, last);
		return beginning;
	}

	public static void swap(ArrayList<Integer> list, int i, int j) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	public static void quickSort(ArrayList<Integer> list, int beginning, int end) {
		if (beginning >= end) {
			return;
		}
		if (beginning < 0) {
			return;
		}
		if (end > list.size() - 1) {
			return;
		}

		int pivot = partition(list, beginning, end);
		quickSort(list, beginning, pivot - 1);
		quickSort(list, pivot + 1, end);
	}

	public static int[] countingSort(int[] a, int n, int k) {

		int[] b = new int[a.length];
		int[] c = new int[k + 1];
		for (int i = 0; i < a.length; i++)
			c[a[i]] = c[a[i]] + 1;
		for (int i = 1; i < c.length; i++)
			c[i] = c[i] + c[i - 1];
		for (int j = a.length - 1; j >= 0; j--) {
			b[c[a[j]] - 1] = a[j];
			c[a[j]] = c[a[j]] - 1;
		}
		return b;
	}

	public static void radixSort(int[] a, int d) {
		ArrayList<Integer>[] buckets = new ArrayList[10];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new java.util.ArrayList<Integer>();
		}

		for (int position = 0; position <= d; position++) {
			for (int i = 0; i < buckets.length; i++) {
				buckets[i].clear();
			}

			for (int i = 0; i < a.length; i++) {
				int key = getKey(a[i], position);
				buckets[key].add(a[i]);
			}
			int k = 0;
			for (int i = 0; i < buckets.length; i++) {
				for (int j = 0; j < buckets[i].size(); j++)
					a[k++] = buckets[i].get(j);
			}
		}
	}

	public static void printArray(int[] a) {
		System.out.print("[");
		for (int x : a) {
			System.out.print(x + " ");
		}
		System.out.println("]");
		System.out.println("");
	}

	public static int getKey(int number, int position) {
		int result = 1;
		for (int i = 0; i < position; i++)
			result *= 10;

		return (number / result) % 10;
	}

}
