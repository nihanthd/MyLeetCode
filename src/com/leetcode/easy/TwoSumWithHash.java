package com.leetcode.easy;

import java.util.HashMap;

import org.practice.utils.ArrayUtils;

public class TwoSumWithHash {
	public static void main(String[] args) {
		int[] nums = {2,11, 7,15};
		int[] x = twoSum(nums, 9);
		ArrayUtils.printArray(x);
	}
	
	 public static int[] twoSum(int[] nums, int target) {
	        int[] indices = new int[2];
	        HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();
	        for(int i = 0; i < nums.length; i++){
	        	int remaining = target - nums[i];
	            if(values.keySet().contains(remaining)){
	            	indices[0] = values.get(remaining);
	            	indices[1] = i;
	            	break;
	            }else{
	            	values.put(nums[i], i);
	            }
	        }
			return indices;
	    }
}
