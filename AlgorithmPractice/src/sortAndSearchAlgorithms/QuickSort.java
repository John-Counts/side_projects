package sortAndSearchAlgorithms;

import java.util.Random;

public class QuickSort {
	static int cycle = 0;

	public static void main(String[] args) {
		int[] numbers = IntArray.initialize();
		
		sort(numbers, 0, numbers.length - 1);
		
		System.out.println("these are the numbers after sorting:");
		IntArray.printArray(numbers);
		System.out.printf("cycles: %d%n", cycle);
	}
	
	private static void sort(int[] array, int low_index, int hi_index) {
		if (low_index >= hi_index) {
			return;
		}
		int pivot_index = new Random().nextInt(hi_index - low_index) + low_index;
		int pivot = array[pivot_index];
		swap(array, pivot_index, hi_index);
		int left_pointer = low_index;
		int right_pointer = hi_index;
		while (left_pointer < right_pointer) {
			while (array[left_pointer] <= pivot && left_pointer < right_pointer) {
				left_pointer++;
			}
			while (array[right_pointer] >= pivot && left_pointer < right_pointer) {
				right_pointer--;
			}
			swap(array, left_pointer, right_pointer);
		}
		swap(array, left_pointer, hi_index);
		cycle++;
		sort(array, low_index, left_pointer - 1);
		sort(array, left_pointer + 1, hi_index);
		
	}
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
