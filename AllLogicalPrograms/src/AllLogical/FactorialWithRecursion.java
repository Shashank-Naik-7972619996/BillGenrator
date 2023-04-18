package AllLogical;

public class FactorialWithRecursion {

	public class Factorial {
		public static int factorial(int n) {
			if (n == 0) {
				return 1; // Base case: factorial of 0 is 1
			} else {
				return n * factorial(n - 1); // Recursive case: multiply n with factorial of (n-1)
			}
		}

		public static void main(String[] args) {
			int number = 5; // Example input number
			int result = factorial(number); // Call the factorial function
			System.out.println("Factorial of " + number + " is: " + result);
		}
	}

}
