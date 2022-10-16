package com.Northeastern.Zhilei;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static String[] numMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> answer;
    public static List<String> letterCombinations(String digits) {
        answer = new ArrayList<>();
        if(digits.length() == 0 || digits == null) {
            return answer;
        }
        backtracking(digits, new StringBuilder(), 0);
        return answer;
    }
    public static void backtracking(String digits, StringBuilder sb, int index) {
        if(sb.length() == digits.length()) {
            answer.add(sb.toString());
            return;
        }
        char curNum = digits.charAt(index);
        int mapIndex = curNum - '0';
        String curLetters = numMap[mapIndex];
        for(int i = 0; i < curLetters.length(); i ++) {
            sb.append(curLetters.charAt(i));
            backtracking(digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
