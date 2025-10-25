
public class SubarraySolver {
	/**
	 * Finds the maximum subarray sum using a brute-force approach. Theoretical
	 * Complexity: O(n^2) Explanation: Outer loop runs n times, Inner loop runs (n -
	 * i) times for each i,
	 */
	public static int bruteForceMaxSum(int[] arr) {
		int n = arr.length;
		int maxSum = Integer.MIN_VALUE;
		// n * (n-i) times
		for (int i = 0; i < n; i++) {
			int currentSum = 0;
			for (int j = i; j < n; j++) {
				currentSum += arr[j];
				if (currentSum > maxSum) {
					maxSum = currentSum;
				}
			}
		}
		return maxSum;
	}

	/**
	 * Finds the maximum subarray sum using Kadane's Algorithm. Theoretical
	 * Complexity: O(n)
	 *
	 * Explanation: single pass through the array: each element, performs
	 * constant-time operations: total primitive operations ≈ 3n → O(n)
	 */
	public static int kadanesAlgorithmMaxSum(int[] arr) {
		int maxSum = arr[0];
		int currentSum = arr[0];

		for (int i = 1; i < arr.length; i++) {
			currentSum = Math.max(arr[i], currentSum + arr[i]);
			maxSum = Math.max(maxSum, currentSum);
		}

		return maxSum;
	}
}
