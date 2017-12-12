package algorithmHW;

import java.util.Scanner;

public class Assignment1 {

	public static void main(String[] args) {
		int x = 3;
		int count = 1;

		System.out.println("1)");
		findPrimeNumbers1(x, count);
		System.out.println(" ");

		System.out.println(" ");
		System.out.println("2)");
		findPrimeNumbers2();
		System.out.println(" ");

		System.out.println(" ");
		System.out.println("3)");
		primefactor(count);

	}

	static void findPrimeNumbers1(int x, int count) {

		Scanner s = new Scanner(System.in);
		System.out.println("Please enter n prime numbers to exhibit");
		System.out.println("---------------------------------------");
		int n = s.nextInt();
		if (n >= 1) {
			System.out.print("The set of prime numbers are: ");
			System.out.print(2);
		}
		for (int i = 2; i <= n;) {
			for (int j = 2; j <= Math.sqrt(x); j++) {
				if (x % j == 0) {
					count = 0;
					break;
				}
			}
			if (count != 0) {
				System.out.print("," + x);
				i++;
			}
			count = 1;
			x++;
		}
	}

	public static void findPrimeNumbers2() {

		Scanner s = new Scanner(System.in);
		System.out.println("Please enter n prime numbers to exhibit");
		System.out.println("---------------------------------------");
		int n = s.nextInt();
		boolean prime = true;
		for (int i = 2; i <= n - 1; i++) {
			int currentNum = i;
			for (int j = 2; j < currentNum; j++) {
				if (currentNum % j == 0) {
					prime = false;
					break;
				}
			}
			if (prime) {
				System.out.print(currentNum + ",");
			}
			prime = true;
		}
	}

	public static void primefactor(int count) {

		System.out.println("Please enter a number greater than 1 for it's prime factorization: ");
		System.out.println("------------------------------------------------------------------");
		Scanner s = new Scanner(System.in);
		int number = s.nextInt();
		for (int i = 2; i <= number; i++) {
			count = 0;
			while (number % i == 0) {
				number /= i;
				count++;
			}
			if (count != 0) {
				System.out.println(i + "^" + count);
			}
		}
	}

}
