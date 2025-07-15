package sortAndSearchAlgorithms;

public class SelectionSort {
	static int cycle = 0;

	public static void main(String[] args) {
		int[] numbers = IntArray.initialize();
		sort(numbers);
		System.out.println("these are the numbers after sorting:");
		IntArray.printArray(numbers);
		System.out.printf("cycles: %d%n", cycle);
	}
	
	private static void sort(int[] numbers) {
		int length = numbers.length;
		for (int i = 0; i < length - 1; i++) {
			int min = numbers[i];
			int index_of_min = i;
			for (int j = i + 1; j < length; j++) {
				if (numbers[j] < min) {
					min = numbers[j];
					index_of_min = j;
					cycle++;
				}
			}
			swap(numbers, i, index_of_min);
		}
	}

	private static void swap(int[] numbers, int i, int index_of_min) {
		int temp = numbers[i];
		numbers[i] = numbers[index_of_min];
		numbers[index_of_min] = temp;
	}
	

}
