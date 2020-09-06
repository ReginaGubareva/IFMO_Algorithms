package main.week5.priorityQue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class PriorityQueue4 {
    static PrintWriter out;

    public PriorityQueue4() {
    }

    static int push(int[] queue, int x, int tail) {
        queue[tail] = x;
        ++tail;
        return tail;
    }

    static int extractMin(int[] queue, int[] lines, int head, int tail) {
        int min = tail - 1;

        for(int i = head; i < tail; ++i) {
            if (queue[i] < queue[min]) {
                min = i;
            }
        }

        swap(queue, head, min);
        swap(lines, head, min);
        if (tail - head > 0) {
            out.println(queue[head]);
            ++head;
        } else {
            out.println("*");
        }

        return head;
    }

    static void decreaseKey(int[] queue, int[] lines, int x, int y, int tail, int head) {
        for(int i = head; i < tail; ++i) {
            if (lines[i] == x) {
                queue[i] = y;
            }
        }

    }

    static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("input.txt"));
        out = new PrintWriter("output.txt");
        int[] queue = new int[(int)Math.pow(10.0D, 6.0D)];
        int[] numLines = new int[(int)Math.pow(10.0D, 6.0D)];
        int head = 0;
        int tail = 0;
        int i = 1;

        while(in.hasNext()) {
            String command = in.next();
            int x;
            if (command.compareTo("A") == 0) {
                x = in.nextInt();
                tail = push(queue, x, tail);
                push(numLines, i, tail - 1);
                ++i;
            }

            if (command.compareTo("X") == 0) {
                if(tail == head & tail == 0){
                    out.println("*");
                } else {
                    head = extractMin(queue, numLines, head, tail);
                    ++i;
                }
            }

            if (command.compareTo("D") == 0) {
                x = in.nextInt();
                int y = in.nextInt();
                decreaseKey(queue, numLines, x, y, tail, head);
                ++i;
            }
        }

        in.close();
        out.close();
    }
}
