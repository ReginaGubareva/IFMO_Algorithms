package main.week3.radixString;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Дано n строк, выведите их порядок после k фаз цифровой сортировки.
 *
 * Формат входного файла
 * В первой строке входного файла содержатся числа n — число строк, m — их длина и
 * k – число фаз цифровой сортировки (1≤n≤106, 1≤k≤m≤106, n⋅m≤5⋅107). Далее находится описание строк,
 * но в нетривиальном формате. Так, i-ая строка (1≤i≤n) записана в i-ых символах второй, …, (m+1)-ой
 * строк входного файла. Иными словами, строки написаны по вертикали. Это сделано специально,
 * чтобы сортировка занимала меньше времени. Строки состоят из строчных латинских букв: от символа "a"
 * до символа "z" включительно. В таблице символов ASCII все эти буквы располагаются подряд и в алфавитном порядке,
 * код буквы "a" равен 97, код буквы "z" равен 122.
 *
 * Формат выходного файла
 * Выведите номера строк в том порядке, в котором они будут после k фаз цифровой сортировки.
 *
 * Решение не проходит работает. Считывание строк происходит по байтно, не нужно искать символ в строке
 * методом charAt().
 */


public class RadixStringSort2 {

    public static void main(String[] args) throws IOException {
        String inPath = "input.txt";
        PrintWriter out = new PrintWriter(new File("output.txt"));
        FastScanner in = new FastScanner(inPath);

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        byte[][] a =new byte[m][];
        int[] index = new int[n];
        int[] count = new int[26];
        int[] resultIndex = new int[n];

        for(int i = 0; i < n; i++){
            index[i] = i+1;
        }

        in.readBytes(a, n, m);

        radixSort(a, index, count, resultIndex, n, m, k);

        for (int j = 0; j < resultIndex.length; j++) {
            out.write(index[j] + " ");
        }
        out.close();
    }

    private static void radixSort(byte[][] a, int[] index, int[] count, int[] resultIndex, int n, int m, int k){
        for (int j = m - 1; j >= 0 && k > 0; j--, k--) {
            Arrays.fill(count, 0);

            for (int i = 0; i < n; i++){
                count[a[j][i] - 97]++;
            }

            for(int i = 1; i < count.length; i++){
                count[i] += count[i-1];
            }

            for (int i = n - 1; i >= 0; i--) {
                int c = count[a[j][index[i] - 1] - 97]-1;
                resultIndex[c] = index[i];
                count[a[j][index[i] - 1] - 97]--;
            }

            System.arraycopy(resultIndex, 0, index, 0, resultIndex.length);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        String path;


        FastScanner(String path) {
            this.path = path;
            try {
                br = new BufferedReader(new FileReader(new File(path)));
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

        void readBytes(byte[][] a, int n, int m) throws IOException {
            Path fileLocation = Paths.get(path);
            byte[] data = Files.readAllBytes(fileLocation);
            int startPos = 0;
            while (data[startPos] != 13){
                startPos++;
            }
            startPos += 2;

            for (int i = 0; i < m; i++){
                byte[] temp = new byte[n];
                for(int j = 0; j < temp.length; j++){
                    temp[j] = data[startPos];
                    startPos++;
                }
                a[i] = temp;
                startPos = startPos + 2;
            }
        }
    }
}
