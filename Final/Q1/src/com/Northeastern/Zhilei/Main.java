package com.Northeastern.Zhilei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] strs= {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));

        String[] strs1= {""};
        System.out.println(groupAnagrams(strs1));

        String[] strs2= {"a"};
        System.out.println(groupAnagrams(strs2));

    }

    //Time Complexity: O(n+mlog(m)), n refers to the length of the strings, mlog(m) refers to the array sorting
    //Space Complexity: O(n), n refers to the space of the map
    public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] chArray = str.toCharArray();
            Arrays.sort(chArray);
            String curStr = new String(chArray);
            ArrayList<String> group = map.getOrDefault(curStr, new ArrayList<String>());
            group.add(str);
            map.put(curStr, group);
        }
        return new ArrayList<ArrayList<String>>(map.values());
    }
}
