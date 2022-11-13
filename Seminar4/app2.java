//Quicksort-v2-Hoare

package java_class.Seminar4;
import java.util.Arrays;

public class app2 {

    static int partition(int[] arr, int low, int high) {
        
        int pivot = arr[low];
        int i = low - 1, j = high + 1;

        while (true) {

            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) {
                return j;
            }
            
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    static void Quicksort(int[] arr, int low, int high) {
        if(low < high) {
            int part_index = partition(arr, low, high);
            Quicksort(arr, low, part_index);
            Quicksort(arr, part_index+1, high);
        }
    }
    static void PrintArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }
    static public void main(String[] args) {
        int[] arr = {20, 4, 32, 55, 2, 7, 15};
        System.out.println("Initial array: " + Arrays.toString(arr));
        int n = arr.length;
        Quicksort(arr, 0, n-1);
        System.out.println("Sorted array: ");
        PrintArray(arr, n);
    }
}
