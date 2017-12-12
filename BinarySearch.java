package algorithmHW;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		int[] array = new int[20];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 30);
		}
		Arrays.sort(array);
		search(array);

	}

	public static void search(int[] array) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a value v to find");
		int v = scan.nextInt();

		int first = 0;
		int last = 20 - 1;
		int middle = (first + last) / 2;

		while (first <= last) {
			if (array[middle] < v) {
				first = middle + 1;
			} else if (array[middle] == v) {
				System.out.println(v + " was found at location " + (middle + 1));
				break;
			} else {
				last = middle - 1;
			}
			middle = (first + last) / 2;
		}
		if (first > last) {
			System.out.println(v + " is not present in the array.\n");
		}
	}

}
