package sortAndSearchAlgorithms;

import java.util.Random;

public class InsertionSort {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] numberList = new int[500];
		for (int i = 0; i < numberList.length; i++) {
			numberList[i] = rand.nextInt(1000);
		}
		System.out.println("numbers to be sorted:");
		printArray(numberList);
		System.out.println();
		int cycle = 0;
		int temp;
		
		
		
		for (int i = 1; i < numberList.length; i++) {
			temp = numberList[i];
			for (int j = i - 1; j >= 0; j--) {
				if (numberList[j] > temp) {
					numberList[j + 1] = numberList[j];
					numberList[j] = temp;
				}
				cycle++;
			}
		}
		
		
		System.out.println("numbers post sorting:");
		printArray(numberList);
		System.out.println();
		System.out.print("cycles: ");
		System.out.println(cycle);
	}
	
	private static void printArray(int[] numberList) {
		for (int i = 0; i < numberList.length; i++) {
			System.out.printf("%d ", numberList[i]);
		}
		System.out.println();
	}

}
