package main.week2;

/**
 * Write the program which will generate those
 * sequence of numbers, for which Quick Sort makes
 * biggest count of comparisons.
 * There is in input.txt.txt file one number n(1<=n<=N) - size of sequence
 * In output.txt.txt.txt file - permutation numbers from 1 to n, for which Quick Sort
 * makes maximal count of comparisons.
 * @author Regina Gubareva
 * @since 03.07.2019
 */
public class AntiQuickSort {

    /**
     * number of comparing
     */
    private int q;

    /**
     * Quick Sort.
     * @param a - array.
     * @param l - starting element.
     * @param r - last element.
     */
    public void quickSort(int[] a, int l, int r){
        int i = l;
        int j = r;
        int key = a[(l+r)/2];

        while(i <= j){
            q++;
            while(a[i] < key){ i++; q++;}
            while(key < a[j]){ j--; }

            if(i <= j){
                q++;
                int buf = a[i];
                a[i] = a[j];
                a[j] = buf;

                i++;
                j--;
            }
        }

        if( l < j) {
            q++;
            quickSort(a, l, j);
        }

        if(i < r){
            q++;
            quickSort(a, i, r);
        }
    }


    /**
     * Generates killer sequence for quickSort function.
     * @param n - size of array.
     * @return - killer sequence as int[] array.
     */
    public int[] generateKiller(int n) {
        int[] a = new int[n];

        //Fill first two elements
        if( n == 1) {a[0] = 1;}
        if( n > 1) {
            a[0] = 1;
            a[1] = 2;
        }

        //The cycle will start from 3, as elements a[0] couldn't be
        //a key element; And we find key element as (i-1)/2, becsuse of
        //another way we'll get not optimal sequence.
        for(int i = 3; i <= n; i++){
            int key = (i-1)/2;

            //key elements write to buffer, on these place write i
            //than on the previous element write previous key element.
            int buf = a[key];
            a[key] = i;
            a[i-1] = buf;

        }

        return a;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }
}
