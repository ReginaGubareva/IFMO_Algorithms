package main.fourthweek;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args){

        /**
         * Queue with MIN
         */


        try (BufferedReader input = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter output = new BufferedWriter(new FileWriter("output.txt"))){
            int n = Integer.parseInt(input.readLine());


            PriorityQue queue = new PriorityQue(n);
            for (int i = 0; i < n; i++) {
                String c = input.readLine();
                //System.out.println(c);
                if(c.charAt(0) == '+')
                    queue.enqueue(Integer.parseInt(c.substring(2, c.length())));
                else if(c.charAt(0) == '-') {
                    queue.dequeue();
                } else if(c.charAt(0) == '?'){
                    System.out.println(queue.peekFirst());
                    output.write(queue.peekFirst() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }




        /**
         * Bracket Sequence
         */

        /*try(BufferedReader input = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter output = new BufferedWriter(new FileWriter("output.txt"))){

            int n = Integer.parseInt(input.readLine());


            for(int i = 0; i < n; i++){
                String str = input.readLine();
                Stack<Character> stack = new Stack<>();

                for(int j = 0; j < str.length(); j++) {
                    Character c = str.charAt(j);

                    if (c == '(' | c == '[') {
                        stack.push(c);
                    } else if (c == ')'){
                        if (!stack.isEmpty()) {
                            if(stack.peek() == '('){
                                stack.pop();
                            }  else {
                                stack.push(c);
                            }
                        } else {
                            stack.push(c);
                        }
                    } else  if ( c == ']'){
                        if (!stack.isEmpty()) {
                            if(stack.peek() == '['){
                                stack.pop();
                            } else {
                                stack.push(c);
                            }
                        } else {
                            stack.push(c);
                        }
                    }



                }
                if (stack.isEmpty()) {
                    output.write("YES" + "\n");
                    System.out.println("YES");
                } else {
                    output.write("NO" + "\n");
                    System.out.println("NO");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        /**
         * Queue
         */
        /*FastScanner scan = new FastScanner(new File("input.txt"));
        int n = scan.nextInt();

        try (PrintWriter out = new PrintWriter("output.txt")){
            MyQueue queue = new MyQueue(n);
            for (int i = n; i > 0; i--) {
                String c = scan.next();
                if(c.equals("+"))
                    queue.enQueue(scan.nextInt());
                else
                    out.println(queue.deQueue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/


        /**
         * Stack
         */
       /* FastScanner scan = new FastScanner(new File("/home/ren/IFMO_Algorithms/src/main/fourthweek/stack/input.txt"));
        int n = scan.nextInt();

        try (PrintWriter out = new PrintWriter("/home/ren/IFMO_Algorithms/src/main/fourthweek/stack/output.txt")){
            MyStack stack = new MyStack(n);
            for (int i = n; i > 0; i--) {
                String c = scan.next();
                if(c.equals("+"))
                    stack.push(scan.nextInt());
                else
                    out.println(stack.pop());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
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
