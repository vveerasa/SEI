package com.sei;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class DeDup {

	 public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4,
	 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
	 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15,
	 12, 18, 10, 14, 20, 17, 16, 3, 6,
	 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18,
	 4, 14, 13, 2, 11 };


	public static void main(String[] args) {
		 DeDup deDup = new DeDup();
		 int[] uniqueArr = deDup.removeDuplicates();
		 deDup.display(uniqueArr);

		 System.out.println();
		 Set<Integer> setArray = new LinkedHashSet<Integer>();
		 deDup = new DeDup();
		 deDup.display(deDup.removeDuplicates(setArray));
	
		 System.out.println();
		 deDup.display(deDup.bubbleSort());
	}

	/**
	 * @param Array
	 *            object with duplicate numbers is passed to the method
	 * @return returns a unique int array and ordered array, it the array object
	 *         passed to the method is null then the method returns null.
	 */
	public int[] removeDuplicates() {
		int result[] = new int[randomIntegers.length], j = 0;
		for (int i : randomIntegers) {
			if (!isExists(result, i))
				result[j++] = i;
		}
		return result;
	}


	/**
	 * @param Array
	 *            object with duplicate numbers is passed to the method
	 * @return returns a unique int array and ordered array, it the array object
	 *         passed to the method is null then the method returns null.
	 */
	public int[] removeDuplicates(Set<Integer> setArray) {

		if (randomIntegers != null) {
			// Set<Integer> setArray = new LinkedHashSet<Integer>();
			for (int i = 0; i < randomIntegers.length; i++) {
				setArray.add(randomIntegers[i]);
			}
			Object[] obj = setArray.toArray();
			Integer[] intArray = Arrays.copyOf(obj, obj.length, Integer[].class);
			int[] uniqueNumbersArr = new int[intArray.length];

			for (int i = 0; i < intArray.length; i++) {
				uniqueNumbersArr[i] = intArray[i].intValue();
			}
			return uniqueNumbersArr;
		}
		return null;

	}

	/**
	 * @param Array
	 *            object with duplicate numbers is passed to the method
	 * @return returns a unique int array and ordered array, it the array object
	 *         passed to the method is null then the method returns null.
	 */
	public int[] bubbleSort() {
		int out, in;
		for (out = randomIntegers.length - 1; out > 1; out--) // outer loop
																// (backward)
			for (in = 0; in < out; in++) {// inner loop (forward)
				if (randomIntegers[in] > randomIntegers[in + 1]) {
					swap(in, in + 1); // swap them
				}
			}

		return removeDuplicates(randomIntegers);
	} // end bubbleSort()


	public void display(int[] uniqueArr) // displays array contents
	{
		for (int j = 0; j < uniqueArr.length; j++) // for each element,
			System.out.print(uniqueArr[j] + " "); // display it
		System.out.println("");
	}
	
	private static boolean isExists(int[] array, int value) {
		for (int i : array) {
			if (i == value)
				return true;
		}
		return false;
	}
	
	private void swap(int one, int two) {
		int temp = randomIntegers[one];
		randomIntegers[one] = randomIntegers[two];
		randomIntegers[two] = temp;
	}

	private static int[] removeDuplicates(int[] duplicateSortedAr) {

		int i = 0, j = 1;
		if (duplicateSortedAr.length < 2) { // for only one element
			return duplicateSortedAr;
		}

		while (j < duplicateSortedAr.length) {
			if (duplicateSortedAr[j] == duplicateSortedAr[i])
				j++;
			else
				duplicateSortedAr[++i] = duplicateSortedAr[j++];
		}
		int[] nonDuplicateSortedAr = new int[i + 1];
		for (int x = 0; x < nonDuplicateSortedAr.length; x++) {
			nonDuplicateSortedAr[x] = duplicateSortedAr[x];
		}
		return nonDuplicateSortedAr;
	}


}
