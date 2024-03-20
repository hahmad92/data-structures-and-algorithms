package com.hammad.dsa.algoexpert.p1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeNumberSum {
    public static void main(String[] args) {
        int[] result = threeNumberSumWithSorting(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 3);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] threeNumberSum(int[] numbers, int sum) {
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                for (int k = j+1; k < numbers.length; k++) {
                    if (numbers[i] + numbers[j] + numbers[k] == sum){
                        return new int[]{numbers[i], numbers[j], numbers[k]};
                    }
                }

            }
        }
        return new int[]{};
    }

    private static int[] threeNumberSumWithHashMap(int[] numbers, int sum) {
        Map<Integer, Integer> lookup = new HashMap<>();
        int requiredNum = 0;
        for (int i = 0; i < numbers.length; i++) {
            requiredNum = sum - numbers[i];
            if (lookup.containsKey(requiredNum)){
                return new int[]{requiredNum, numbers[i]};
            }else {
                lookup.put(numbers[i],numbers[i]);
            }
        }
        return new int[]{};
    }

    private static int[] threeNumberSumWithSorting(int[] numbers, int sum) {
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            int leftIndex = i + 1;
            int rightIndex = numbers.length - 1;
            int targetSum = sum - numbers[i];

            while (leftIndex != rightIndex){
                int temp = numbers[leftIndex] + numbers[rightIndex];
                if (temp == targetSum)
                {
                    return new int[]{numbers[i], numbers[leftIndex], numbers[rightIndex]};
                } else if (temp < targetSum){
                    leftIndex++;
                } else if (temp > targetSum){
                    rightIndex--;
                }
            }
        }
        return new int[]{};
    }






}
