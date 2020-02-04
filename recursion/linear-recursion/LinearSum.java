public class LinearSum {
    /**
     * Returns the sum of the first n integers of the given array.
     * @param data
     * @param n
     * @return sum of the first n integers
     */
    public static int linearSum(int[] data, int n){
        if(n == 0){
            return 0;
        }else{
            return linearSum(data, n - 1) + data[n - 1];
        }
    }
}