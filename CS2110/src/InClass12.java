
public class InClass12 {
	/**
	 * Get the index of the smallest value in the array after index k, including index k.
	 * If k is out of bounds for the array, return -1. If k is negative, also return -1.
	 */
	public static int getMinimumIndexAfter(int arr[], int k) {
		//if invalid k, return -1
		if (k < 0 || k >= arr.length) {
			return -1;
		}
		int minIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < arr[minIndex]) {
				minIndex = i;
			}
		}
		return minIndex;
	}
}
