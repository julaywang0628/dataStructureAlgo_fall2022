package com.Northeastern.Zhilei;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    int[] candidates = new int[]{2,3,6,7};
	    int target = 7;

        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> answer;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();
        if(candidates == null || target == 0) {
            return answer;
        }
        backtracking(candidates, target, new ArrayList<>(), 0, 0);
        return answer;
    }

    public static void backtracking(int[] candidates, int target, List<Integer> list, int index, int sum) {
        if(sum == target) {
            answer.add(new ArrayList<>(list));
        }
        for(int i = index; i < candidates.length; i++) {
            if(sum + candidates[i] <= target) {
                sum += candidates[i];
                list.add(candidates[i]);
                backtracking(candidates, target, list, i, sum);
                sum -= candidates[i];
                list.remove(list.size() - 1);
            }

        }
    }
}
