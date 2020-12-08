import java.util.Arrays;
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int swapIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[swapIndex]) {
                    swapIndex = j;
                }
            } 
            int temp = arr[i];
            arr[i] = arr[swapIndex];
            arr[swapIndex] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 6, 1, 7, 9, 13, 2, 47, 5};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}