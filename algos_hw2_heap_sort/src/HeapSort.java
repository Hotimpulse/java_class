import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {

        int[] array = {4, 2, 1, 9, 5};
        System.out.println("Before the heap sort: " + Arrays.toString(array));
        HeapSort.sort(array);
        System.out.println("After the heap sort: " + Arrays.toString(array));
    }

    public static void sort(int[] array) {
        int n = array.length;

        //building a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        //extracting els from heap, one at a time
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);  //heapify the reduced heap
        }
    }

    static void heapify(int[] array, int n, int i) {
        int largest = i; // largest -> root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        //if left child is larger than root
        if(left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            //recursively heapifying the subtree

            heapify(array, n, largest);
        }
    }
}
