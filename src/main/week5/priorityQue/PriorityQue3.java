package main.week5.priorityQue;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PriorityQue3 {
    public static void main(String[] args) throws IOException{

        FastScanner input = new FastScanner(new File("input.txt"));
        PrintWriter output = new PrintWriter(new File("output.txt"));
        int n = input.nextInt();

        MinPriorityQue3 que = new MinPriorityQue3(n);

        for (int i = 0; i < n; i++) {
            String command = input.next();
            switch (command) {
                case "A":
                    int x = Integer.parseInt(input.next());
                    que.insert(x, i + 2);
                    break;
                case "X":
                    output.println(que.extractMin());
                    break;
                case "D":
                    int com = Integer.parseInt(input.next()) + 1;
                    int index = que.findIndex(com);
                    x = Integer.parseInt(input.next());
                    que.replace(index, x);
                    break;
                default:
                    break;
            }
        }

        output.close();
    }
}

class MinPriorityQue3{
    private Pair[] heap;
    private int heapSize = 0;

    public MinPriorityQue3(int n) {
        this.heap = new Pair[n];
    }

    public void insert(int x, int command) {
        heapSize = heapSize + 1;
        heap[heapSize - 1] = new Pair(x, command);
        siftUp(heapSize - 1);
    }

    public String extractMin() {
        if (heapSize == 0) {
            return "*";
        } else {
            int min = heap[0].getKey();
            heap[0] = heap[heapSize - 1];
            heap[heapSize - 1]= new Pair(0, 0);
            heapSize--;
            siftDown(0);
            return Integer.toString(min);
        }
    }

    public void replace(int index, int x){
        heap[index].setKey(x);
        siftUp(index);
    }

    public int findIndex(int command){
        int index = 0;
        for(int i = 0; i < heapSize; i++){
            if(heap[i].getCommand() == command){
                index = i;
                break;
            }
        }
        return index;
    }

    public void siftDown(int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;

        if (l < heapSize && heap[l].getKey() < heap[i].getKey())
            largest = l;

        if (r < heapSize && heap[r].getKey() < heap[largest].getKey())
            largest = r;

        if (largest != i) {
            swap(i, largest);
            siftDown(largest);
        }
    }

    public void siftUp(int i) {
        while (heap[i].getKey() < heap[(i - 1) / 2].getKey()) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public void swap(int i, int j) {
        Pair temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}


class Pair{
    private int key;
    private int command;

    public Pair(int key, int command) {
        this.key = key;
        this.command = command;
    }

    public int getKey() {
        return key;
    }

    public int getCommand() {
        return command;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setCommand(int command) {
        this.command = command;
    }
}


class FastScanner {
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
