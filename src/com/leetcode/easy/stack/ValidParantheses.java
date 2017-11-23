package com.leetcode.easy.stack;

import java.util.Stack;

public class ValidParantheses {

	public static void main(String[] args) {
//		String s = "()[]{}";
		String s = "([)]";
		System.out.println(isValid(s));

	}
	
	public static boolean isValid(String s) {
		Stack<String> history = new Stack<String>();
        for(int i = 0; i < s.length() ; i++){
            String brace = s.substring(i, i+1);
            if(!history.isEmpty() && (brace.equals(")") || brace.equals("}") || brace.equals("]"))){
            	String tempBrace = history.peek();
            	switch(brace){
            		case "}":
            			if(tempBrace.equals("{")){
            				history.pop();
            			}else{
            				history.push(brace);
            			}
            			break;
            		case ")":
            			if(tempBrace.equals("(")){
            				history.pop();
            			}else{
            				history.push(brace);
            			}
            			break;
            		case "]":
            			if(tempBrace.equals("[")){
            				history.pop();
            			}else{
            				history.push(brace);
            			}
            			break;
            		default:
            			
            	}
            }else{
            	history.push(brace);
            }
        }
        if(history.isEmpty()){
        	return true;
        }else{
        	return false;
        }
    }

}
