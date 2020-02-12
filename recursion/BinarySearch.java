package recursion;
public class BinarySearch {
    /**
     * 
     * @param data
     * @param target
     * @param low
     * @param high
     * @return boolean
     * Returns true if the target value is found in the indicated position of the data array. 
     * This search only considers the array portion from data[low] to data[high] inclusive.
     */
    public static boolean binarySearch(int [] data, int target, int low, int high){
        if(low > high) return false; // interval empty, no match
        else{
            int mid = (high + low) / 2; // takes the mid index
            if(data[mid] == target){ 
                return true; // found a match
            }else if(data[mid] < target){
                return binarySearch(data, target, mid + 1, high); // recurs on the right of the middle.
            }else{
                return binarySearch(data, target, low, mid - 1); // recurs on the left of the middle.
            }
        }
    }
}