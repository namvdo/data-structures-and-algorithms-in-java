package dynamicprogramming;

public class LongestCommonSubString {
    public static int[][] LCS(char[] x, char[] y) {
        int n = x.length;
        int m = y.length;
        int [][] l = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (x[i] == y[j]) {
                    l[i + 1][j + 1] = l[i][j] + 1;
                } else {
                    l[i + 1][j + 1] = Math.max(l[i][j + 1], l[i + 1][j]);
                }
            }
        }
        return l;
    }
}
