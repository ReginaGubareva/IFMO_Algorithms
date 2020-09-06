package main.week6.treeHeight;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Дано двоичное дерево поиска. В вершинах этого дерева записаны ключи — целые числа, по модулю не превышающие.
 * Для каждой вершины дерева  выполняется следующее условие:
 *
 * все ключи вершин из левого поддерева меньше ключа вершины ;
 * все ключи вершин из правого поддерева больше ключа вершины.
 * Найдите высоту данного дерева.
 *
 * Формат входного файла
 * Входной файл содержит описание двоичного дерева. В первой строке файла находится число N (0 <= N <= 2*10^5)
 * — число вершин в дереве. В последующих  строках файла находятся описания вершин дерева.
 * В (i+1)-ой строке файла (1 <= i <= N) находится описание i-ой вершины, состоящее из трех чисел Ki, Li, Ri,
 * разделенных пробелами — ключа в i-ой вершине (|Ki| <= 10^9), номера левого ребенка i-ой вершины
 * ( i < Li <= N или i = 0, если левого ребенка нет) и номера правого ребенка i-ой вершины ( i < Ri <= N или i = 0,
 * если правого ребенка нет).
 *
 * Все ключи различны. Гарантируется, что данное дерево является деревом поиска.
 *
 * Формат выходного файла
 * Выведите одно целое число — высоту дерева.
 */
public class TreeHeight {
    public static final String input = "input.txt";
    public static final String output = "output.txt";

    private static int treeH = 0;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File(input));
        PrintWriter out = new PrintWriter(new File(output));

        int n = in.nextInt();
        if(n == 0) {
            out.print(0);
        } else {
            Node[] tree = new Node[n + 1];
            for (int i = 0; i < n; i++) {
                int key = in.nextInt();
                int left = in.nextInt();
                int right = in.nextInt();
                tree[i + 1] = new Node(left, right, key);
            }

            out.print(walkTree(tree, 1, 1));
        }
        out.close();
    }

    public static int walkTree(Node[] tree, int h, int nodeIndex){
        Node current = tree[nodeIndex];
        treeH = Math.max(h, treeH);

        if(current.left != 0) {
            walkTree(tree, h+1, current.left);
        }

        if(current.right != 0) {
            walkTree(tree, h+1, current.right);
        }
        return treeH;
    }
}

class Node {
    int left;
    int right;
    int key;

    public Node(int left, int right, int key) {
        this.left = left;
        this.right = right;
        this.key = key;
    }
}

