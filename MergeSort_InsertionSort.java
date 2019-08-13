package algorithmHW;

public class Assignment3 {

	public static void main(String[] args) {
		int array[] = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 50);
		}

		mergeSort(array, 0, 10);
		System.out.println(" 1) The mergeSort(): ");
		for (int i = 0; i < 10; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

	}

	public static void mergeSort(int[] a, int p, int r) {
		int n = r - p;

		if (n <= 1) {
			return;
		}
		int mid = p + n / 2;

		mergeSort(a, p, mid);
		mergeSort(a, mid, r);

		int[] temp = new int[n];
		int i = p;
		int j = mid;

		for (int k = 0; k < n; k++) {
			if (i == mid) {
				temp[k] = a[j++];
			} else if (j == r) {
				temp[k] = a[i++];
			} else if (a[j] < a[i]) {
				temp[k] = a[j++];
			} else {
				temp[k] = a[i++];
			}
		}
		for (int k = 0; k < n; k++) {
			a[p + k] = temp[k];
		}

	}

	public static void insertionSort(int[] list) {

		list = new int[10];
		for (int i = 0; i < list.length; i++) {
			list[i] = (int) (Math.random() * 50);
		}
		for (int j = 1; j < list.length; j++) {
			int key = list[j];
			int i;
			for (i = j - 1; i >= 0 && list[i] > key; i--) {
				list[i + 1] = list[i];
			}
			list[i + 1] = key;
		}
		System.out.println("2)The sorted list using insertionSort(): ");
		System.out.println(java.util.Arrays.toString(list));
	}

}
