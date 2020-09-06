package main.week5.heapOrNot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class HeapOrNot {
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String OUTPUT_FILE_NAME = "output.txt.txt";


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        PrintWriter out = new PrintWriter(OUTPUT_FILE_NAME);
//        out.write(100);
//        out.write("\n");
//        for(int i = 0; i < 100; i++){
//           out.write(i + 1 + " ");
//        }
        int n = Integer.parseInt(in.readLine());
        int[] heap = new int[n];

        String[] data =  in.readLine().split(" ");

        for (int i = 0; i < data.length; i++){
            heap[i] = Integer.parseInt(data[i]);
        }

       // System.out.println(arrayAsString(heap));

        int count = 0;
        for(int i = 1; i < (n+1)/2; i++){
            int left = 2*i - 1;
            int right = 2*i;

            if( left > n | right > n) {
                break;
            }

            if (heap[left] < heap[i - 1] || heap[right] < heap[i - 1]) {
                count++;
            }

        }

        if(count > 0){
            out.print("NO");
        } else {
            out.print("YES");
        }


        in.close();
        out.close();

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
