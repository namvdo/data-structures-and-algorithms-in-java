public class SquaredPower {
    /**
     * Computes the value of x raised to nth power, for non-negative integer n.
     * @param x
     * @param n
     * @return x raised to the nth power
     */
    public static double power(double x, int n){
        if(n == 0){
            return 1;
        }else{
            double partial = power(x, n / 2);
            double result = partial * partial;
            if(n % 2 != 0){
                result *= x;
            }
            return result;
        }
    }
}