package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;

import org.practice.utils.ArrayUtils;

import com.leetcode.utils.TreeNode;

public class TwoSumBinaryTree {
	public static ArrayList<Integer> ar = new ArrayList<Integer>();
	public static void main(String[] args) {
		TreeNode root = null;
		
		root = new TreeNode(0);
		root.left = new TreeNode(-1);
		root.right = new TreeNode(2);
		root.right.left = null;
		root.right.right = new TreeNode(4);
		root.left.left = new TreeNode(-3);
		root.left.right = null;
		root.left.left.left = null;
		root.left.left.right = null;
		
		int target = -4;
		System.out.println(findTarget(root, target));
	}
	private static boolean findTarget(TreeNode root, int target) {
		convertTree(root);
		Integer[] a = {};
		Arrays.stream(ar.toArray(a)).forEach(num -> System.out.println(num));
		return solution(ar, target);
	}
	
	public static boolean solution(ArrayList<Integer>a, int k){
		int i = 0, j = a.size()-1;
		while(i < j){
			int sum = a.get(i) + a.get(j);
			if(sum == k){
				return true;
			}else if(sum > k){
				j--;
			}else{
				i++;
			}
		}
		return false;
	}
	
	public static void convertTree(TreeNode root) {
		if(root != null){
			convertTree(root.left);
			ar.add(root.val);
			convertTree(root.right);
		}
		return;
	}
}