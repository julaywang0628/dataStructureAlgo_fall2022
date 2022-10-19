package com.Northeastern.Zhilei;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    int[] nums = new int[] {1, 2, 3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> answer = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, new ArrayList<>(), 0);
        return answer;
    }

    public static void backtracking(int[] nums, List<Integer> list, int path) {
        answer.add(new ArrayList(list));
        if(path == nums.length) {
            return;
        }
        for(int i = path; i < nums.length; i ++) {
            list.add(nums[i]);
            backtracking(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
