package main.secondweek;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Recursive algorithm for Merge Sort.
 * @author Regina Gubareva
 * @since 10.11.2018
 */

public class MergeSortRecursive {


    /**
     * Sort array arr[].
     * @param arr - sorted array;
     * @param L - index of array start;
     * @param R - index of array end
     * @param output - write result array in output file
     * @throws IOException - catches in Main class
     */

    public void sort(int[] arr, int L, int R, BufferedWriter output) throws IOException{
        if(L < R) {
            int M = (L + R)/2;
            sort(arr, L, M, output);
            sort(arr, M+1, R, output);
            merge(arr, L, M, R, output);
        }
    }

    /**
     * Merge arrays.
     * @param a - sorted array;
     * @param L - index of array start;
     * @param M - index of array middle;
     * @param R - index of array end;
     * @param output - write result array in output file;
     * @throws IOException - catches in Main class;
     */
    public void merge(int[] a, int L, int M, int R, BufferedWriter output) throws IOException {

        int[] half1 = new int[M-L+1];
        int[] half2 = new int[R-M];

        int k = 0;
        for (int i = L; i <= M; i++){
            half1[k++] = a[i];
        }

        int m = 0;
        for(int j = M+1; j <= R; j++){
            half2[m++] = a[j];
        }

        int i = 0; // Initial index of first subarray
        int j = 0; // Initial index of second subarray
        k = L; // Initial index of merged subarray
        while (i < half1.length && j < half2.length)
        {
            if (half1[i] <= half2[j]) {
                a[k] = half1[i];
                i++;
            } else {
                a[k] = half2[j];
                j++;
            }
            k++;
        }

    /* Copy the remaining elements of L[], if there
       are any */
        while (i < half1.length) {
            a[k] = half1[i];
            i++;
            k++;
        }

    /* Copy the remaining elements of R[], if there
       are any */
        while (j < half2.length) {
            a[k] = half2[j];
            j++;
            k++;
        }

        //write to file indexes of inver elements and values of these elements
        //output.write((L + 1) + " " + (R + 1) + " " + a[L] + " " + a[R]);
        //output.write("\n");
    }

    public static String arrayAsString(int[] array){
        StringBuilder str1 = new StringBuilder();
        for(int l = 0; l < array.length; l++) {
            str1.append(array[l]);
            str1.append(" ");
        }
        return str1.toString();
    }

}



























