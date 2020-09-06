package main.week5.priorityQue;

import javax.swing.text.Element;
import java.io.*;
import java.util.*;

public class PriorityQueWork {
    public static int heapSize = 0;
    public static Map<Integer, El> indexes;
    public static El[] heap;

    public static void main(String[] args) throws IOException {
        FastScanner input = new FastScanner(new File("input.txt"));
        PrintWriter output = new PrintWriter(new File("output.txt"));

        int n = input.nextInt();
        indexes = new HashMap<>(n);
        heap = new El[n];

        int step = 1;
        for (int i = 0; i < n; i++){
            String command = input.next();
            step++;
            switch (command.charAt(0)) {
                case 'A':
                    int x = Integer.parseInt(input.next());
                    insert(x, step);
                    break;
                case 'X':
                    output.println(extractMin());
                    break;
                case 'D':
                    int com = Integer.parseInt(input.next()) + 1;
                    x = Integer.parseInt(input.next());
                    decreaseKey(x, com);
                    break;
                default:
                    break;
            }
        }
        output.close();
    }

    public static void insert(int value, int step) {
        heapSize++;
        heap[heapSize-1] = new El(heapSize-1, value);
        indexes.put(step, heap[heapSize-1]);
        siftUp(heapSize-1);
    }

    public static void siftUp(int i){
        while (heap[i].value < heap[( i - 1) / 2].value) {
            swap(i,  (i - 1) / 2 );
            i =  (i - 1) / 2;
        }
    }

    public static void decreaseKey(int value, int step){
        int i = indexes.get(step).currentIndex;
        heap[i].setValue(value);
        siftUp(i);
    }

    public static String extractMin() {
        if (heapSize == 0) {
            return "*";
        } else {
            int min = heap[0].value;
            heapSize--;
            swap(0, heapSize);
            siftDown(0);
            return Integer.toString(min);
        }
    }

    public static void siftDown(int i) {
        while( (2*i + 1 ) < heapSize ) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int j = left;

            if ( right < heapSize && heap[right].value < heap[left].value){
                j = right;
            }

            if ( heap[i].value <= heap[j].value ) {
                break;
            }
            swap(i, j);
            i = j;
        }
    }

    public static void swap(int i, int j){
        int indexTemp = heap[i].getCurrentIndex();
        heap[i].setCurrentIndex(j);
        heap[j].setCurrentIndex(indexTemp);
        El temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

class El {
    public int currentIndex;
    public int value;

    public El(int currentIndex, int value) {
        this.currentIndex = currentIndex;
        this.value = value;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

