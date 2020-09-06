package main.week2;

/**
 *
 */
public class PugaloSort {

    public boolean isSorted(int[] a){
        for(int i = 1; i < a.length; i++){
            if(a[i] < a[i-1]){
                return false;
            }
        }
        return true;
    }

    public void pugaloSort(int[] a, int k){
        for(int i = 0; i < k; i++){

            if((i+k) >= a.length){ break; }

            int end = ((a.length+1)/k)*k - i;

            if(end >= a.length){
                end -= k;
            }
            System.out.println(end);
            quickSort(a, 0, end, k);
        }
    }

    public void quickSort(int[] a, int l, int r, int k){

        int i = l, j = r;
        int pivot = a[(l+r)/2];

        while (i <= j) {
            while (a[i] < pivot) { i+=k; }
            while (a[j] > pivot) { j-=k; }

            if(i <= j){
                swap(a, i, j);
                i+=k;
                j-=k;
            }
        }

        if (l < j) {
            quickSort(a, l, j, k);
        }

        if (i < r) {
            quickSort(a, i, r, k);
        }
    }

    public void swap(int arr[], int index1, int index2){
        int buf = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = buf;
    }
}
