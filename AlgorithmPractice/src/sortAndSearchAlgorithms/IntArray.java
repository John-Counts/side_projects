package sortAndSearchAlgorithms;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class IntArray {
	public static int[] initialize() {
		int array_size;
		String message = "please input the array size:";
		String try_again = "you must input an integer.";
		array_size = askForInt(message, try_again);
		boolean random_initiation;
		message = "please indicate whether the array will be randomly generated (true/false):";
		try_again = "you must input a boolean value.";
		random_initiation = askForBool(message, try_again);
		int[] numbers = new int[array_size];
		if (random_initiation == true) {
			Random rand = new Random();
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = rand.nextInt(1000);
			}	
		}
		else {
			try_again = "you must input an integer.";
			for (int i = 0; i < numbers.length; i++) {
				message = "please enter the " + (i + 1) + "th number of " + numbers.length;
				numbers[i] = askForInt(message, try_again);
			}	
		}
		System.out.println("these are the numbers to be sorted:");
		printArray(numbers);
		return numbers;
	}
	private static boolean askForBool(String message, String try_again) {
		boolean response = true;
		Scanner input = new Scanner(System.in);
		while (true) {	
		System.out.println(message);
		try {
			response = input.nextBoolean();
			break;
		} 
		catch (InputMismatchException e){
			input.nextLine();
			System.out.println(try_again);
		}
		}
		return response;
	}
	private static int askForInt(String message, String try_again) {
		int response = 10;
		Scanner input = new Scanner(System.in);
		while (true) {	
		System.out.println(message);
		try {
			response = input.nextInt();
			break;
		} 
		catch (InputMismatchException e){
			input.nextLine();
			System.out.println(try_again);
		}
		}
		return response;
	}
	public static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("%d ", numbers[i]);
		}
		System.out.println();
	}
}
