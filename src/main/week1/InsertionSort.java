package main.week1;

/**
 * Classical algorithm of Insertion sort;
 * @author Regina Gubareva
 * @since 09.09.2018
 */

public class InsertionSort{

	/**
	 * Do insertion sort.
	 * @param array An array of elements.
	 * @return int[] Sorted array;
	 */
	public static int[] insertionSort(int[] array){

		int key = 0, j = 0;

		for(int i = 1; i<array.length; i++){
			key = array[i];
			j = i-1;
			while(j>=0 && key<array[j]){
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = key;
		}
		return array;
	}
}
