package com.hammad.datastructures.algoexpert.p1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] result = twoNumberSumWithSorting(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] twoNumberSum(int[] numbers, int sum) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == sum){
                    result[0] = numbers[i];
                    result[1] = numbers[j];
                }
            }
        }
        return result;
    }

    private static int[] twoNumberSumWithHashMap(int[] numbers, int sum) {
        Map<Integer, Integer> lookup = new HashMap<>();
        int[] result = new int[2];
        int requiredNum = 0;
        for (int i = 0; i < numbers.length; i++) {
            requiredNum = sum - numbers[i];
            if (lookup.containsKey(requiredNum)){
                result[0] = requiredNum;
                result[1] = numbers[i];
            }else {
                lookup.put(numbers[i],numbers[i]);
            }
        }
        return result;
    }

    private static int[] twoNumberSumWithSorting(int[] numbers, int sum) {
        Arrays.sort(numbers);
        int[] result = new int[2];

        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        while (leftIndex != rightIndex){
            int temp = numbers[leftIndex] + numbers[rightIndex];
            if (temp == sum)
            {
                result[0] = numbers[leftIndex];
                result[1] = numbers[rightIndex];
                return result;
            } else if (temp < sum){
                leftIndex++;
            } else if (temp > sum){
                rightIndex--;
            }
        }
        return result;
    }






}
