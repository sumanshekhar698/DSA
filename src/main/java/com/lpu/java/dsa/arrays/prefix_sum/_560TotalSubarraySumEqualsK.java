package com.lpu.java.dsa.arrays.prefix_sum;

import java.util.Collections;
import java.util.HashMap;

public class _560TotalSubarraySumEqualsK {

    public static void main(String[] args) {
        int arr[] = {4, 5, 1, 3, 2, 3, 4}, k = 9;
        int ans = subarraySum(arr, k);
        System.out.println(ans);
    }


    public static int subarraySumUsingPrefixSum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1]; // prefix[0] = 0

        // Build prefix sum array
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int count = 0;

        // Try every subarray [i..j]
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = prefix[j + 1] - prefix[i];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    static public int subarraySum(int[] nums, int k) {//prefix SUM will bring it to n^2
        int numberOfSubArrays = 0;
        int curSum = 0;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();//prefixSum : Count
        prefixSumMap.put(0, 1);//there is an empty prefix with curSum 0

        for (int num : nums) {
            curSum += num;
            int diff = curSum - k;

            numberOfSubArrays += prefixSumMap.getOrDefault((diff), 0);
            prefixSumMap.put(curSum, prefixSumMap.getOrDefault(curSum, 0) + 1);

        }

        return numberOfSubArrays;



    }
}
