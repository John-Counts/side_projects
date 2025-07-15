package sortAndSearchAlgorithms;


public class ShellSort {
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
		for (int gap = length / 2; gap > 0; gap/= 2) {
			for (int index = gap; index < length; index++) {
				boolean keep_going = true;
				for (int compare_to = index - gap; compare_to >= 0; compare_to-= gap) {
					int compare_from = compare_to + gap;
					if (keep_going == true ) {
						compare(numbers, compare_from, compare_to, keep_going);
					}
					else {
						break;
					}
				}
			}
		}
	}
	
	private static void compare(int[] numbers, int compare_hi, int compare_lo, boolean keep_going) {
		if (numbers[compare_hi] < numbers[compare_lo]) {
			swap(numbers, compare_hi, compare_lo);
			cycle++;
		}
		else {
			keep_going = false;
		}
		
	}

	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
