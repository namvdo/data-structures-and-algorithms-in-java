package dynamicprogramming;

import java.util.List;

public class CoinChange {
	/**
	  You are given coins of different denominations and a total amount of money.
	  Write a function to compute the number of combinations that make up that amount. 
	 */

    public static int numOfWays(int amount, List<Integer> coins) {
        int []combinations = new int[amount + 1];
        combinations[0] = 1;
        for(int coin: coins) {
            for(int i = 1; i < combinations.length; i++) {
                if (i >= coin) {
                    combinations[i] += combinations[i - coin];
                }
            }
        }

        return combinations[amount];

    }

}