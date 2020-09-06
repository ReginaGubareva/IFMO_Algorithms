package main.fourthweek.rpn;

import java.io.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class RPN {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader("input.txt");
            FileWriter writer = new FileWriter("output.txt")){

            Scanner scan = new Scanner(reader);
            int n = scan.nextInt();

            Stack<String> stackRPN = new Stack<>();
            for(int i = 0; i < n; i++){
                stackRPN.push(scan.next());
//                System.out.print(i + " ");
            }

//            System.out.println();
//            System.out.println(n);
//            stackRPN.forEach(x -> System.out.print( x + " "));
//            System.out.println();

            writer.write(String.valueOf(calculate(stackRPN)));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Integer calculate(Stack<String> stackRPN){
        Collections.reverse(stackRPN);
        Stack<Integer> stackCalc = new Stack<>();

        while (!stackRPN.isEmpty()) {
            String token = stackRPN.pop();

            if(isNumeric(token)){
                stackCalc.push(Integer.parseInt(token));
            } else if (isOperator(token)){
                if(!stackCalc.isEmpty()) {
                    Integer operand1 = stackCalc.pop();
                    Integer operand2 = stackCalc.pop();

                    switch (token) {
                        case "+":
                            stackCalc.push(operand1 + operand2);
                            break;
                        case "*":
                            stackCalc.push(operand1 * operand2);
                            break;
                        case "-":
                            stackCalc.push(operand2 - operand1);
                            break;
                    }
                }
            }
        }

        return stackCalc.pop();
    }

    public static boolean isNumeric(String s){
        return s.chars().allMatch(Character::isDigit);
    }

    public static boolean isOperator(String s){
        return s.equals("*") | s.equals("+") | s.equals("-");
    }
}
