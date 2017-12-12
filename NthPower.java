package algorithmHW;

import java.util.Scanner;

public class NthPower {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter a positive integer for x: ");
		int x = scan.nextInt();
		System.out.println("Now enter a positive integer for n: ");
		int n = scan.nextInt();
		System.out.println("The result is : " + power(x, n));

	}

	public static int power(int x, int n) {

		int pow = 1;
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		if (n % 2 == 0) {
			pow = power(x, n / 2);
			return pow * pow;
		} else {
			pow = power(x, n / 2);
			return pow * pow * x;
		}
	}

}
