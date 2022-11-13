package com.Northeastern.Zhilei;

public class Main {

    public static void main(String[] args) {
	    int[] arr = {0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11};
	    int[] values = {1,4,5,10};
	    int[] output = getStartOfEachValues(arr, values);

	    for(int i : output) {
            System.out.println(i);
        }
    }
    // arr = [0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11]
    // values = [1,4,5,10]
    // output = [5, -1, 11, 16]
    private static int[] getStartOfEachValues(int[] arr, int[] values){
        int[] indexes = new int[values.length];

        for(int i = 0; i < values.length; i ++) {
            indexes[i] = binarySearch(values[i], arr);
        }
        return indexes;
    }

    public static int binarySearch(int num, int[] arr) {
        int index = -1;
        int left = 0, right = arr.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == num) {
                index = mid;
                break;
            } else if(arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int leftIndex = index;
        while(leftIndex >= 0 && arr[leftIndex] == num) {
            leftIndex --;
        }
        return leftIndex == -1? -1 : leftIndex + 1;
    }
}
