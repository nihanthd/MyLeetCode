package com.leetcode.easy;

import java.util.Arrays;

public class TwoSumUnique {

	public static void main(String[] args) {
		int[] a={1, 2, 5, 5, 10, 8, 2};
		int target = 10;
		Arrays.sort(a);
		int i = 0, j = a.length-1;
		while(i < j){
			int sum = a[i] + a[j];
			if(sum == target){
				System.out.println(a[i] + ", " + a[j]);
				j --;
				i++;
				while(j > i && a[j] == a[j+1]) j--;
				while(j > i && a[i] == a[i-1]) i++;
			}else if(sum < target){
				do
					i++;
				while(i < j && a[i] == a[i-1]);
			}else{
				do
					j --;
				while(j > i && a[j] == a[j+1]);
			}
		}
	}
}
