package Stacks.and.Queues;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class MatchingBraces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> braces = new Stack<>();
		File myObj = new File("scr/Stacks/and/Queues/Ball.java");
		FileReader fr;
		try{
			fr = new FileReader(myObj);
			BufferedReader br = new BufferedReader(fr);
			int c = 0;
			boolean conflict = false;
			//c = br.read();
			while ((c = br.read()) != -1){
				char character = (char) c;
				if(character == '{' || character == '[' || character == '('){
					braces.add(character);//autoboxing
				}else if (character == '}'){
					conflict = braces.pop() != '{';
				}else if (character == ']'){
					conflict = braces.pop() != '{';
				}else if (character == ')'){
					conflict = braces.pop() != '{';
			    }
				
				if(conflict){
					break;
				}		
				
				//c = br.read();
		    }
			
			if(conflict || !braces.isEmpty()){
				System.out.println("Missmatched braces");
			}else{
				System.out.println("No missmatched braces");
			}
			}catch(IOException e){
				e.printStackTrace();
				
			}
	}
}
