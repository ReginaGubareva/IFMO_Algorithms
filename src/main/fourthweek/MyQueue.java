package main.fourthweek;

public class MyQueue {

    private int[] queue;
    private int head;
    private int tail;

    public MyQueue(int n){
        this.queue = new int[n];
    }

    public void enQueue(int x){
        queue[tail] = x;
        if(tail == queue.length){
            tail = 1;
        } else {
            tail++;
        }
    }

    public int deQueue(){
        int x = queue[head];
        if(head == queue.length){
            head = 1;
        } else {
            head++;
        }
        return x;
    }
}
