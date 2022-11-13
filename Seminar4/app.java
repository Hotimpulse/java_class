//Quicksort-v1-Lomuto

package java_class.Seminar4;
import java.util.Arrays;


public class app {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return (i+1);
    }
    static void quickSort(int[] arr, int low, int high){
        if (low < high) {
            int part_index = partition(arr, low, high);
            quickSort(arr, low, part_index - 1);
            quickSort(arr, part_index + 1, high);
        }
    }
    static void printArray(int[] arr, int size){
        for (int i = 0; i < size; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args){
        int arr[] = {10, 20, 5, 90, 2, 77};
        System.out.println("Original array: " + Arrays.toString(arr));
        int n = arr.length;

        quickSort(arr, 0, n-1);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}
