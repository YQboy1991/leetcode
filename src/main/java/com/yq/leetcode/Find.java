package com.yq.leetcode;

/**
 * @author BaoLei Li
 * @date 2022/9/26
 **/
public class Find {

    public static void main(String[] args) {
        int[] nums = new  int[]{-1,0,3,5,9,12,13};
        final int search = search(nums, 12);
        System.out.println(search);

    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -100000;
    }
}
