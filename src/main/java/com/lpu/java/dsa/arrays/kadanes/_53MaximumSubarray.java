package com.lpu.java.dsa.arrays.kadanes;

public class _53MaximumSubarray {


    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    }

    public int maxSubArray(int[] nums) {

        int sum = nums[0];//will have atleast one element
        int max = sum;
        for (int i = 1; i < nums.length; i++) {
            sum = Integer.max(nums[i], sum + nums[i]);// max of current element + previous max + current element
            max = Integer.max(sum, max);

        }
        return max;

    }


    public int maxSubArraySimplified(int[] nums) {

        int currentSum = nums[0];//will have atleast one element
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {


            if (currentSum >= 0) {
                currentSum += nums[i];
            } else {
                currentSum = nums[i];
            }

//            max = Math.max(currentSum, max);

            if (currentSum > max) {
                max = currentSum;
            }
        }
        return max;

    }
}
