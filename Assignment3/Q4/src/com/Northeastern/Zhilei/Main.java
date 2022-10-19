package com.Northeastern.Zhilei;

public class Main {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public static boolean[][] visited;
    public static int m, n;
    public static boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        if(board.length == 0 || board == null) {
            return false;
        }
        if(word.length() == 0 || word == null) {
            return true;
        }
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(backtracking(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean backtracking(int i, int j, char[][] board, String word, int index) {
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        if(index == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean found = backtracking(i, j + 1, board, word, index + 1) ||
                backtracking(i + 1, j, board, word, index + 1) ||
                backtracking(i, j - 1, board, word, index + 1) ||
                backtracking(i - 1, j, board, word, index + 1);
        visited[i][j] = false;
        return found;
    }
}
