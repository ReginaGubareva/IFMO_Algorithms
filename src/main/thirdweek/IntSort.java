package main.thirdweek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Given two arrays A and B, containing respectively n and m elements.
 * You need to sort numbers Ai*Aj, where 1<=i<=n, 1<=j<=m. Then form these
 * numbers we get sorted sequence C with size n*m. You need to write in output
 * a sum of every tenth element.
 *
 * input.txt format: first string - numbers n and m. 1<= n, m <= 6000;
 * second string - array A; third string - array B;
 *
 * output.txt format: one number - the sum of every tenth element.
 */
public class IntSort {

    public long[] getInput(BufferedReader input) throws IOException{
        String in = input.readLine() + " " + input.readLine() + " " + input.readLine();
        Scanner sc = new Scanner(in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[m];
        long[] C = new long[n*m];

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
        return C;
    }


    public void countingSort(int[] a, int r) {
        int k = 9;
        int n = a.length;
        int sorted[] = new int[n];
        int count[] = new int[k + 1];

        for (int i = 0; i < count.length; i++)
            count[i] = 0;

        for (int i = 0; i < n; i++)
            count[a[i]]++;

        for (int i = 1; i <= k; i++)
            count[i] += count[i-1];

        for (int i = n-1; i >= 0; i--) {
            sorted[count[a[i]]-1] = a[i];
            count[a[i]]--;
        }

        for (int i = 0; i < n; i++)
            a[i] = sorted[i];
    }


    public void writeSum(long[] sortedArray, BufferedWriter output) throws IOException {
        int sum = 0;
        for (int j = 0; j < sortedArray.length; j += 10) {
            sum += sortedArray[j];
        }

        System.out.println();
        System.out.println("Sum: " + sum);
        output.write(String.valueOf(sum));
    }
}


