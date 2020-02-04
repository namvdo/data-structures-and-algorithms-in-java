public class ReversedArray{
    /**
     * Reverses the contents of the subarray data[low] through data[high] inclusive.
     * @param data
     * @param low
     * @param high
     */
    public static void reverseArray(int[] data, int low, int high){
        if(low < high){ // if at least 2 elements in the subarray
            int temp = data[low]; // swaps data[low] and data[high]
            data[low] = data[high];
            data[high] = temp;
            reverseArray(data, low + 1, high - 1); // recurs on the rest
        }
    }
}