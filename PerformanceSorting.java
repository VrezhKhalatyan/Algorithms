package algorithmHW;

public class PerformanceSorting {

	public static void main(String[] args) {
		int array1[] = new int[100];
		int array2[] = new int[10000];
		int array3[] = new int[1000000];
		for (int i = 0; i < array1.length; i++) {
			array1[i] = (int) (Math.random() * 600);
		}
		for (int i = 0; i < array2.length; i++) {
			array2[i] = (int) (Math.random() * 600);
		}
		for (int i = 0; i < array3.length; i++) {
			array3[i] = (int) (Math.random() * 600);
		}

		System.out.println(" 2) Comparison of mergeSort and insertionSort: ");
		final long start = System.currentTimeMillis();
		mergeSort(array1, 0, 100);
		final long stop = System.currentTimeMillis();
		final long total = stop - start;
		System.out.println("The time performance of mergeSort of 100: " + total);

		final long a = System.currentTimeMillis();
		mergeSort(array2, 0, 10000);
		final long b = System.currentTimeMillis();
		final long tot = b - a;
		System.out.println("The time performance of mergeSort of 10000: " + tot);

		final long x = System.currentTimeMillis();
		mergeSort(array3, 0, 1000000);
		final long y = System.currentTimeMillis();
		final long fin = y - x;
		System.out.println("The time performance of mergeSort of 1000000: " + fin);

		System.out.println("----------------------------------------------------------------");

		int array4[] = new int[100];
		int array5[] = new int[10000];
		int array6[] = new int[1000000];
		for (int i = 0; i < array4.length; i++) {
			array4[i] = (int) (Math.random() * 600);
		}
		for (int i = 0; i < array5.length; i++) {
			array5[i] = (int) (Math.random() * 600);
		}
		for (int i = 0; i < array6.length; i++) {
			array6[i] = (int) (Math.random() * 600);
		}
		final long begin = System.currentTimeMillis();
		insertionSort(array4, 100);
		final long end = System.currentTimeMillis();
		final long t = end - begin;
		System.out.println("The time performance of insertionSort of 100: " + t);

		final long c = System.currentTimeMillis();
		insertionSort(array5, 10000);
		final long d = System.currentTimeMillis();
		final long f = d - c;
		System.out.println("The time performance of insertionSort of 10000: " + f);

		final long g = System.currentTimeMillis();
		insertionSort(array6, 1000000);
		final long h = System.currentTimeMillis();
		final long fi = h - g;
		System.out.println("The time performance of insertionSort of 1000000: " + fi);
	}

	public static void mergeSort(int[] a, int p, int q) {
		int n = q - p;

		if (n <= 1) {
			return;
		}
		int mid = p + n / 2;

		mergeSort(a, p, mid);
		mergeSort(a, mid, q);

		int[] temp = new int[n];
		int i = p;
		int j = mid;

		for (int k = 0; k < n; k++) {
			if (i == mid) {
				temp[k] = a[j++];
			} else if (j == q) {
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

	public static void insertionSort(int[] list, int n) {

		list = new int[n];
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
	}

}
