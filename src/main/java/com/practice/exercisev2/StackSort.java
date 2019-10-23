import java.util.*;

public class StackSort {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(6);
		stack.push(3);
		stack.push(7);
		stack.push(8);
		stack.push(1);
		System.out.println("Stack before sort: " + stack);
		stack = sortStack(stack);
		System.out.println("Stack after sort: " + stack);
		System.out.println("Top: " + stack.peek());
	}

	static Stack<Integer> sortStack(Stack<Integer> stack) {
		Stack<Integer> bufferStack = new Stack<Integer>();

		while (!stack.isEmpty()) {
			int element = stack.pop();
			while (!bufferStack.isEmpty() && bufferStack.peek() > element) {
				stack.push(bufferStack.pop());
			}
			bufferStack.push(element);
		}
		return bufferStack;
	}
}