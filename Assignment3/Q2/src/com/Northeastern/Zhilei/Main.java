package com.Northeastern.Zhilei;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> answer;
    public static boolean[] visited;
    public static List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        visited = new boolean[nums.length];
        backtracking(nums, visited, new ArrayList<>());
        return answer;
    }

    public static void backtracking(int[] nums, boolean[] visited, List<Integer> list) {
        if(list.size() == nums.length) {
            answer.add(new ArrayList<>(list));
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == true) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            backtracking(nums, visited, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
