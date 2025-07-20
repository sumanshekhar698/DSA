package com.lpu.java.dsa.queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class _1985FindTheKthLargestIntegerInTheArray {


    public String kthLargestNumberERROR(String[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue(Collections.reverseOrder());
        for (String num : nums) {
            pq.add(Long.parseLong(num));
        }

        long res = 0;
        for (int i = 0; i < k; i++) {
            res = pq.poll();

        }

        return String.valueOf(res);
    }


    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            } else {
                return b.compareTo(a);
            }
        });
        for (String i : nums) {
            pq.offer(i);
        }
        for (int i = 1; i < k; i++) {
            pq.poll();
        }
        return pq.peek();
    }




    public String kthLargestNumberUsingBinarySearch(String[] nums, int k) {
        return kthLargestNumber(0, nums.length - 1, nums, nums.length - k);
    }

    public String kthLargestNumber(int s, int e, String[] nums, int k) {
        if (s == e) return nums[s];
        int start = s;
        int end = e;
        String c = nums[(end + start) / 2];
        while(start <= end) {
            while (start <= end && compare(nums[start], c) < 0) start++;
            while (start <= end && compare(nums[end], c) > 0) end--;
            if (start <= end) swap(nums, start++, end--);
        }
        if (k <= end) return kthLargestNumber(s, end, nums, k);
        if (k >= start) return kthLargestNumber(start, e, nums, k);
        return nums[k];
    }

    private void swap(String[] nums, int i, int j) {
        if (i == j) return;
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int compare(String a, String b) {
        return a.length() != b.length() ? Integer.compare(a.length(), b.length()) : a.compareTo(b);
    }


}


