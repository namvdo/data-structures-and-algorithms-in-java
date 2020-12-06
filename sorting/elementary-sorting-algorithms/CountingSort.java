import java.util.Arrays;
class CountingSort {
    public static int[] countingSort(int[] elements, int maxElem) {
        int []counts = new int[maxElem + 1];
        int []output = new int[elements.length];
        for(int elem: elements) {
            counts[elem]++;
        }
        for(int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        for(int i = elements.length - 1; i >= 0; i--) {
            output[counts[elements[i]] - 1] = elements[i];
            --counts[elements[i]];
        }
        return output;
    } 
    public static void main(String...args) {
        int[] arr = {2, 3, 1, 1, 6, 4, 5, 7, 10, 13, 4, 7, 7};
        System.out.print(Arrays.toString(countingSort(arr, 13)));
    }
}