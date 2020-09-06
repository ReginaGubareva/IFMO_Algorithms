package main.week6.binarySearch;

import java.io.*;

/**
 * Дан массив из n элементов, упорядоченный в порядке неубывания, и m запросов:
 * найти первое и последнее вхождение некоторого числа в массив. Требуется
 * ответить на эти запросы.
 *
 * Формат входного файла
 * В первой строке входного файла содержится одно число n — размер массива (1≤n≤105).
 * Во второй строке находятся n чисел в порядке неубывания — элементы массива.
 * В третьей строке находится число m — число запросов (1≤m≤105).
 * В следующей строке находятся m чисел — запросы.
 * Элементы массива и запросы являются целыми числами, неотрицательны и не превышают 109.
 *
 * Формат выходного файла
 * Для каждого запроса выведите в отдельной строке номер (индекс) первого и последнего
 * вхождения этого числа в массив. Ecли числа в массиве нет, выведите два раза −1.
 */
public class BinarySearch {
    public static final String input = "input.txt";
    public static final String output = "output.txt";


    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(new File(input));
        PrintWriter out = new PrintWriter(new File(output));

        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] requests = new int[m];

        System.out.println();
        for (int i = 0; i < m; i++) {
            requests[i] = in.nextInt();
            out.println(findFirst(a, requests[i]) + " " + findLast(a, requests[i]));
        }
        out.close();
    }

    public static int findFirst(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low + 1) / 2;
            int midVal = a[mid];

            if (midVal < key) {

                // if mid is less than key, all elements
                // in range [low, mid] are also less
                // so we now search in [mid + 1, high]
                low = mid + 1;
            } else if (midVal > key) {

                // if mid is greater than key, all elements
                // in range [mid + 1, high] are also greater
                // so we now search in [low, mid - 1]
                high = mid - 1;
            } else if (midVal == key) {

                // if mid is equal to key, we note down
                //  the last found index then we search
                // for more in left side of mid
                // so we now search in [low, mid - 1]
                ans = mid;
                high = mid - 1;
            }
        }

        if (ans == -1) {
            return ans;
        } else {
            return ans + 1;
        }
    }

    public static int findLast(int[] a, int key) {
        int ans = -1;
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low + 1) / 2;
            int midVal = a[mid];

            if (midVal < key) {

                // if mid is less than key, then all elements
                // in range [low, mid - 1] are also less
                // so we now search in [mid + 1, high]
                low = mid + 1;
            } else if (midVal > key) {

                // if mid is greater than key, then all
                // elements in range [mid + 1, high] are
                // also greater so we now search in
                // [low, mid - 1]
                high = mid - 1;
            } else if (midVal == key) {

                // if mid is equal to key, we note down
                // the last found index then we search
                // for more in right side of mid
                // so we now search in [mid + 1, high]
                ans = mid;
                low = mid + 1;
            }
        }

        if (ans == -1) {
            return ans;
        } else {
            return ans + 1;
        }
    }

}