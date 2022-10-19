package com.Northeastern.Zhilei;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        numsSameConsecDiff(3, 7);
        System.out.println(list);
    }
    public static List<Integer> list = new ArrayList<>();
    public static int[] numsSameConsecDiff(int n, int k) {
        for(int i = 1; i <= 9; i ++) {
            backtracking(n - 1, k, i);
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i ++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void backtracking(int n, int k, int curNum) {
        if(n == 0) {
            list.add(curNum);
            return;
        }
        for(int i = 0; i <= 9; i ++) {
            if(Math.abs(curNum % 10 - i) == k) {
                curNum = curNum * 10 + i;
                backtracking(n - 1, k, curNum);
                curNum = (curNum - i) / 10;
            }
        }
    }
}
