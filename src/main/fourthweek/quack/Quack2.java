package main.fourthweek.quack;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class Quack2 {

    public static int comIndex = 0;
    public static ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
    public static HashMap<String, Integer> labels = new HashMap<>();
    public static HashMap<Character, Integer> registers = new HashMap<>();

    public static ArrayList<String> commands = new ArrayList<>();
    public static PrintWriter out;

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("/home/regina/IFMO_Algorithms/src/main/fourthweek/quack/input"));
        out =new PrintWriter(new FileWriter("/home/regina/IFMO_Algorithms/src/main/fourthweek/quack/output"));

        while (in.ready()){
            String command = in.readLine();
            if(command.charAt(0) == ':'){
                labels.put(command.substring(1), commands.size() - 1);
            }
            commands.add(command);
        }

        if(!commands.isEmpty()){
            while(comIndex != -1) {
                process(commands.get(comIndex));
            }
        }

        in.close();
        out.close();
    }

    private static void process(String comLine){
        char command = comLine.charAt(0);
        switch (command) {
            case '+':
                int x = queue.removeFirst();
                int y = queue.removeFirst();
                queue.addLast((x + y) % 65536);
                nextCommand();
                break;
            case '-':
                x = queue.removeFirst();
                y = queue.removeFirst();
                queue.addLast((x - y) % 65536);
                nextCommand();
                break;
            case '*':
                x = queue.removeFirst();
                y = queue.removeFirst();
                queue.addLast((x * y) % 65536);
                nextCommand();
                break;
            case '/':
                x = queue.removeFirst();
                y = queue.removeFirst();
                int res = x == 0 ? 0 : ((x / y) % 65536);
                queue.addLast(res);
                nextCommand();
                break;
            case '%':
                x = queue.removeFirst();
                y = queue.removeFirst();
                res = x == 0 ? 0 : (x % y);
                queue.addLast(res);
                nextCommand();
                break;
            case '>':
                registers.put(comLine.charAt(1), queue.removeFirst());
                nextCommand();
                break;
            case '<':
                queue.addLast(registers.get(comLine.charAt(1)));
                nextCommand();
                break;
            case 'P':
                if (comLine.length() > 1) {
                    out.println(registers.get(comLine.charAt(1)));
                } else {
                    out.println(queue.getFirst());
                }
                nextCommand();
                break;
            case 'C':
                if (comLine.length() > 1) {
                    out.print((char) (registers.get(comLine.charAt(1)) % 256));
                } else {
                    out.print((char) (queue.removeFirst() % 256));
                }
                nextCommand();
                break;
            case ':':
                String label = comLine.substring(1);
                if(!labels.containsKey(label)) {
                    labels.put(comLine.substring(1), comIndex);
                }
                nextCommand();
                break;
            case 'J':
                comIndex = labels.get(comLine.substring(1));
                nextCommand();
                break;
            case 'Z':
                label = comLine.substring(2);
                if (registers.get(comLine.charAt(1)) == 0) {
                    comIndex = labels.get(label);
                }
                nextCommand();
                break;
            case 'E':
                label = comLine.substring(3);
                if (registers.get(comLine.charAt(1)).equals(registers.get(comLine.charAt(2)))) {
                    comIndex = labels.get(label);
                }
                nextCommand();
                break;
            case 'G':
                label = comLine.substring(3);
                if (registers.get(comLine.charAt(1)) > registers.get(comLine.charAt(2))) {
                    comIndex = labels.get(label);
                }
                nextCommand();
                break;
            case 'Q':
                comIndex = -1;
                break;
            default:
                queue.addLast(Integer.parseInt(comLine));
                nextCommand();
                break;
        }
    }

    private static void nextCommand() {
        if(comIndex+1 == commands.size()){
            comIndex = -1;
        } else {
            comIndex++;
        }
    }

}