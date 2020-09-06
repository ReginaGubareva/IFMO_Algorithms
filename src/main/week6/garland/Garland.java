package main.week6.garland;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Гирлянда состоит из  лампочек на общем проводе. Один её конец закреплён на заданной высоте h1 мм.
 * Благодаря силе тяжести гирлянда прогибается: высота каждой неконцевой лампы на 1 мм меньше,
 * чем средняя высота ближайших соседей ( hi = (h[i-1] + h[i+1])/2 для 1 < i < N ).
 *
 * Требуется найти минимальное значение высоты второго конца h2, такое что для любого  при высоте второго
 * конца  для всех лампочек выполняется условие . Обратите внимание на то, что при данном значении высоты
 * либо ровно одна, либо две соседних лампочки будут иметь нулевую высоту.
 *
 * Подсказка: для решения этой задачи можно использовать двоичный поиск (метод дихотомии).
 */

public class Garland {
    public static final String input = "input.txt";
    public static final String output = "output.txt";
    public static final double eps = 0.0000000001;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File(input));
        PrintWriter out = new PrintWriter(new File(output));

        int n = in.nextInt();
        double[] h = new double[n];
        h[0] = in.nextDouble();
        out.println(String.format("%9f", getB(n, h)));
        out.close();
    }

    public static double getB(int n, double[] h) {

        double l = 0, r = h[0];
        while ( r - l > eps) {
            h[1] = (l + r) / 2;
            boolean flag = true;
            for( int i = 2; i < n; i++){
                h[i] =  2 * h[i-1] - h[i - 2] + 2;

                if( h[i] < 0) {
                    flag = false;
                    break;
                }
            }

            if(flag){
                r = h[1];
            } else {
                l = h[1];
            }
        }
        return h[n-1];
    }
}

