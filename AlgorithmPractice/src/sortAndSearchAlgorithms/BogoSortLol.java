package sortAndSearchAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BogoSortLol {
	public static void main(String[] args) {
		Random rand = new Random();
		List<Integer> numberList = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			numberList.add(rand.nextInt(100));
		}
		System.out.println("numbers to be sorted:");
		numberList.forEach(i -> System.out.println(i));
		int cycle = 0;
		while (!isSorted(numberList)) {
			Collections.shuffle(numberList);
			cycle++;
			//System.out.println(cycle);
		}
		System.out.println("numbers post sorting:");
		numberList.forEach(i -> System.out.println(i));
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
