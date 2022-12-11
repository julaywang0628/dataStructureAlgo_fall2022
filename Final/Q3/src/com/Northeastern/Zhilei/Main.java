package com.Northeastern.Zhilei;

import java.util.HashSet;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = "lee(t(c)o)de)";
        System.out.println(validString(s));

        String s1 = "a)b(c)d";
        System.out.println(validString(s1));

        String s2 = "))((";
        System.out.println(validString(s2));
    }

    //time complexity: O(n), n refers to the s.length();
    //space complexity: O(m), m refers to the space of the stack and the set. The worst situation is the s.length();
    public static String validString(String s) {
        if(s.length() == 0 || s == null) {
            return "";
        }
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> wrongIndex = new HashSet<>();
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else if(s.charAt(i) == ')') {
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    wrongIndex.add(i);
                }
            }
        }

        while (!stack.isEmpty()) {
            wrongIndex.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i ++) {
            if(!wrongIndex.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
