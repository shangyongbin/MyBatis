package com.atguigu.mybatis.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    int[] indexArray;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {5,2,6,1};
        List<Integer> integers = solution.countSmaller(arr);

        System.out.println(integers);
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length < 1) return new ArrayList<Integer>();

        List<Integer> ans = new ArrayList<>();
        // 每一个数字的索引
        indexArray = new int[nums.length]; // 现在索引为i，原来索引为indexArray[i]
        for (int i=0; i<nums.length; i++) {
            ans.add(0);
            indexArray[i] = i;
        }


        mergeSort(nums, 0, nums.length-1, ans);

        return ans;
    }

    public void mergeSort(int[] nums, int left, int right, List<Integer> ans) {
        if (left == right) return;

        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid, ans);
        mergeSort(nums, mid+1, right, ans);

        merge(nums, left, mid, right, ans);

        return;
    }

    public void merge(int[] nums, int left, int mid, int right, List<Integer> ans) {
        int[] help = new int[right - left + 1];
        int[] indexHelp = new int[right - left + 1];

        int idx1 = left;
        int idx2 = mid + 1;
        int idx = 0;

        while (idx1 <= mid && idx2 <= right) {
            if (nums[idx1] > nums[idx2]) { // 说明idx1处的值 > idx2处的值 【> idx2 + 1处的值 > idx2 + 2 > right】
                int count = right - idx2 + 1;
                // nums[idx1] 之前的索引是indexArray[idx1]
                ans.set(indexArray[idx1], ans.get(indexArray[idx1]) + count);

                // num[idx1]的原索引是indexArray[idx1],现在变为left+idx
                indexHelp[idx] = indexArray[idx1];
                help[idx++] = nums[idx1++];
            } else { // 说明idx1处的值 > idx2处的值
                indexHelp[idx] = indexArray[idx2];
                help[idx++] = nums[idx2++];
            }
        }
        while (idx1 <= mid) {
            indexHelp[idx] = indexArray[idx1];
            help[idx++] = nums[idx1++];
        }
        while (idx2 <= right) {
            indexHelp[idx] = indexArray[idx2];
            help[idx++] = nums[idx2++];
        }
        // 修改indexArray

        // 重新赋给原数组
        for (int i=0; i<help.length; i++) {
            nums[left + i] = help[i];
            indexArray[left + i] = indexHelp[i];
        }

        return;

    }
}