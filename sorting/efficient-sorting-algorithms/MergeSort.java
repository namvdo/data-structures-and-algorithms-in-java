import java.util.Arrays;
public class MergeSort {
    public static void mergerSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            mergerSort(arr, left, mid);
            mergerSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void merge(int[] arr, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        int []leftArr = new int[leftSize];
        int []rightArr = new int[rightSize];
        if (leftSize >= 0) {
            System.arraycopy(arr, left, leftArr, 0, leftSize);
        }
        for(int i = 0; i < rightSize; i++) {
            rightArr[i] = arr[mid + i + 1];
        }
        int leftIdx = 0;
        int rightIdx = 0;
        int k = left;
        while (leftIdx < leftSize && rightIdx < rightSize) {
            if (leftArr[leftIdx] < rightArr[rightIdx]) {
                arr[k] = leftArr[leftIdx];
                leftIdx++;
            } else {
                arr[k] = rightArr[rightIdx];
                rightIdx++;
            }
            k++;
        }
        while (leftIdx != leftSize) {
            arr[k] = leftArr[leftIdx];
            k++;
            leftIdx++; 
        }
        while (rightIdx  != rightSize) {
            arr[k] = rightArr[rightIdx];
            k++;
            rightIdx++; 
        }
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 7, 8, 4, 6, 9, -3, 0};
        mergerSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}