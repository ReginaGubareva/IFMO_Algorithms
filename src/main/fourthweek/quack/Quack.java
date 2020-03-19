package main.fourthweek.quack;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Виртуальная машина, на которой исполняется программа на языке Quack,
 * имеет внутри себя очередь, содержащую целые числа по модулю 65536
 * (то есть, числа от 0 до 65535, соответствующие беззнаковому 16-битному целому типу).
 * Слово get в описании операций означает извлечение из очереди, put — добавление в очередь.
 * Кроме того, у виртуальной машины есть 26 регистров, которые обозначаются буквами от 'a' до 'z'.
 * Изначально все регистры хранят нулевое значение. В языке Quack существуют следующие команды ...
 *
 * Формат входного файла
 * Входной файл содержит синтаксически корректную программу на языке Quack. Известно, что программа завершает работу не более чем за
 * шагов. Программа содержит не менее одной и не более инструкций. Метки имеют длину от 1 до 10 и состоят из цифр и латинских букв.
 *
 * Формат выходного файла
 * Выведите содержимое стандартного потока вывода виртуальной машины в выходной файл.
 */
public class Quack {

    private static final String INPUT_FILE_NAME = "/home/regina/IFMO_Algorithms/src/main/fourthweek/quack/input";
    private static final String OUTPUT_FILE_NAME = "/home/regina/IFMO_Algorithms/src/main/fourthweek/quack/output";

    public static HashMap<Character, Integer> registers = new HashMap<>();

    public static LinkedList<Integer> virtualQueue = new LinkedList<>();

    public static HashMap<String, Integer> labels = new HashMap<>();

    public static ArrayList<String> commands = new ArrayList<>();
    public static int commandIndex = 0;
    public static PrintWriter out;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        out = new PrintWriter(OUTPUT_FILE_NAME);

        while (in.ready()) {
            String command = in.readLine();
            if (command.charAt(0) == ':') {
                addLabel(command.substring(1), commands.size());
            }
            commands.add(command);
        }

        if (!commands.isEmpty()) {
            while (commandIndex != -1) {
                processCommand(commands.get(commandIndex));
            }
        }
        in.close();
        out.close();
    }


    private static void processCommand(String commandLine){
        char command = commandLine.charAt(0);

        switch (command){
            case '+':
                add();
                nextCommand();
                break;
            case '-':
                subtract();
                nextCommand();
                break;
            case '*':
                multiply();
                nextCommand();
                break;
            case '/':
                devide();
                nextCommand();
                break;
            case '%':
                mod();
                nextCommand();
                break;
            case '>':
                putToRegister(commandLine.charAt(1));
                nextCommand();
                break;
            case '<':
                getFromRegister(commandLine.charAt(1));
                nextCommand();
                break;
            case 'P':
                if(commandLine.length() > 1){
                    printFromRegister(commandLine.charAt(1));
                } else {
                    printFromQueue();
                }
                nextCommand();
                break;
            case 'C':
                if(commandLine.length() > 1){
                    printASCIIFromRegister(commandLine.charAt(1));
                } else {
                    printASCIIFromQueue();
                }
                nextCommand();
                break;
            case ':':
                String label = commandLine.substring(1);
                if(!labels.containsKey(label)) {
                    addLabel(commandLine.substring(1), commandIndex);
                }
                nextCommand();
                break;
            case 'J':
                goToLabel(commandLine.substring(1));
                nextCommand();
                break;
            case 'Z':
                label = commandLine.substring(2);
//                if(!labels.containsKey(label)){
//                    labels.put(label, commands.indexOf(":" + label));
//                }
                goIfZero(commandLine.charAt(1), label);
                nextCommand();
                break;
            case 'E':
                label = commandLine.substring(3);
//                if(!labels.containsKey(label)){
//                    labels.put(label, commands.indexOf(":" + label));
//                }
                goIfEqual(commandLine.charAt(1), commandLine.charAt(2), label);
                nextCommand();
                break;
            case 'G':
                label = commandLine.substring(3);
//                if(!labels.containsKey(label)){
//                    labels.put(label, commands.indexOf(":" + label));
//                }
                goIfBigger(commandLine.charAt(1), commandLine.charAt(2), label);
                nextCommand();
                break;
            case 'Q':
                processQuit();
                break;
            default:
                virtualQueue.addLast(Integer.parseInt(commandLine));
                nextCommand();
                break;

        }

    }

    private static void nextCommand(){
        commandIndex = (commandIndex + 1) == commands.size() ? -1 : commandIndex + 1;
    }

    private static void processQuit() {
        commandIndex = -1;
    }

    private static void goIfBigger(char register1, char register2, String label) {
        if (registers.get(register1) > registers.get(register2)) {
            goToLabel(label);
        }
    }

    private static void goIfEqual(char register1, char register2, String label) {
        if (registers.get(register1).intValue() == registers.get(register2).intValue()) {
            goToLabel(label);
        }
    }

    private static void goIfZero(char register, String label) {
        if (registers.get(register) == 0){
            goToLabel(label);
        }
    }

    private static void addLabel(String label, int commandIndex) {
        labels.put(label, commandIndex);
    }

    private static void goToLabel(String label) {
        commandIndex = labels.get(label);
    }

    private static void printASCIIFromQueue() {
        out.print((char) (virtualQueue.removeFirst()%256));
    }


    private static void printASCIIFromRegister(char register) {
        out.print((char) (registers.get(register)%256));
    }

    private static void printFromRegister(char register) {
        out.println(registers.get(register));
    }

    private static void printFromQueue() {
        out.println(virtualQueue.removeFirst());
    }

    private static void getFromRegister(char register) {
        virtualQueue.addLast(registers.get(register));
    }

    private static void putToRegister(char register) {
        registers.put(register, virtualQueue.removeFirst());
    }

    private static void mod() {
        Integer x = virtualQueue.removeFirst();
        Integer y = virtualQueue.removeFirst();
        if(y == 0){
            virtualQueue.addLast(0);
        }
        virtualQueue.addLast((x % y));
    }

    private static void devide() {
        Integer x = virtualQueue.removeFirst();
        Integer y = virtualQueue.removeFirst();
        if(y == 0){
            virtualQueue.addLast(0);
        }
        virtualQueue.addLast((x / y));
    }

    private static void multiply() {
        Integer x = virtualQueue.removeFirst();
        Integer y = virtualQueue.removeFirst();
        virtualQueue.addLast((x*y) % 65536);
    }

    private static void subtract() {
        Integer x = virtualQueue.removeFirst();
        Integer y = virtualQueue.removeFirst();
        Integer res = (x - y) % 65536;
        if (res < 0) {
            res += 65536;
        }
        virtualQueue.addLast(res);
    }

    private static void add() {
        Integer x = virtualQueue.removeFirst();
        Integer y = virtualQueue.removeFirst();
        virtualQueue.addLast((x + y) % 65536);
    }
}
