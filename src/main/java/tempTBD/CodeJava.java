package tempTBD;

import java.util.Scanner;

public class CodeJava {

	public static void main(String[] args) {
		// PowerCalculator (beHezka)
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter base number: ");
		int base = scanner.nextInt();
		System.out.print("Enter power-exponent: ");
		int exponent = scanner.nextInt();
		int result = 1; // start the 1st iteration with  multiply the number by 1
		// then you'll keep on multiply (the result with orig number), as many times as needed (exponent)
		for (int i = 1; i <= exponent; i++) {
			result = result * base;
		}
		System.out.println(base + " raised to " + exponent + "ed power, is: " + result);
		scanner.close();
	}
}