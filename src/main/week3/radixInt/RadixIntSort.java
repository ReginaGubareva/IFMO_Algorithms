package main.week3.radixInt;

import java.io.*;
import java.util.Scanner;

/**
 * Given two arrays A and B, containing respectively n and m elements.
 * You need to sort numbers Ai*Aj, where 1<=i<=n, 1<=j<=m. Then form these
 * numbers we get sorted sequence C with size n*m. You need to write in output.txt.txt
 * a sum of every tenth element.
 *
 * input.txt.txt format: first string - numbers n and m. 1<= n, m <= 6000;
 * second string - array A; third string - array B;
 *
 * output.txt.txt.txt format: one number - the sum of every tenth element.
 */
public class RadixIntSort {


    public static void main(String[] args){
        try(BufferedReader input = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter output = new BufferedWriter(new FileWriter("output.txt"))){
            String in = input.readLine() + " " + input.readLine() + " " + input.readLine();
            Scanner sc = new Scanner(in);

            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] A = new int[n];
            int[] B = new int[m];
            int[] C = new int[n*m];

            for (int i = 0; i < n; i++){
                A[i] = sc.nextInt();
            }

            for (int i = 0; i < m; i++){
                B[i] = sc.nextInt();
            }

            int i = 0;
            while ( i < n*m){
                for(int j = 0; j < m; j++){
                    for(int k = 0; k < n; k++){
                        C[i] = A[k] * B[j];
                        i++;
                    }
                }

            }

            radixInt(C);
            output.write(String.valueOf(sum(C)));

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void radixInt(int[] a){
        final int BITS_PER_BYTE = 8;
        final int R = 256 ;
        final int MASK = 255;
        final int d = 4;

        int[] sorted = new int[a.length];

        for (int i = 0; i < d; i++){
            int[] count = new int[R+1];

            for (int j = 0; j < a.length; j++) {
                int q = (a[j] >> BITS_PER_BYTE * i) & MASK;
                count[q]++;
            }

            for (int j = 1; j <= R; j++)
                count[j] += count[j - 1];

            if (i == d - 1) {
                int shift1 = count[R] - count[R / 2];
                int shift2 = count[R / 2];
                for (int r = 0; r < R / 2; r++) {
                    count[r] += shift1;
                }

                for (int r = R / 2; r < R; r++) {
                    count[r] -= shift2;
                }
            }

            for (int j = a.length - 1; j >= 0; j--) {
                int q = (a[j] >> BITS_PER_BYTE * i) & MASK;
                sorted[count[q] - 1] = a[j];
                count[q]--;
            }

            System.arraycopy(sorted, 0, a, 0, a.length);
        }
    }


    public static long sum(int[] sortedArray)  {
        long sum = 0;
        for (int j = 0; j < sortedArray.length; j += 10) {
            sum += sortedArray[j];
        }
        return sum;
    }

}


