package main.thirdweek;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try(BufferedReader input = new BufferedReader(new FileReader("/home/ren/IFMO_Algorithms/templates/input.txt"));
            BufferedWriter output = new BufferedWriter(new FileWriter("/home/ren/IFMO_Algorithms/templates/output.txt"))){

            String str = input.readLine();
            Scanner sc = new Scanner(str);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            byte[][] a = new byte[m][];

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    a[i][j] = sc.nextByte();
                    System.out.print(a[i][j]);
                }
                System.out.println();
            }

        } catch(IOException e){
            e.getMessage();
        }
    }

    public static void radixSort(long[] a, int d){
        for (int i = d; i >= 0; i--){
            //countingSort(a, i);
        }

    }


    public static void printArray(long[] array) {
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
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
