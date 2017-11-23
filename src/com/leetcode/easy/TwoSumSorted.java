package com.leetcode.easy;

public class TwoSumSorted {

	public static void main(String[] args) {
		int[] numbers = {2,7,11,15};
		int target = 9;
		solution(numbers, target);
	}

	private static int[] solution(int[] numbers, int target) {
		int i = 0, j = numbers.length-1;
		while(i < j){
			int sum = numbers[i] + numbers[j];
			if(sum == target){
				break;
			}else if (sum < target){
				i++;
			}else{
				j--;
			}
		}
		int[] ans = {i+1, j+1}; 
		return ans;
	}
	
	

}
