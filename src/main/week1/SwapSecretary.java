package main.week1;

import java.util.*;
import java.io.*;

/**
 * The Class does Insertion Sort. Write indexes of all transpositions
 * to the file; I was too lazy to create new function for it and return
 * array of string with corresponding indexes, therefore this class has
 * main() method;
 * @author Regina Gubareva
 * @since 09.09.2018
 */
class SwapSecretary{
	public static void main(String[] args){
		try(FileReader reader = new FileReader("D:\\alghorithms\\IFMOcourse\\Algorithms\\templates\\input.txt.txt");
			FileWriter writer = new FileWriter("D:\\alghorithms\\IFMOcourse\\Algorithms\\templates\\output.txt.txt.txt")){
			
			Scanner scan = new Scanner(reader);
			int n = scan.nextInt();
			int[] a = new int[n];
			int x = 0;
			while(scan.hasNextInt()){
				a[x] = scan.nextInt();
				x++;
			}
			
			int min = 0, k = 0;
			for(int i = 0; i < a.length; i++){
				min = a[i];
				for(int j = i; j < a.length; j++){
					if(a[j] <= min){
						min = a[j];
						k = j;
					}
				}
				if(a[i] != min){
                    int temp = a[i];
                    a[i] = min;
                    a[k] = temp;
                    writer.write("Swap elements at indices " + (i+1) + " and " + (k+1) + ".");
                    writer.write(System.getProperty("line.separator"));
				}
			}

		    writer.write("No more swaps needed.");
		    writer.write(System.getProperty("line.separator"));
		    for(int i = 0; i < a.length; i++){
			    writer.write(a[i] + " ");
		    }
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
