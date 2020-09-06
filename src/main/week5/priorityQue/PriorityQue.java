package main.week5.priorityQue;


import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Реализуйте очередь с приоритетами. Ваша очередь должна поддерживать следующие операции: добавить элемент,
 * извлечь минимальный элемент, уменьшить элемент, добавленный во время одной из операций.
 *
 * Формат входного файла
 * В первой строке входного файла содержится число n(1≤n≤106) - число операций с очередью.
 * Следующие n строк содержат описание операций с очередью, по одному описанию в строке.
 * Операции могут быть следующими: A x — требуется добавить элемент x в очередь.
 * X — требуется удалить из очереди минимальный элемент и вывести его в выходной файл.
 * Если очередь пуста, в выходной файл требуется вывести звездочку «∗».
 * D x y — требуется заменить значение элемента, добавленного в очередь операцией A в строке входного файла номер
 * x+1, на y. Гарантируется, что в строке x+1 действительно находится операция A, что этот элемент не был
 * ранее удален операцией X, и что y меньше, чем предыдущее значение этого элемента. В очередь помещаются и извлекаются
 * только целые числа, не превышающие по модулю 10^9.
 *
 * Формат выходного файла
 * Выведите последовательно результат выполнения всех операций X, по одному в каждой строке выходного файла.
 * Если перед очередной операцией X очередь пуста, выведите вместо числа звездочку «∗».
 */
public class PriorityQue {

    private static int[] heap;
    private static ArrayList<Integer> indexes;
    private static int head = 0;
    private static int heapSize = 0;

    public static void main(String[] args) throws IOException{
        FastScanner input = new FastScanner(new File("input.txt"));
        PrintWriter output = new PrintWriter(new File("output.txt"));

        int n = input.nextInt();
        indexes = new ArrayList<>();
        heap = new int[n];

        int step = 1;
        for (int i = 0; i < n; i++){
            String command = input.next();
            step++;
            switch (command.charAt(0)) {
                case 'A':
                    int x = Integer.parseInt(input.next());
                    insert(x, step);
//                    System.out.println("INSERT: " + arrayAsString(heap));
//                    System.out.print("INDEXES: ");
//                    indexes.forEach(el -> System.out.print(el + " "));
//                    System.out.println();
                    break;
                case 'X':
                    output.println(extractMin());
//                    System.out.println("EXTRACT: " + arrayAsString(heap));
//                    System.out.print("INDEXES: ");
//                    indexes.forEach(el -> System.out.print(el + " "));
//                    System.out.println();
                    break;
                case 'D':
                    int com = Integer.parseInt(input.next()) + 1;
                    x = Integer.parseInt(input.next());;
                    changePriority(com, x);
//                    System.out.println("REPLACE: " + arrayAsString(heap));
//                    System.out.print("INDEXES: ");
//                    indexes.forEach(el -> System.out.print(el + " "));
//                    System.out.println();
                    break;
                default:
                    break;
            }
        }
        output.close();
    }

    public static void insert(int value, int step) {
        heapSize++;
//        heap[heapSize] = Integer.MAX_VALUE;
        heap[heapSize-1] = value;
        indexes.add(step);
//        if(indexes.isEmpty()){
//            indexes.add(step);
//            indexes.add(Integer.MAX_VALUE);
//        } else {
//            indexes.set(indexes.size() - 1, step);
//            indexes.add(Integer.MAX_VALUE);
//        }

        siftUp(heapSize-1);
    }


    public static void siftUp(int i){
        while (heap[i] < heap[(i-1)/2]){
            swap( i, (i-1)/2);
            Collections.swap(indexes, i, (i-1)/2);
            i = (i-1)/2;
        }
    }

    public static String extractMin() {
        if (heapSize == 0) {
            return "*";
        } else {
            int min = heap[0];
            heap[0] = heap[heapSize-1];
            heap[heapSize-1] = 0;
            heapSize--;
            Collections.swap(indexes, 0, indexes.size() - 1);
            indexes.remove(indexes.size()-1);
            siftDown(0);

            return Integer.toString(min);
        }
    }

    public static void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void siftDown(int i) {
        while( (2*i + 1 ) < heapSize ) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int j = left;

            if ( right < heapSize && heap[right] < heap[left]){
                j = right;
            }

            if ( heap[i] <= heap[j] ) {
                break;
            }
            swap(i, j);
            Collections.swap(indexes, i, j);
            i = j;
        }
    }

    public static void changePriority(int step, int x){
        int index = indexes.indexOf(step);
        if( x < heap[index]) {
            heap[index] = x;
            siftUp(index);
        } else {
            heap[index] = x;
            siftDown(index);
        }
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
