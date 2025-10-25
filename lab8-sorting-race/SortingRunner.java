import java.util.Arrays;
import java.util.Random;

public class SortingRunner {

	public static int[] generateRandomArray(int size) {
		// Implementation provided in previous response
		Random rand = new Random();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = rand.nextInt(size);
		}
		return arr;
	}

	public static int[] generateReverseSortedArray(int size) {
		// Implementation provided in previous response
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = size - i;
		}
		return arr;
	}

	public static int[] generateSortedArray(int size) {
		// Implementation provided in previous response
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = i;
		}
		return arr;
	}

	// TODO: Implement the runAndTimAllSorts helper method.

	public static void main(String[] args) {
		int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};

		System.out.println("--- The Sorting Race ---");

		for (int n : sizes) {
			System.out.println("\n--- Testing for array size n = " + n + " ---");

			// TODO: Call your test methods for Average, Best, and Worst cases.
			int[] averageCase = generateRandomArray(n);
			int[] bestCase = generateSortedArray(n);
			int[] worstCase = generateReverseSortedArray(n);

			System.out.println("Average Case:");
			runAndTimeAllSorts(averageCase);

			System.out.println("Best Case :");
			runAndTimeAllSorts(bestCase);

			System.out.println("Worst Case:");
			runAndTimeAllSorts(worstCase);
		}
	}

	//timing counter framework
	public static void runAndTimeAllSorts(int[] arr) {
		timeSort("Selection Sort", arr, SortingAlgorithms::selectionSort);
		timeSort("Insertion Sort", arr, SortingAlgorithms::insertionSort);
		timeSort("Merge Sort", arr, SortingAlgorithms::mergeSort);
		System.out.println();
	}

	//timing 1 algorithm
	private static void timeSort(String name, int[] arr, java.util.function.Consumer<int[]> sorter) {
		int[] copy = Arrays.copyOf(arr, arr.length);
		long start = System.nanoTime();
		sorter.accept(copy);
		long end = System.nanoTime();
		double millis = (end - start) / 1_000_000.0;
		System.out.printf("%-15s : %.3f ms%n", name, millis);
	}
}
