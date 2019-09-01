package main.thirdweek;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        try(BufferedReader input = new BufferedReader(new FileReader("D:\\alghorithms\\IFMOcourse\\Algorithms\\templates\\input.txt"));
            BufferedWriter output = new BufferedWriter(new FileWriter("D:\\alghorithms\\IFMOcourse\\Algorithms\\templates\\output.txt"))){

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

//                        System.out.print("[" + i + "] = [" + j + "] * [" + k + "]" );
//                        System.out.println();
                        i++;
                    }
                }


            }

            System.out.println();
            printArray(C);

        } catch(IOException e){
            e.getMessage();
        }
    }


    public static void printArray(int[] array) {
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
