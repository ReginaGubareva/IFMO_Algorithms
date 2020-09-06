package main.week1;

import java.util.*;
import java.io.*;

/**
 * Write to file an identification number of the max, min and aver elements;
 * @author Regina Gubareva
 * @since 09.09.2018
 */

class SortLand{
	public static void main(String[] args){
		Scanner in = null;
		try{
			in = new Scanner(new File("input.txt.txt"));
			in.useLocale(new Locale("en"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int n = in.nextInt();
		int j = 0;
		double key = 0.0;
		double[] a = new double[n];
		
		for(int i = 0; i < n; i++){
			a[i] = in.nextDouble();
		}
		
		double[] aSort = Arrays.copyOf(a, n);
		
		for(int i = 1; i<aSort.length; i++){
			key = aSort[i];
			j = i-1;
			while(j>=0 && key<aSort[j]){
				aSort[j+1] = aSort[j];
				j--;
			}
			aSort[j+1] = key;
		}
		
		try(FileWriter writer = new FileWriter("output.txt.txt.txt")){
			for(int i = 0; i < n; i++){
				if(aSort[0] == a[i]){
					writer.write(i+1 + " ");
				}
			}
			for(int i = 0; i < n; i++){
				if(aSort[(n/2)] == a[i]){
					writer.write( i+1 + " ");
				}	
			}
			for(int i = 0; i < n; i++){
				if( aSort[n-1] == a[i]){
					writer.write( i+1 + " ");
				}
			}
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
