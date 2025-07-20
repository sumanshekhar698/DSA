package com.lpu.java.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class _503NextGreaterElementII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};//[2,3,4,-1,4]
        int[] result = nextGreaterElement(nums);
        System.out.println(Arrays.toString(result));

    }


    public static int[] nextGreaterElement(int[] nums) {//monotonic stack
        Stack<Integer> stack = new Stack<Integer>();
        int[] nge = new int[nums.length];
        int n = nums.length;

        for (int i = 2 * n - 1; i >= 0; i--) {// 2n-1 to 0

            int index = i % n;

//            we are popping until the stack has some value OR we get nge for current nums[i]
            while (!stack.isEmpty() && nums[index] >= stack.peek()) {
                stack.pop();//
            }


            // assigning the nge
            nge[index] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(nums[index]);// Always pushing the current element in the stack
            // stack will always remain in increasing order

        }
        return nge;
    }

    public static int[] nextGreaterElementNBRUTE(int[] nums) {//monotonic stack
        int[] nge = new int[nums.length];
        int n = nums.length;
        Arrays.fill(nge, -1);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= i + n - 1; j++) {
                int index = j % n;
                if (nums[index] > nums[i]) {
                    nge[i] = nums[index];
                    break;
                }

            }

        }
        return nge;
    }
}
