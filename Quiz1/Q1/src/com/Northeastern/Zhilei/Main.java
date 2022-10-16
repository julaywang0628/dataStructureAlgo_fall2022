package com.Northeastern.Zhilei;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotateArray(nums, 3);
        for(int num : nums) {
            System.out.print(num + ",");
        }
    }

    public static void rotateArray(int[] nums, int k) {
        int times = k % nums.length;
        if(times != 0){
            reverse(nums, 0, nums.length - times - 1);
            reverse(nums, nums.length - times, nums.length - 1);
            reverse(nums, 0, nums.length - 1);
        }
    }

    public static void reverse(int[]nums, int l, int r) {
        while(l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
