package main.week2;

/**
 * Input: array of integers;
 * Output: count of inversions in it;
 * Inversion is when i < j and Ai > Aj
 * @author Regina Gubareva
 * @since 24.06.2019
 */

public class InversionCount {

    public int sort(int[] arr, int L, int R){
        int inversions = 0;
        if(L < R) {
            int M = (L + R)/2;
            inversions += sort(arr, L, M);
            inversions += sort(arr, M+1, R);
            inversions += merge(arr, L, M, R);
        }
        return inversions;
    }

    /**
     * Merge arrays.
     * @param a - sorted array;
     * @param L - index of array start;
     * @param M - index of array middle;
     * @param R - index of array end;
     */
    public int merge(int[] a, int L, int M, int R){

        int inversions = 0;
        int[] buffer = new int[R - L + 1];

        int pos1 = L;
        int pos2 = M+1;
        int posBuffer = 0;

        while( pos1 <= M && pos2 <= R){
            if(a[pos1] <= a[pos2]){
                buffer[posBuffer++] = a[pos1++];
            } else {
                buffer[posBuffer++] = a[pos2++];
                inversions += M - pos1 + 1;
            }
        }

        while (pos1 <= M)
            buffer[posBuffer++] = a[pos1++];

        while (pos2 <= R)
            buffer[posBuffer++] = a[pos2++];

        System.arraycopy(buffer, 0, a, L, buffer.length);

        return inversions;
    }

    public static String arrayAsString(int[] array){
        StringBuilder str1 = new StringBuilder();
        for(int l = 0; l < array.length; l++) {
            str1.append(array[l]);
            str1.append(" ");
        }
        return str1.toString();
    }

}
