import java.util.*;
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int arr[] = {2, 5, 1, 6, 7, 9, 4, 13, 47};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}