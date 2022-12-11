package com.Northeastern.Zhilei;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[][] grid = {
                {"1","1","1","1","0"},
                {"1","1","0","1","0"},
                {"1","1","0","0","0"},
                {"0","0","0","0","0"}
        };
        System.out.println(numOfIslands(grid));

        String[][] grid1 = {
                {"1","1","0","0","0"},
                {"1","1","0","0","0"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}
        };
        System.out.println(numOfIslands(grid1));
    }

    public static int m, n;

    //time complexity: O(m * n), m = grid.length, n = grid[0].length;
    //space complexity: O(m * n), it refers to the space of boolean[][] visited and the space of recursion
    public static int numOfIslands(String[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int answer = 0;
        if(grid.length == 0 || grid == null) {
            return answer;
        }
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(grid[i][j] == "1" && !visited[i][j]) {
                    bfs(i, j, grid, visited);
                    answer ++;
                }
            }
        }

        return answer;
    }

    public static void bfs(int row, int col, String[][] grid, boolean[][] visited) {
        if(row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == "0" || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        bfs(row + 1, col, grid, visited);
        bfs(row, col + 1, grid, visited);
        bfs(row - 1, col, grid, visited);
        bfs(row, col - 1, grid, visited);
    }

}
