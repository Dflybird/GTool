package com.gq;

/**
 * @author gq
 * @version 1.0, 2018-09-11
 */

public class MathUtil {

    public static int max(int[] arr){
        int max = arr[0];
        for (int a : arr) {
            if (a>max)
                max = a;
        }
        return max;
    }

    public static int min(int[] arr){
        int min = arr[0];
        for (int a : arr) {
            if (a<min)
                min = a;
        }
        return min;
    }

    public static int maxIndex(int[] arr){
        int max = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static int minIndex(int[] arr){
        int min = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }

}
