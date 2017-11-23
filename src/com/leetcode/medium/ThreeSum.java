package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		// int[] nums = { -1, 0, 1, 2, -1, -4 };
		int[] nums = { 0, 0, 0, 0 };
		ThreeSum sum = new ThreeSum();
		List<List<Integer>> solutions = sum.threeSum(nums);
		System.out.println("Solutions found");
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> solutions = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {
			// Holding this as 'a' we will try to find 'b' and 'c' which will
			// satisfy the criteria 'b + c = -a'
			int a = nums[i];
			if (i > 0 && nums[i] == nums[i - 1]){
	            continue;
	        }
			int target = 0 - a;
			// From here our approach would be the same like Two Sum problem
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				int b = nums[j], c = nums[k];
				int sum = b + c;
				if (sum == target) {
					List<Integer> solution = new ArrayList<Integer>();
					solution.add(a);
					solution.add(b);
					solution.add(c);
					solutions.add(solution);
					j++;
					k--;
					while(j < k && nums[j] == nums[j - 1]) j++;
					while(j < k && nums[k] == nums[k+1]) k--;
				} else if (sum < target) {
					j++;
				} else {
					k--;
				}
			}
		}
		return solutions;
	}

}
