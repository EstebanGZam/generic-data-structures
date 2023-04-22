package ui;

import dataStructures.Hash.Hash;
import dataStructures.Queue.Queue;
import dataStructures.Stack.Stack;

import java.util.Scanner;

public class Main {
	public static Hash<Integer, String> hash = new Hash<>(10);
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		reverseString();
		System.out.println();
		reverseQueue();
		System.out.println();
		reverseStack();
		System.out.print("Type an arithmetic expression with parenthesis: ");
		String expression = input.nextLine();
		if (checkBalancedParentheses(expression)) {
			System.out.println("The mathematical expression has the parentheses balanced.");
		} else {
			System.out.println("The math expression does not have the balanced parentheses.");
		}
	}

	public static boolean checkBalancedParentheses(String expression) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c == '(' || c == '[' || c == '{')
				stack.push(c);
			if (c == ')' || c == ']' || c == '}') {
				if (stack.isEmpty()) return false;
				char top = stack.top();
				stack.pop();
				if (c == ')' && top != '(' || c == '[' && top != ']' || c == '{' && top != '}') return false;
			}
		}
		return stack.isEmpty();
	}

	public static void reverseString() {
		Stack<Character> stack = new Stack<>();
		System.out.print("Type a string: ");
		String text = input.nextLine();
		for (int i = 0; i < text.length(); i++) {
			stack.push(text.charAt(i));
		}
		int stackSize = stack.size();
		for (int i = 0; i < stackSize; i++) {
			System.out.print(stack.top());
			stack.pop();
		}
	}

	public static void reverseQueue() {
		Queue<Integer> queue = new Queue<>();
		queue.enqueue(10);
		queue.enqueue(5);
		queue.enqueue(2);
		queue.reverseQueue();
		int queueSize = queue.size();
		for (int i = 0; i < queueSize; i++) {
			System.out.print(queue.dequeue());
		}
	}

	public static void reverseStack() {
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(14);
		stack.push(20);
//		stack.reverseStack();
		int stackSize = stack.size();
		for (int i = 0; i < stackSize; i++) {
			System.out.println(stack.top());
			stack.pop();
		}
	}

}
