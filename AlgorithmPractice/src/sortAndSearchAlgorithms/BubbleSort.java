package sortAndSearchAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BubbleSort {
	public static void main(String[] args) {
		Random rand = new Random();
		List<Integer> numberList = new ArrayList<>();
		for (int i = 0; i < 500; i++) {
			numberList.add(rand.nextInt(1000));
		}
		System.out.println("numbers to be sorted:");
		numberList.forEach(i -> System.out.printf("%d ", i));
		System.out.println();
		int cycle = 0;
		int temp;
		
		
		while (!isSorted(numberList)) {
		for (int i = 0; i < numberList.size() - 1; i++) {
			if(numberList.get(i) > numberList.get(i + 1)) {
				temp = numberList.get(i);
				numberList.set(i, numberList.get(i + 1));
				numberList.set(i +1, temp);
			}
			cycle++;
		}
		}
		
		System.out.println("numbers post sorting:");
		numberList.forEach(i -> System.out.printf("%d ", i));
		System.out.println();
		System.out.print("cycles: ");
		System.out.println(cycle);
	}
	
private static boolean isSorted(List<Integer> numberList) {
		
		if (numberList == null) {
			return true;
		}
		
		int length = numberList.size();
		if (length <= 1) {
			return true;
		}
		
		for (int i = 0; i < length - 1; i++) {
			if (numberList.get(i) > numberList.get(i + 1)) {
				return false;
			}
		}
		return true;
	}
}
