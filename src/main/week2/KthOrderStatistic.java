package main.week2;

/**
 * Given an array of n elements. Which numbers are k1, (k1+1), ..., k2 in non decrease order.
 * You have to get elements of array, starting from 3rd, using a formula:
 * ai = A*a(i-2) + B*a(i-1) + C. All computations produces in 32bit signed type.
 * Overflows are ignored.
 *
 * Input file:
 * the first string contains free numbers: n - size of array;
 * k1 and k2 - borders of interval; 2 <= n <=4*10^7, 1 <= k1 <= k2 <= n, k2-k1 < 200;
 * the second string contains numbers A, B, B, a1,a2, less than 10^9 in absolute value.
 * Output file:
 * the first and one string contains: k1, (k1+1), ..., k2 in non decrease order.
 */
public class KthOrderStatistic {

    public void kthElement(int[] a, int left, int right, int k1, int k2){

        if (k2 < left || right < k1) return;

        int i = left, j = right;
        int pivot = a[(left + right) / 2];

        while (i <= j) {
            while (a[i] < pivot) {
                i++;
            }

            while (a[j] > pivot) {
                j--;
            }

            if (i > j) continue;

            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;

            i++;
            j--;
        }

        if (left < j) {
            kthElement(a, left, j, k1, k2);
        }

        if (i < right) {
            kthElement(a, i, right, k1, k2);
        }

    }

    public void swap(int arr[], int index1, int index2){
        int buf = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = buf;
    }
}
