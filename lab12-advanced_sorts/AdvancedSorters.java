import java.util.Arrays;
import java.util.Comparator;

public class AdvancedSorters {

	private static <K> void merge(K[] S, K[] S1, K[] S2, Comparator<K> comp) {
		int i = 0, j = 0, k = 0;
		// TODO: Implement the merge logic
		while (i < S1.length && j < S2.length) {
			if (comp.compare(S1[i], S2[j]) <= 0) {
				S[k++] = S1[i++];
			} else {
				S[k++] = S2[j++];
			}
		}
		// TODO: Copy remaining elements of S1 or S2
		while (i < S1.length) {
			S[k++] = S1[i++];
		}
		while (j < S2.length) {
			S[k++] = S2[j++];
		}
	}

	// --- MergeSort ---
	public static <K> void mergeSort(K[] S, Comparator<K> comp) {
		int n = S.length;
		if (n < 2) {
			return;
		}


		int mid = n / 2;
		K[] S1 = Arrays.copyOfRange(S, 0, mid);
		K[] S2 = Arrays.copyOfRange(S, mid, n);


		mergeSort(S1, comp);
		mergeSort(S2, comp);


		merge(S, S1, S2, comp);
	}

	private static <K> int partition(K[] S, Comparator<K> comp, int a, int b) {

		// 1. Choose a pivot (e.g., S[a])
		K pivot = S[a];
		// 2. Set up 'left' and 'right' pointers
		int left = a + 1;
		int right = b;
		// 3. Loop and swap elements
		while (true) {
			while (left <= right && comp.compare(S[left], pivot) <= 0) {
				left++;
			}
			while (left <= right && comp.compare(S[right], pivot) > 0) {
				right--;
			}
			if (left > right) {
				break;
			}
			K temp = S[left];
			S[left] = S[right];
			S[right] = temp;
		}
		// 4. Return the final index of the pivot
		S[a] = S[right];
		S[right] = pivot;
		return right;
	}

	// --- QuickSort ---
	public static <K> void quickSort(K[] S, Comparator<K> comp) {
		quickSort(S, comp, 0, S.length - 1);
	}

	private static <K> void quickSort(K[] S, Comparator<K> comp, int a, int b) {
		if (a >= b) {
			return;
		}


		int pivotIndex = partition(S, comp, a, b);

		quickSort(S, comp, a, pivotIndex - 1);
		quickSort(S, comp, pivotIndex + 1, b);
	}
}
