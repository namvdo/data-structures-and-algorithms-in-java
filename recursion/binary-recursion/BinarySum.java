public class BinarySum {
    /**
     * Returns the sum of subarray from data[low] through data[high] inclusive.
     * @param data
     * @param low
     * @param high
     * @return the sum of subarray from data[low] through data[high] inclusive.
     */
    public static int binarySum(int[] data, int low, int high){
        if(low > high) return 0; // zero element in the subarray.
        else if(low == high) return data[low]; // one element in the subarray.
        else{
            int mid = (low + high) / 2;
            return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
        }
    }
}