package Stacks.and.Queues;

import java.util.Scanner;
import java.util.Stack;

public class PostFix8_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter an expression: ");
		Scanner sc = new Scanner(System.in);
		String expression = sc.nextLine();
		try{
			System.out.println(evaluateExpression(expression));
		}catch (Exception ex){
			System.out.println("Wrong expression: " + args[0]);
		}

	}

	public static int evaluateExpression(String expression) {
		// TODO Auto-generated method stub
		Stack<Integer> operandStack = new Stack<Integer>();
		expression = insertBlanks(expression);
		String[] tokens = expression.split(" ");
		for (String token : tokens){
			if(token.length() == 0)
				continue;
		    else if (token.charAt(0) == '+' || token.charAt(0) == '-' || token.charAt(0) == '*' || token.charAt(0) == '/'){
			         processAnOperator(operandStack, token.charAt(0));
		    }else{
		    	operandStack.push(Integer.valueOf(token));
		    }
		 }
		return operandStack.pop();
	}
	
	public static void processAnOperator(Stack<Integer> operandStack, char op) {
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();
		if (op == '+')
			operandStack.push(op2 + op1);
		else if (op == '-')
			operandStack.push(op2 - op1);
		else if (op == '*')
			operandStack.push(op2 * op1);
		else if (op == '/')
			operandStack.push(op2 / op1);
		else if (op == '^')
			operandStack.push((int) Math.pow(op2, op1));
	}

	public static String insertBlanks(String s) {
		// TODO Auto-generated method stub
		String result = "";
		for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-'
					|| s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '^')
				result += " " + s.charAt(i) + " ";
			else
				result += s.charAt(i);
		}
		return result;
	}

}
