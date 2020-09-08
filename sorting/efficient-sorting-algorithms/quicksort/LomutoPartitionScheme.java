import java.util.Random;
import java.util.Arrays;

/*
    Quicksort using Lomuto Partition Scheme, for more reading: @link https://learntocodetogether.com/quicksort/
*/

public class LomutoPartitionScheme {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high); // get the correct position of the pivot
            quickSort(arr, low, partition - 1); // call quickSort on the sub-left array
            quickSort(arr, partition + 1, high); // call quickSort on the sub-right array
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pick the last element as the pivot
        int i = low; // initially set i to low
        for(int j = low; j < high; j++) { // loop through all array elements
            if (arr[j] < pivot) {
                swap(arr, i, j); // move elements less than pivot to the correct order by swapping arr[i] with arr[j]
                i++; // increase i to the next array position
            }
        }
        swap(arr, i, high); // swap the pivot to the correct position
        return i; // return the index of the pivot
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int []arr = new int[10];
        for(int i = 0; i < 10; i++) {
            arr[i] = new Random().nextInt(100);
        }
        System.out.println("Before sorting: ");
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After sorting: ");
        System.out.println(Arrays.toString(arr));
    }
}