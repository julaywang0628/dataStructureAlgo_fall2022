package com.Northeastern.Zhilei;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] grid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(paths(grid));

        int[][] grid1 = {
                {0,1},
                {0,0},
        };
        System.out.println(paths(grid1));
    }

    //time complexity: O(m*n), m = grid.length, n = grid[0].length;
    //space complexity: O(m*n), refers to the space of the int[][] dp;
    public static int paths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        if(grid == null || grid.length == 0) {
            return 0;
        }

        for(int i = 0; i < m && grid[i][0] == 0; i ++) {
            dp[i][0] = 1;
        }
        for(int i = 0; i < n && grid[0][i] == 0; i ++) {
            dp[0][i] = 1;
        }
        for(int i = 1; i < m; i ++) {
            for(int j = 1; j < n; j ++) {
                if(grid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
