package main.fourthweek;

import java.util.Stack;

public class PriorityQue {
    private int[] queue;
    private int head;
    private int tail;
    private int current_size;
    private Stack<Integer> stack;


    public PriorityQue(int n){

        this.head = 0;
        this.tail = 0;
        this.current_size = 0;
        this.queue = new int[n];

    }

    private boolean empty() {
       return (current_size == 0);
    }

    public int peekLast(){
        return queue[tail];
    }

    public int peekFirst(){
        return queue[head];
    }



    public void pushTail(int x){
        queue[tail] = x;
        if(tail == queue.length){
            tail = 1;
        } else {
            tail++;
            current_size++;
        }
    }

    public int popTail(){
        int x = queue[tail];
        queue[tail] = 0;
        if(tail != 0){
            tail--;
        }
        current_size--;
        return x;
    }

    public int popHead(){
        int x = queue[head];
        if(head == queue.length){
            head = 1;
        } else {
            head++;
        }
        current_size--;
        return x;
    }

    public void dequeue() {
//        if (!q.empty() && q.front() == removed_element)
//            q.pop_front();
    }

    public void enqueue(int parseInt) {

    }
}

