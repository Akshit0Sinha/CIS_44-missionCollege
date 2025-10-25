public class SortingAlgorithms {
	/**
	 * Implements the Insertion Sort algorithm. Theoretical Complexity: O(n^2) /
	 * Best-Case: O(n)
	 */
	public static void insertionSort(int[] arr) {
		// TODO: Implement the Insertion Sort algorithm.
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}

	}

	private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
		// TODO: Implement the merge logic for Merge Sort.
		for (int i = left; i <= right; i++) {
			temp[i] = arr[i];
		}
		int i = left;
		int j = mid + 1;
		int k = left;

		while (i <= mid && j <= right) {
			if (temp[i] <= temp[j]) {
				arr[k++] = temp[i++];
			} else {
				arr[k++] = temp[j++];
			}
		}

		while (i <= mid) {
			arr[k++] = temp[i++];
		}

	}

	/**
	 * Implements the Merge Sort algorithm. Public-facing method. Theoretical
	 * Complexity: O(n log n)
	 */
	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return; // Already sorted
		}
		int[] temp = new int[arr.length];
		mergeSortRecursive(arr, temp, 0, arr.length - 1);
	}

	private static void mergeSortRecursive(int[] arr, int[] temp, int left, int right) {
		// TODO: Implement the recursive logic for Merge Sort.
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSortRecursive(arr, temp, left, mid);
			mergeSortRecursive(arr, temp, mid + 1, right);
			merge(arr, temp, left, mid, right);
		}

	}

	/**
	 * Implements the Selection Sort algorithm.
	 * Theoretical Complexity: O(n^2)
	 */
	public static void selectionSort(int[] arr) {
		// TODO: Implement the Selection Sort algorithm.

		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}

	}
}
