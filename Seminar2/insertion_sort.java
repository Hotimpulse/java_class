// Insertion sort https://en.wikipedia.org/wiki/Insertion_sort

package java_class.Seminar2;

import java.util.Arrays;

public class insertion_sort {
    void sort(int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i-1;

            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = key;
        }
    }

    static void printArr(int arr[]){
        System.out.print("Your sorted array is: ");
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = {1, 12, 3, 9, 4, 6};
        System.out.println("Your initial array is: " + Arrays.toString(arr));
        insertion_sort isort = new insertion_sort();
        isort.sort(arr);
        printArr(arr);
    }
}