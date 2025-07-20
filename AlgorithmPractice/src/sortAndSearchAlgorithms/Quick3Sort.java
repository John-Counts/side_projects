package sortAndSearchAlgorithms;

import java.util.Random;

public class Quick3Sort {
	private static int cycle = 0;

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
		int left_pointer = low_index;
		int middle_pointer = low_index;
		int right_pointer = hi_index;
		int pivot_index = new Random().nextInt(hi_index - low_index) + low_index;
		int pivot = array[pivot_index];
		if (hi_index - low_index <= 1) {
			if (array[left_pointer] > array[right_pointer]) {
				swap(array, left_pointer, right_pointer);
			}
			return;
		}
		swap(array, pivot_index, hi_index);
		while (middle_pointer != right_pointer) {
			if (array[middle_pointer] < pivot) {
				swap(array, left_pointer++, middle_pointer++);
			}
			else if (array[middle_pointer] == pivot) {
				middle_pointer++;
			}
			else if (array[middle_pointer] > pivot) {
				while (array[right_pointer] > pivot && right_pointer > middle_pointer) {
					right_pointer--;
				}
				swap(array, right_pointer, middle_pointer);
			}
			
		}
		cycle++;
		if (left_pointer > low_index) {
			sort(array, low_index, left_pointer);
		}
		if (middle_pointer < hi_index) {
			sort(array, middle_pointer, hi_index);
		}
	}
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
