package com.hammad.algorithms.dp;

public class NumArray {
    int[] sumArray;
    public NumArray(int[] nums) {
        if (null!=nums && nums.length != 0){
            sumArray = new int[nums.length];
            sumArray[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sumArray[i] =sumArray[i - 1] + nums[i];
            }
        }


    }
    public int sumRange(int i, int j) {
        if (null!=sumArray) {
            if (i <= 0) {
                return sumArray[j];
            } else {
                return sumArray[j] - sumArray[i - 1];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int [] data= {-2,0,3,-5,2,-1};
        NumArray numArray = new NumArray(data);

        System.out.println(numArray.sumRange(2,5));

    }


}
