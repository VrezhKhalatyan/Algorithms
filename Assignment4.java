package algorithmHW;

public class Assignment4 {

	public static void main(String[] args) {
		int[] array = { -1, 3, -2, 5, -2, 6, -1, -4 };
		System.out.println("1) Max_Sub_Array using Divide and Conquer: ");
		System.out.print(" [ ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.print("]");
		System.out.println(" ");
		System.out.print(" The max_Sub_Array Sum is: " + maxSubArray(array, 0, array.length - 1));
		System.out.println(" ");
		indexOfSubArray(array, 0);
		// -------------------------------------------------------
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("2) Max_Sub_Array using Brute Force: ");
		System.out.print(" [ ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.print("]");
		System.out.println(" ");
		System.out.print(" The max_Sub_Array Sum is: " + maxSubArrayBrute(array, 0, array.length - 1));
		System.out.println(" ");
		indexOfSubArray(array, 0);
	}

	public static int maxSubCrossArray(int[] array, int low, int mid, int hi) {
		int leftSum = Integer.MIN_VALUE;
		int rightSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = mid; i >= low; i--) {
			sum += array[i];
			if (sum > leftSum) {
				leftSum = sum;
			}
		}
		sum = 0;
		for (int j = mid + 1; j <= hi; j++) {
			sum += array[j];
			if (sum > rightSum) {
				rightSum = sum;
			}
		}
		return leftSum + rightSum;
	}

	public static int maxSubArray(int[] array, int low, int hi) {
		if (low == hi) {
			return array[low];
		} else {
			int mid = (int) Math.floor((low + hi) / 2);
			int leftSum = maxSubArray(array, low, mid);
			int rightSum = maxSubArray(array, mid + 1, hi);
			int crossSum = maxSubCrossArray(array, low, mid, hi);
			if (leftSum >= rightSum && leftSum >= crossSum) {
				return leftSum;
			} else if (rightSum >= leftSum && rightSum >= crossSum) {
				return rightSum;
			} else {
				return crossSum;
			}
		}
	}

	public static int maxSubArrayBrute(int[] array, int lo, int hi) {
		int sum, max;
		max = array[1];
		for (int i = lo; i <= hi; i++) {
			sum = 0;
			for (int j = i; j <= hi; j++) {
				sum += array[j];
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}

	public static void indexOfSubArray(int[] array, int size) {
		int maxSoFar = Integer.MIN_VALUE;
		int maxEndingHere = 0;
		int start = 0;
		int end = 0;
		int s = 0;

		for (int i = 0; i < array.length; i++) {
			maxEndingHere = maxEndingHere + array[i];
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
				start = s;
				end = i;
			}
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
				s = i + 1;
			}
		}
		System.out.println(" The Sub_Array starts at index: " + start);
		System.out.println(" The Sub_Array ends at index: " + end);
	}
}
