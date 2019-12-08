package main.fourthweek;

import org.omg.CORBA.Object;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;

public class MyStack <T>{

    private LinkedList<T> stack;

    public MyStack(){
        this.stack = new LinkedList<T>();
    }

    public void push(T value) {
        stack.addLast(value);
    }

    public T pop() {
        return stack.removeLast();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public T peek(){
        return stack.getLast();
    }


    /*private int[] stack;
    private int top = -1;

    public MyStack(int n) {
        this.stack = new int[n];
    }

    public boolean isEmpty(){
        if (top == -1) return true;
        else return false;
    }

    public void push(int x){
            stack[++top] = x;
    }

    public int pop() {
        if(!this.isEmpty()){
            top--;
        }
        return stack[top + 1];
    }*/


}
