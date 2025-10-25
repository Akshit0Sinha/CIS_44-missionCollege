import java.util.Random;
public class SubarrayTester {

	// Generates a random integer array with values between -1000 and +1000 */
	public static int[] generateRandomArrayWithNegatives(int size) {
		// Implementation provided in previous response
		Random rand = new Random();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = rand.nextInt(2001) - 1000; // range -1000 - +1000
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] sizes = {1000, 5000, 10000, 50000, 100000};

		System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");
		System.out.printf("%-10s %-20s %-20s%n", "Array(n)", "Brute-Force Time (ms)", "Kadane’s Time (ms)");
		// TODO: Generate a random array and time both algorithms.

		for (int n : sizes) {
			int[] arr = generateRandomArrayWithNegatives(n);

			// --- Brute Force Timing ---
			long startTime = System.nanoTime();
			SubarraySolver.bruteForceMaxSum(arr);
			long bruteForceTime = (System.nanoTime() - startTime) / 1_000_000; // convert ms

			// --- Kadane’s Timing ---
			startTime = System.nanoTime();
			SubarraySolver.kadanesAlgorithmMaxSum(arr);
			long kadaneTime = (System.nanoTime() - startTime) / 1_000_000;

			System.out.printf("%-10d %-20d %-20d%n", n, bruteForceTime, kadaneTime);
		}
	}


}
