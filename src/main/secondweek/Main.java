package main.secondweek;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        try(BufferedReader input = new BufferedReader(new FileReader("D:\\alghorithms\\IFMOcourse\\Algorithms\\templates\\input.txt"));
            BufferedWriter output = new BufferedWriter(new FileWriter("D:\\alghorithms\\IFMOcourse\\Algorithms\\templates\\output.txt"))){
            String string = input.readLine() + " " + input.readLine();
            Scanner sc = new Scanner(string);
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];

            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }

            PugaloSort pugalo = new PugaloSort();
            pugalo.pugaloSort(a, k);

            if(pugalo.isSorted(a)){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

//            String firstString = input.readLine();
//            String secondString = firstString + " " + input.readLine();
//            int n = 0;
//            int k1 = 0;
//            int k2 = 0;
//            int A = 0;
//            int B  = 0;
//            int C = 0;
//            int a1 = 0;
//            int a2 = 0;
//
//            Scanner sc = new Scanner(secondString);
//            while (sc.hasNextInt()){
//                 n = sc.nextInt();
//                 k1 = sc.nextInt()-1;
//                 k2 = sc.nextInt()-1;
//                 A = sc.nextInt();
//                 B = sc.nextInt();
//                 C = sc.nextInt();
//                 a1 = sc.nextInt();
//                 a2 = sc.nextInt();
//            }
//
//
//            int[] a = new int[n];
//            a[0] = a1;
//            a[1] = a2;
//
//            for (int i = 2; i < n; i++){
//                a[i] = A*a[i-2] + B*a[i-1] + C;
//            }

//            System.out.println(arrayAsString(a));
//            KthOrderStatistic k = new KthOrderStatistic();
//            k.kthElement(a, 0, n-1, k1, k2);
//            System.out.println(arrayAsString(a));

//            StringBuilder strBuilder = new StringBuilder();
//
//            for(int i = k1; i <= k2; i++){
//                System.out.print(a[i] + " ");
//                strBuilder.append(a[i]).append(" ");
//            }
//
//            output.write(strBuilder.toString());


            //AntiQuickSort antiQuickSort = new AntiQuickSort();
            //output.write(arrayAsString(antiQuickSort.generateKiller(n)));

            //MergeSortRecursive mergeSortRecursive = new MergeSortRecursive();
            //mergeSortRecursive.sort(array, 0, array.length-1, output);

            //MergeSortIterative mergeSortIterative = new MergeSortIterative();
            // mergeSortIterative.sort(array, output);

            //InversionCount inversionCount = new InversionCount();
            //int inversions = inversionCount.sort(array, 0, array.length-1);

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
