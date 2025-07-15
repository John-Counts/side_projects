package sortAndSearchAlgorithms;

import java.util.Random;

public class MergeSort {

	static int cycle = 0;

	public static void main(String[] args) {
		int[] numberList = new int[500];
		populate(numberList, 1000);
		System.out.println("numbers pre sort:");
		printArray(numberList);
		
		mergeSort(numberList);
		
		System.out.println("numbers post sort:");
		printArray(numberList);
		System.out.println("cycles:");
		System.out.println(cycle);
	}
	
	private static void mergeSort(int[] inputArray) {
		int length = inputArray.length;
		if (length < 2) { return; }
		int midIndex = length / 2;
		int[] left = new int[midIndex];
		for (int i = 0; i < midIndex; i++) {
			left[i] = inputArray[i];
		}
		int[] right = new int[length - midIndex];
		for (int i = midIndex; i < length; i++) {
			right[i - midIndex] = inputArray[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(inputArray, left, right);
	}
	
	private static void merge(int[] mergeArray, int[] left, int[] right) {
		int leftSize = left.length;
		int rightSize = right.length;
		int li = 0;
		int ri = 0;
		int i = 0;
		while (li < leftSize && ri < rightSize) {
			if (left[li] <= right[ri]) {
				mergeArray[i] = left[li];
				li++;
			}
			else {
				mergeArray[i] = right[ri];
				ri++;
			}
			i++;
			cycle++;
		}
		while (li < leftSize) {
			mergeArray[i] = left[li];
			li++;
			i++;
			cycle++;
		}
		while (ri < rightSize) {
			mergeArray[i] = right[ri];
			ri++;
			i++;
			cycle++;
		}
	}
	
	
	private static void populate(int[] inputArray, int dx) {
		Random rand = new Random();
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = rand.nextInt(dx);
		}
	}
	
	private static void printArray(int[] numberList) {
		for (int i = 0; i < numberList.length; i++) {
			System.out.printf("%d ", numberList[i]);
		}
		System.out.println();
	}
}
