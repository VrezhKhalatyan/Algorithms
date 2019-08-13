package algorithmHW;

public class Assignment2 {

	public static void main(String[] args) {

		selectionSort();
		System.out.println(" ");
		insertionSort();
		System.out.println(" ");
		// treeTransformation();

	}

	public static void selectionSort() {

		int[] list = new int[10];
		for (int i = 0; i < list.length; i++) {
			list[i] = (int) (Math.random() * 50);
		}

		for (int i = 0; i < list.length - 1; i++) {
			int currentMin = list[i];
			int currentMinIndex = i;

			for (int j = i + 1; j < list.length; j++) {
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}

			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
		System.out.println("1)The sorted list using selectionSort(): ");
		System.out.println(java.util.Arrays.toString(list));
	}

	public static void insertionSort() {

		int[] list = new int[10];
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
