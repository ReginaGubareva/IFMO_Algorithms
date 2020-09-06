package main.week4;

import java.util.*;

public class QueWithMin {

    private Deque<Pair> s1;
    private Deque<Pair> s2;

    public QueWithMin(){
        this.s1 = new ArrayDeque<>();
        this.s2 = new ArrayDeque<>();
    }

    public class Pair {
        Integer first;
        Integer second;

        public Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        public Integer getFirst() {
            return first;
        }

        public void setFirst(Integer first) {
            this.first = first;
        }

        public Integer getSecond() {
            return second;
        }

        public void setSecond(Integer second) {
            this.second = second;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }

    Integer getMin(){
        if (s1.isEmpty() || s2.isEmpty())
            return s1.isEmpty() ? s2.peek().second : s1.peek().second;
        else
            return Math.min(s1.peek().second, s2.peek().second);
    }

    void push (Integer new_element){
        int min = s1.isEmpty() ? new_element : Math.min(new_element, s1.peek().second);
        s1.push (new Pair(new_element, min));
    }

    void pop(){
        if (s2.isEmpty())
            while (!s1.isEmpty()) {
                int element = s1.peek().first;
                s1.pop();
                int min = s2.isEmpty() ? element : Math.min(element, s2.peek().second);
                s2.push (new Pair(element, min));
            }
        Integer result = s2.peek().first;
        s2.pop();


//        System.out.println("Left Stack");
//        leftStack.stream().forEach(x -> System.out.println(x));
//        System.out.println("Right Stack");
//        rightStack.stream().forEach(System.out::println);
    }

}

