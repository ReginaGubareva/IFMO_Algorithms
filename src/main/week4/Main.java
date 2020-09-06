package main.week4;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String OUTPUT_FILE_NAME = "output.txt.txt";

    /**
     * Que with min
     */

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        PrintWriter out = new PrintWriter(OUTPUT_FILE_NAME);
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        QueWithMin q = new QueWithMin();
        for (int i = 0; i < n; i++) {
            String command = in.readLine();
            switch (command) {

                case "?":
                    out.println(q.getMin());
                    break;
                case "-":
                    q.pop();
                    break;
                default:
                    int value = Integer.parseInt(command.substring(2));
                    q.push(value);
                    break;
            }
        }
        in.close();
        out.close();
    }

    /**
     * Bracket Sequence
     */

        /*try(BufferedReader input.txt = new BufferedReader(new FileReader("input.txt.txt"));
            BufferedWriter output.txt.txt = new BufferedWriter(new FileWriter("output.txt.txt.txt"))){

            int n = Integer.parseInt(input.txt.readLine());


            for(int i = 0; i < n; i++){
                String str = input.txt.readLine();
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
                    output.txt.txt.write("YES" + "\n");
                    System.out.println("YES");
                } else {
                    output.txt.txt.write("NO" + "\n");
                    System.out.println("NO");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/


    /**
     * Queue
     */
        /*FastScanner scan = new FastScanner(new File("input.txt.txt"));
        int n = scan.nextInt();

        try (PrintWriter out = new PrintWriter("output.txt.txt.txt")){
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
       /* FastScanner scan = new FastScanner(new File("/home/ren/IFMO_Algorithms/src/main/week4/stack/input.txt.txt"));
        int n = scan.nextInt();

        try (PrintWriter out = new PrintWriter("/home/ren/IFMO_Algorithms/src/main/week4/stack/output.txt.txt.txt")){
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



