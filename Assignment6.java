package algorithmHW;

public class Assignment6 {

	public static void main(String[] args) {

		int[] array = new int[] { 23, 15, 3, 9, 86, 11, 1, 20, 50 };
		heapSort(array);

		System.out.println("1) HeapSort()");
		System.out.print("[");
		for (int i : array) {
			System.out.print(i + ", ");
		}
		System.out.println("]");
		System.out.print('\n');
		///////////////////////////////////////// merging K arrays
		int[] array1 = { 2, 6, 7, 10, 11, 12};
		int[] array2 = { 3, 4, 5, 8, 9 };

		int[][] arrays = { array1, array2 };
		System.out.print('\n');
		System.out.println("2) merge k sorted lists into a single list");
		printArray(merge(arrays));

	}

	private static void heapSort(int[] array) {

		int length = array.length;

		buildMaxHeap(array, length);
		for (int i = length - 1; i > 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			maxHeapify(array, 1, i);
		}
	}

	private static void buildMaxHeap(int[] array, int n) {

		if (array == null) {
			throw new NullPointerException("null");
		}
		if (array.length <= 0 || n <= 0) {
			throw new IllegalArgumentException("illegal");
		}
		if (n > array.length) {
			n = array.length;
		}
		for (int i = n / 2; i > 0; i--) {
			maxHeapify(array, i, n);
		}
	}

	private static void maxHeapify(int[] array, int i, int n) {

		int l = i * 2;
		int r = l + 1;
		int largest;

		if (l <= n && array[l - 1] > array[i - 1]) {
			largest = l;
		} else {
			largest = i;
		}

		if (r <= n && array[r - 1] > array[largest - 1]) {
			largest = r;
		}

		if (largest != i) {
			int temp = array[i - 1];
			array[i - 1] = array[largest - 1];
			array[largest - 1] = temp;
			maxHeapify(array, largest, n);
		}
	}

	public static void printArray(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++){
			System.out.printf("%d ", array[i]);
		}
		System.out.println("]");
		System.out.print('\n');
	}

	private static int[] merge(int[][] arrays) {
		int[] mergedArray = arrays[0];

		for (int i = 1; i < arrays.length; i++) {
			mergedArray = mergeKArrays(mergedArray, arrays[i]);
		}

		return mergedArray;
	}

	private static int[] mergeKArrays(int[] array1, int[] array2) {
		int left = 0;
		int right = 0;

		int[] newMergedArray = new int[array1.length + array2.length];
		int i = 0;

		while (true) {
			if (array1[left] < array2[right]) {
				newMergedArray[i++] = array1[left++];
				if (left == array1.length) {
					while (right != array2.length) {
						newMergedArray[i++] = array2[right++];
					}
					break;
				}
			} else {
				newMergedArray[i++] = array2[right++];
				if (right == array2.length) {
					while (left != array1.length) {
						newMergedArray[i++] = array1[left++];
					}
					break;
				}
			}
		}

		return newMergedArray;
	}
}
