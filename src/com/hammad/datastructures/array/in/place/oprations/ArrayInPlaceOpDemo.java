package com.hammad.datastructures.array.in.place.oprations;

public class ArrayInPlaceOpDemo {
    public static void main(String[] args) {
        ArrayInPlaceOpDemo demo = new ArrayInPlaceOpDemo();
        int [] data = {17,18,5,4,6,1};
        data = demo.replaceElements(data);
        for(int i : data){
            System.out.print(i + ",");
        }
    }

    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int last = -1;
        for(int i=n-1;i>=0;i--){
            int temp = arr[i];
            arr[i] = last;
            last = last>temp ? last : temp;
        }
        return arr;
    }
}
