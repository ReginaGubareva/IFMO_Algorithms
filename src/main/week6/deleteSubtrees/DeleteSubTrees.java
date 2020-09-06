package main.week6.deleteSubtrees;

import main.week6.binarySearch.FastScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Remove all element of binary tree with its subtree.
 */
public class DeleteSubTrees {
    public static final String input = "D:\\alghorithms\\IFMOcourse\\Algorithms\\src\\main\\week6\\deleteSubtrees\\input.txt";
    public static final String output = "D:\\alghorithms\\IFMOcourse\\Algorithms\\src\\main\\week6\\deleteSubtrees\\output.txt";

    public static void main(String[] args) throws FileNotFoundException {
        FastScanner in = new FastScanner(new File(input));
        PrintWriter out = new PrintWriter(new File(output));

        int n = in.nextInt();

        Tree bt = new Tree();
        for(int i = 0; i < n; i++){
            int x = in.nextInt();
            int left  = in.nextInt()-1;
            int right = in.nextInt()-1;
            bt.insert(x);
        }

        bt.print();
        int m = in.nextInt();
        for(int i = 0; i < m; i++){
            int element = in.nextInt();

        }
        out.close();
    }
}

class Tree{
    Node root;
    int size = 0;



    public void print() {
        System.out.println("Count of nodes: " +  size);
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, this.root);
        System.out.print(sb.toString());
    }

    public void traversePreOrder(StringBuilder sb, Node node) {
        if (node != null) {
            sb.append(node.getKey());
            sb.append("\n");
            traversePreOrder(sb, node.getLeft());
            traversePreOrder(sb, node.getRight());
        }
    }

    public void removeSubTree(Node node){
        if(node)

    }

    public void insert(int key) {
        Node current = root;
        Node newNode = new Node(key);
        Node parent = null;
        if(root == null){
            root = newNode;
            size++;
        } else {
            while (true){
                parent = current;
                if (key < current.getKey()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(newNode);
                        size++;
                        return;
                    }
                }
                else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(newNode);
                        size++;
                        return;
                    }
                }
            }
        }

    }

    @Override
    public String toString() {
        return "Tree{"+ root.key +
                '}';
    }
}

class Node {
    int key;
    Node left;
    Node right;
    Node parent;

    public Node(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}

/* вставка с информацией о родителе

 */



