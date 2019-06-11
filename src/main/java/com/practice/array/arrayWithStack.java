// JAVA program implementing Stack data structure

import java.util.*;
class arrayWithStack {
	int starr[], top = -1, cap;
	Scanner stsc = new Scanner(System.in);
	public static void main(String[] args) {

		arrayWithStack obj = new arrayWithStack();
		obj.stackDef();
		obj.stackActs();
	}

	void stackDef() {
		System.out.println("Enter the stack capacity: ");
		cap = stsc.nextInt();
		starr = new int[cap];
	}
	void stackActs() {
		System.out.println("\nEnter your choice of action: \n 1. Push  2. Pop  3. Peek  4. Display  5. Exit");
		int c = stsc.nextInt();

		switch (c) {
		case 1: push();
			break;

		case 2: pop();
			break;

		case 3: peek();
			break;

		case 4: dispStack();
			break;

		case 5: break;
		default: System.out.println("Invalid choice. Try Again\n");
			break;
		}

		if (c != 5)
			stackActs();
	}

	void dispStack() {
		int ttop = top;
		System.out.print("Stack: ");
		while (ttop > -1 && ttop < cap) {
			System.out.print(starr[ttop] + " ");
			ttop--;
		}
		System.out.println();
	}

	void push() {

		if (top >= (cap - 1))
			System.out.println("Stack Overflow!");
		else {
			top++;
			System.out.println("Enter element to be pushed to the stack: ");
			int x = stsc.nextInt();
			starr[top] = x;
			dispStack();
		}
	}

	void pop() {
		if (top == -1)
			System.out.println("Stack Underflow!");
		else {
			System.out.println("Element popped: " + starr[top]);
			top--;
			dispStack();
		}
	}

	void peek() {
		int ttop = top;
		if (ttop > -1 && ttop < cap)
			System.out.println("Element at top: " + starr[top]);

		if (top == -1)
			System.out.println("Stack is empty! ");

	}
}