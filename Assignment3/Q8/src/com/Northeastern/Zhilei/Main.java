package com.Northeastern.Zhilei;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        allPathsSourceTarget(graph);
        System.out.println(answer);
    }
    public static List<List<Integer>> answer = new ArrayList<>();
    public static List<Integer> path = new ArrayList<>();
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);
        backtracking(graph, 0);
        return answer;
    }
    public static void backtracking(int[][] graph, int node) {
        if(node == graph.length - 1) {
            answer.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < graph[node].length; i ++) {
            path.add(graph[node][i]);
            backtracking(graph, graph[node][i]);
            path.remove(path.size() - 1);
        }
    }
}
