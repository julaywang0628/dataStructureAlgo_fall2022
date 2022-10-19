package com.Northeastern.Zhilei;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    generateParenthesis(3);
        System.out.println(answer);
    }
    public static List<String> answer = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        if(n == 0) {
            return answer;
        }
        backtracking(n, n, new StringBuilder());
        return answer;
    }
    public static void backtracking(int left, int right, StringBuilder sb) {
        if(left == 0 && right == 0) {
            answer.add(sb.toString());
            return;
        }
        if(left > right) return;
        if(left > 0) {
            sb.append("(");
            backtracking(left - 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right > 0) {
            sb.append(")");
            backtracking(left, right - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
