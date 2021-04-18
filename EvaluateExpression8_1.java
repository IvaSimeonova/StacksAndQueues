package Stacks.and.Queues;

import java.util.Scanner;
import java.util.Stack;

public class EvaluateExpression8_1 {

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
		Stack<Character> operatorStack = new Stack<Character>();
		expression = insertBlanks(expression);
		String[] tokens = expression.split(" ");
		for (String token : tokens){
			if (token.length() == 0)
				continue;
			else if (token.charAt(0) == '+' || token.charAt(0) == '-'){
				while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-' 
						|| operatorStack.peek() == '*' || operatorStack.peek() == '/' || operatorStack.peek() == '^')) {
					processAnOperator(operandStack, operatorStack);
				}
				operatorStack.push(token.charAt(0));
			}else if (token.charAt(0) == '*' || token.charAt(0) == '/'){
				while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/' || operatorStack.peek() == '^')){
					processAnOperator(operandStack, operatorStack);
				}
				operatorStack.push(token.charAt(0));
			}else if (token.trim().charAt(0) == '^'){
				
			}else if (token.trim().charAt(0) == '('){
				
			}else if (token.trim().charAt(0) == ')'){
				while (operatorStack.peek() != '('){
					processAnOperator(operandStack, operatorStack);
				}
				operatorStack.pop();
			}else{
				operandStack.push(Integer.valueOf(token));
			}
		}
		while(!operatorStack.isEmpty()){
			processAnOperator(operandStack, operatorStack);
		}
		return operandStack.pop();
	}

	public static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		// TODO Auto-generated method stub
		char op = operatorStack.pop();
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
			operandStack.push((int)Math.pow(op2, op1));
	}

	public static String insertBlanks(String s) {
		// TODO Auto-generated method stub
		String result = "";
		for (int i = 0; i < s.length(); i++){
			if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-'
					|| s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '^')
				result += " " + s.charAt(i) + " ";
			else
				result += s.charAt(i);
		}
		return result;
	}

}

