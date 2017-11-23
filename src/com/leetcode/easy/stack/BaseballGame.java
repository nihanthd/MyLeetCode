package com.leetcode.easy.stack;

import java.util.Stack;

public class BaseballGame {

	public static void main(String[] args) {
//		String[] input = { "5", "-2", "4", "C", "D", "9", "+", "+" };
//		String[] input = { "5","2","C","D","+" };
		String[] input = { "-21","-66","39","+","+" };
		calPoints(input);
	}

	public static int calPoints(String[] ops) {
		int finalScore = 0;
		Stack<Integer> input = new Stack<Integer>();
		for (int i = 0; i < ops.length; i++) {
			String klass = null;
			Integer integerValue = null;
			String operation = null;
			//Lets try and find out the type of value
			try{
				integerValue = Integer.parseInt(ops[i]);
				klass = "Integer";
			}catch(NumberFormatException ex){
				operation = ops[i];
				klass = "String";
			}
			switch (klass) {
			case "String" :
				//Perform the operation on the final score using stack.
				switch (operation) {
				case "+":
					if(!input.isEmpty()){
						int temp = input.pop();
						int n = input.peek() + temp;
						finalScore += n;
						input.push(temp);
						input.push(n);
					}
					break;
				case "C":
					//Previous round's score is invalid
					if(!input.isEmpty()){
						finalScore =  finalScore - input.pop();
					}
					break;
				case "D":
					if(!input.isEmpty()){
						int score = 2 * input.peek();
						finalScore = finalScore +  score;
						input.push(score);
					}
					break;
				default:
					break;
				}
				break;
			case "Integer":
				//Add the value to final score and put in the stack.
				finalScore = finalScore + integerValue;
				input.push(integerValue);
				break;
			default:
				break;
			}
			System.out.println(finalScore);
		}
		return finalScore;
	}

}
