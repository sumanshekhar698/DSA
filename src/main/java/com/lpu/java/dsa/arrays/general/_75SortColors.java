package com.lpu.java.dsa.arrays.general;

class _75SortColors {
    public void sortColors(int[] nums) {
         int noOfZeros = 0, noOfOnes = 0, noOfTwos = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    noOfZeros++;
                    break;
                case 1:
                    noOfOnes++;
                    break;
                case 2:
                    noOfTwos++;
                    break;
            }
        }

        int i = 0;
        for (int j = 1; j <= noOfZeros; j++) {
            nums[i++] = 0;
        }

        for (int j = 1; j <= noOfOnes; j++) {
            nums[i++] = 1;
        }

        for (int j =1; j <= noOfTwos; j++) {
            nums[i++] = 2;
        }

        
    }


    private static void sortUsingDutchNationalFlagAlgoSinglePass(int[] nums) {

//        Initially we take three variables l,m,h
//        l,m=0 th index h - a.len-1 index
//        This algo starts wih a belief on two statements
//        1. After sorting all the element left to l (0 -> till l-1)will be 0
//        2. All the element right to h (from h+1 -> len -1) will be 1


        int l = 0, m = 0, h = nums.length - 1;
        while (m <= h) {
            switch (nums[m]) {
                case 0: {
                    ArrayUtil.swap(nums, m, l);
                    m++;
                    l++;//At the end l will be at starting of 1 sequence
                    break;
                }
                case 1: {
                    m++;//m will walk over all the ones
                    break;
                }
                case 2: {
                    ArrayUtil.swap(nums, m, h);
                    h--;//At the end h will be at last of 1 series
                    break;//*** here we are not incrementing m as h might hold 0 which needs to be again processed as case 0
                }
            }
        }

    }

    class ArrayUtil {

        public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


        public static void reverse(int[] arr, int start, int end) {
            while (start < end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
    }
}