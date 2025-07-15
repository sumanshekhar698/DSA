package com.lpu.java.dsa.binary_search;

public class _33SearchInRotatedSortedArrayEnhanced {

    public static void main(String[] args) {

        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(arr, 0));

    }

    static public int search(int[] nums, int target) {

//        If an array is rotated, it wil have 2 sorted parts

//        0,1,2     4,5,6,7
//        4, 5, 6, 7,     0, 1, 2
//     LSP 4 5 6 7     RSP 0 1 2

        int l = 0, r = nums.length - 1, mid;

        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;

//            Thing in terms of 1st iteration
            if (nums[mid] >= nums[l]) {//LSP
                if (target > nums[mid] || target < nums[l]) {//2 cases for Search the Right portion within LSP
                    l = mid + 1;
                } else {//Search the Left portion within LSP
                    r = mid - 1;
                }
            } else {//RSP
                if (target < nums[mid] || target > nums[r]) {//Search the Left portion
                    r = mid - 1;
                } else {//it means the target is > nums[mid[ BUT smaller than nums[r]
                    l = mid + 1;
                }
            }
        }

        return -1;


    }
}
