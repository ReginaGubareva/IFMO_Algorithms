package main.secondweek;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Iterative algo for BottomUpMergeSort or ascending merge sort.
 * @author Regina Gubareva
 * @since 15.12.2018
 */

public class MergeSortIterative {

    /**
     * Method divide array on a little arrays
     * which length is a power of 2.
     * @param array
     * @param output
     * @throws IOException
     */
    public  void sort(int[] array, BufferedWriter output) throws IOException {
        int[] workArray = new int[array.length];
        int chunkSize = 1;
        while (chunkSize < array.length) {
            int i = 0;
            while (i < array.length - chunkSize) {
                merge(array, i, chunkSize, workArray, output);
                i += chunkSize * 2;
            }
            chunkSize *= 2;
        }
    }

    /**
     * Do merge of chunks and write every merge into output file.
     * Inside file will: start and end index of merged array(first) and values of these elements.
     * @param array
     * @param leftPosition
     * @param chunkSize
     * @param workArray
     * @param output
     * @throws IOException
     */
    public  void merge(int[] array, int leftPosition, int chunkSize, int[] workArray, BufferedWriter output)
            throws IOException{
        int rightPosition = leftPosition + chunkSize;
        int endPosition = Math.min(leftPosition + chunkSize * 2 - 1, array.length - 1);
        int leftIndex = leftPosition;
        int rightIndex = rightPosition;

        for (int i = 0; i <= endPosition - leftPosition; i++) {
            if (leftIndex < rightPosition &&
                    (rightIndex > endPosition ||
                            array[leftIndex] <= array[rightIndex])) {
                workArray[i] = array[leftIndex++];
            } else {
                workArray[i] = array[rightIndex++];
            }
        }

        for (int i = leftPosition; i <= endPosition; i++) {
            array[i] = workArray[i - leftPosition];
        }
    }
}
