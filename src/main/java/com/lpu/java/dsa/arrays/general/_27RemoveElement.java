package com.lpu.java.dsa.arrays.general;

public class _27RemoveElement {


    public static void main(String[] args) {

    }


    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int num : nums) {
            if (num != val) {
                nums[i] = num;
                i++;
            }
        }
        return i;
    }


    public int removeElementOld(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        System.out.println(count);
        return count;

    }
}

