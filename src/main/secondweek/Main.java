package main.secondweek;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        try(BufferedReader input = new BufferedReader(new FileReader("D:\\alghorithms\\IFMOcourse\\Algorithms\\templates\\input.txt"));
            BufferedWriter output = new BufferedWriter(new FileWriter("D:\\alghorithms\\IFMOcourse\\Algorithms\\templates\\output.txt"))){
            int n = Integer.parseInt(input.readLine());

//            int[] array = new int[n];
//
//            Scanner sc = new Scanner(input.readLine());
//            int i = 0;
//            while(sc.hasNextInt()){
//                array[i] = sc.nextInt();
//                i++;
//            }

            AntiQuickSort antiQuickSort = new AntiQuickSort();

            output.write(arrayAsString(antiQuickSort.generateKiller(n)));


            int[] array = antiQuickSort.generateKiller(n);

            //MergeSortRecursive mergeSortRecursive = new MergeSortRecursive();
            //mergeSortRecursive.sort(array, 0, array.length-1, output);

            //MergeSortIterative mergeSortIterative = new MergeSortIterative();
            // mergeSortIterative.sort(array, output);

            //InversionCount inversionCount = new InversionCount();
            //int inversions = inversionCount.sort(array, 0, array.length-1);

            antiQuickSort.quickSort(array, 0, (array.length-1));
            output.write("\n");
            output.write("Count of comparing: " + antiQuickSort.getQ());

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
