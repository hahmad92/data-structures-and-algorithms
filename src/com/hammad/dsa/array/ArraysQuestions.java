package com.hammad.dsa.array;

import java.util.*;

public class ArraysQuestions {
    public static void main(String[] args) {
        ArraysQuestions demo = new ArraysQuestions();
        int [] data = {1,2,4,3,12};
        int [] nums1 = {0,1,2,3,12};
        int [] nums2 = {2,5,6};


        System.out.println(demo.heightChecker(data));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int localMax = 0;
        for(int i= 0; i < nums.length; i++){
            if(nums[i] == 1)
                localMax ++;
            else{
                if(localMax > max)
                    max =  localMax;
                localMax = 0;
            }
        }
        if(localMax > max){
            max = localMax;
        }
        return max;
    }

    public int findNumbers(int[] nums) {
        int noOfEvenDigits = 0;
        for(int i= 0; i < nums.length; i++){
            int noOfDigits = 1;
            int number = nums[i];
            while (number>9){
                number = number /10;
                noOfDigits++;
            }
            if(noOfDigits % 2 == 0){
                noOfEvenDigits++;
            }
        }
        return noOfEvenDigits;
    }

    //time nlog(n)
    public int[] sortedSquares(int[] data) {
        for (int i = 0; i < data.length; i ++){
            data[i]= data[i] * data[i];
        }
        java.util.Arrays.sort(data);
        return data;
    }

    //Space n Time n
    public int[] sortedSquares1(int[] data) {
        int positiveIndex = 0;
        int negativeEnd = 0;
        int[] result = new int[data.length];
        int resultIndex = 0;
        for (int i = 0; i < data.length; i++){
            if(data[i] < 0) {
                positiveIndex++;
            }
            data[i] = data[i] * data[i];
        }
        negativeEnd = positiveIndex - 1;
        while(negativeEnd > -1 && positiveIndex < data.length){
            if(negativeEnd > -1 && data[negativeEnd] < data[positiveIndex]){
                result[resultIndex] = data[negativeEnd];
                negativeEnd--;
            }else if(positiveIndex < data.length){
                result[resultIndex] = data[positiveIndex];
                positiveIndex++;
            }
            resultIndex++;
        }
        while(positiveIndex < data.length){
            result[resultIndex] = data[positiveIndex];
            positiveIndex++;
            resultIndex++;
        }
        while(negativeEnd > -1){
            result[resultIndex] = data[negativeEnd];
            negativeEnd--;
            resultIndex++;
        }
        return result;
    }

    public static int[] removeDuplicates(int[] A) {
        int index = 0;
        int sortedArrayIndex = 0;
        int[] sortedArray = new int[A.length];
        for(int i=0; i < A.length; i++){
            if(A[i] >= 0 && index==0){
                index = i;
            }
            A[i] = A[i] * A[i];
        }

        int posIndex=index;
        int negIndex=--index;
        for(sortedArrayIndex = 0; sortedArrayIndex < sortedArray.length; sortedArrayIndex++){
            if(A[posIndex] < A[negIndex]){
                sortedArray[sortedArrayIndex] = A[posIndex];
                posIndex++;
            }else if(A[negIndex] < A[posIndex]){
                sortedArray[sortedArrayIndex] = A[negIndex];
                negIndex--;
            }else{
                sortedArray[sortedArrayIndex] = A[posIndex];
                posIndex++;
                //negIndex--;
            }
            if(negIndex == 0 || posIndex == A.length) {
                sortedArrayIndex++;
                break;
            }
        }

        while(sortedArrayIndex < A.length){
            if(negIndex == 0 && posIndex < A.length){
                sortedArray[sortedArrayIndex] = A[posIndex++];
            }else if(posIndex == A.length && negIndex >=0){
                sortedArray[sortedArrayIndex] = A[negIndex--];
            }
            sortedArrayIndex++;
        }

        return sortedArray;
    }

    public void duplicateZeros(int[] arr) {
        int zeroToAppend = 0;
        for(int i= 0; i <arr.length ; i++){
            if(arr[i] == 0 ){
                int shift = 0;
                int temp;
                for(int j = ++i; j<arr.length; j++){
                    temp = arr[j];
                    arr[j] = shift;
                    shift = temp;
                }
            }

        }
    }

    public void duplicateZeros1(int[] arr) {
        int lastIndex = arr.length -1;
        int zeroCount = 0;
        for(int i= 0; i < arr.length - zeroCount ; i++) {
            if(arr[i] == 0){
                 arr[lastIndex] = 0;
                 lastIndex --;
                 zeroCount++;
             }
        }
        int index = lastIndex;
        lastIndex = arr.length -1;
        while(index >= 0) {
            if(arr[index] != 0){
                arr[lastIndex] = arr[index];
                lastIndex --;
                index--;
            }else if(arr[index] == 0){
                arr[lastIndex] = 0;
                arr[lastIndex-1] = 0;
                lastIndex = lastIndex -2;
                index--;
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index1 = m-1;
        int index2 = n-1;
        int lastIndex = nums1.length-1;

        while(index1 >= 0 && index2 >= 0){
            if(nums1[index1] > nums2[index2]){
                nums1[lastIndex] = nums1[index1];
                index1--;
            }else{
                nums1[lastIndex] = nums2[index2];
                index2--;
            }
            lastIndex--;
        }

        while(index2 >= 0){
            nums1[lastIndex] = nums2[index2];
            index2--;
            lastIndex--;
        }
        while(index1 >= 0){
            nums1[lastIndex] = nums1[index1];
            index1--;
            lastIndex--;
        }
    }
    public int removeElement(int[] nums, int val) {
        int first = 0;
        int last = nums.length -1;
        while(first <= last){
            if(nums[first] == val){
                if(nums[last] != val){
                    nums[first] = nums[last];
                    nums[last] = val;
                    first++;
                    last--;
                }else{
                    last--;
                }

            }else{
                first++;
            }
        }
        return first;
    }
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>(arr.length);
        int containsZero = 0;
        for(int i = 0; i <arr.length; i++){
            set.add(arr[i]);
        }

        for(int i = 0; i <arr.length; i++){
            if(set.contains(arr[i] * 2)){
                return true;
            }
        }
        return false;
    }


    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while( j < nums.length){
            if(nums[i] == 0){
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++;
                }
            }else {
                i++;
            }
            j++;
        }
    }
    public int heightChecker(int[] heights) {
        int [] sortHeight = java.util.Arrays.copyOf(heights,heights.length);
        java.util.Arrays.sort(sortHeight);
        int galti = 0;
        for(int i = 0; i < heights.length; i++){
            if(heights[i] != sortHeight[i])
                galti++;
        }
        return galti;

    }

    public boolean containsDuplicateNlogN(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1])
                return true;
        }
        return false;
    }

    public boolean containsDuplicateLogN(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if(count.containsKey(nums[i])){
                Integer n = count.get(nums[i]);
                n++;
                count.put(nums[i],n);

            }else{
                count.put(nums[i],1);
            }
        }
        for (Integer i:count.values()){
            if (i>1)
                return true;
        }
        return false;
    }

    public int[] sortedSquares2(int[] data) {


        if(data.length > 1 && data[0] < data[1] ){
            for (int i = 0; i < data.length; i++) {
                data[i] = data[i] * data[i];
            }
            return data;
        }


        return data;
    }

}
