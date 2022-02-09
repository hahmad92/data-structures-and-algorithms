package com.hammad.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

public class DynamicProgrammingDemo {
    public static void main(String[] args) {
        DynamicProgrammingDemo dynamicProgrammingDemo = new DynamicProgrammingDemo();
        int [] data= {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(dynamicProgrammingDemo.isSubsequence("acb","ahbgdc"));

    }

    public static boolean divisorGame(int number) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(1,1);

        for(int i = 2; i <= number; i++){
            int remainingNumber = i;
            boolean result = false;
            for(int j = 1; j < remainingNumber;){
                if(i % j == 0){
                    if(dp.get(remainingNumber - j) == 1){
                        remainingNumber = remainingNumber - j;
                        result = true;
                    }else{
                        j++;
                    }
                }else{
                    j++;
                }
            }
            if(result){
                dp.put(i,2);
            }else{
                dp.put(i,1);
            }
        }
        if(dp.get(number) == 1){
            return false;
        } else{
            return true;
        }

    }

    public int maxProfit(int[] prices) {
        int  maxProfit = 0;
        int maxSellingPrice = 0;
        if(prices.length > 0){
            maxSellingPrice = prices[prices.length - 1];
        }
        for(int i = prices.length - 2; i >= 0; i--){
            if(maxSellingPrice - prices[i] > maxProfit){
                maxProfit = maxSellingPrice - prices[i];
            }else if( prices[i] > maxSellingPrice){
                maxSellingPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public int climbStairs(int n) {
        int first = 1;
        int second = 1 ;
        for (int i = 2; i <= n; i++){
            int temp = second;
            second = second + first;
            first = temp;
        }
        return second;
    }

    public int thirdMax(int[] nums) {
        Integer firstMax = null;
        Integer secondMax = null;
        Integer thirdMax = null;
        for (int i = 0; i < nums.length; i++) {
            if(firstMax == null || nums[i] > firstMax ){
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            }else if(secondMax == null ||  (nums[i] > secondMax && nums[i] < firstMax)){
                thirdMax = secondMax;
                secondMax = nums[i];
            }else if(thirdMax == null || (nums[i] > thirdMax && nums[i] < secondMax)){
                thirdMax = nums[i];
            }
        }
        if(thirdMax != null){
            return thirdMax;
        }else{
            return firstMax;
        }

    }

    // O(N^2) Time
    // O(1) space
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 0; i < nums.length ; i++) {
            int localSum = nums[i];
            if(localSum > maxSum)
                maxSum = localSum;
            for (int j = i + 1; j < nums.length; j++) {
                localSum += nums[j];
                if(localSum > maxSum)
                    maxSum = localSum;
            }
        }
        return  maxSum;
    }


    // O(N) Time
    // O(1) space
    public int maxSubArray1(int[] nums) {
        int maxSum;
        int pointSum = nums[0];
        maxSum = pointSum;
        for (int i = 1; i < nums.length ; i++) {
            if(nums[i] < nums[i] + pointSum ){
                pointSum = nums[i] + pointSum;
            }else{
                pointSum = nums[i];
            }
            if(pointSum > maxSum){
                maxSum = pointSum;
            }
        }
        return  maxSum;
    }

    public boolean isSubsequence(String s, String t) {
        int location = 0;
        for (int i = 0; i < s.length() ; i++) {
            location = t.indexOf(s.charAt(i),location);
            if(location == -1)
                return false;
            location++;
        }
        return true;
    }

    public int rob(int[] nums) {
        int maxLoot = 0;
        int maxLootIndex = 0;
        int secondMaxLoot = 0;
        int secondMaxLootIndex = 0;
        if(nums.length > 1 ){
            maxLoot = nums[0] >= nums[1] ? nums[0] : nums[1];
            maxLootIndex = nums[0] >= nums[1] ? 0 : 1;
            secondMaxLoot = nums[0] > nums[1] ? nums[1] : nums[0];
            secondMaxLootIndex = nums[0] > nums[1] ? 1 : 0;
        }else if(nums.length > 0){
            maxLoot = nums[0];
        }
        for (int i = 2; i < nums.length; i++) {
            if( i-1 != maxLootIndex ){
                maxLoot += nums[i];
                maxLootIndex = i;
            }
            else{
                if (nums[i] + secondMaxLoot > maxLootIndex){
                    int temp = maxLootIndex;
                    maxLoot = nums[i] + secondMaxLoot;

                    secondMaxLoot = temp;
                    secondMaxLootIndex = maxLootIndex;

                    maxLootIndex = i;
                }
            }

        }

        return maxLoot;
    }

}
