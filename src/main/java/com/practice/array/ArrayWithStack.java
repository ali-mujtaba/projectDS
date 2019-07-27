package com.practice.array;

/*
 * Program implementing Stack data structure using arrays
 * */

import java.util.Scanner;

class ArrayWithStack {

  private int myStack[], top = -1, capacity;
  private Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    ArrayWithStack arrayWithStack = new ArrayWithStack();
    arrayWithStack.initialize();

    while (true) {
      int action = arrayWithStack.getAction();
      if (action == 5) {
        break;
      }
      arrayWithStack.performAction(action);
    }
  }

  private void initialize() {
    System.out.println("Enter Stack Capacity: ");
    capacity = scanner.nextInt();
    myStack = new int[capacity];
  }

  private int getAction() {
    System.out.println("\nEnter your choice of action: \n 1. Push  2. Pop  3. Peek  4. Display  5. Exit");
    return scanner.nextInt();
  }

  private void performAction(int action) {
    switch (action) {
      case 1:
        push();
        break;

      case 2:
        pop();
        break;

      case 3:
        peek();
        break;

      case 4:
        display();
        break;

      default:
        System.out.println("Invalid action. Try Again\n");
        break;
    }
  }

  private void display() {
    if (top == -1) {
      System.out.println("Stack is empty.");
      return;
    }

    int currentTop = top;
    System.out.print("Stack: ");
    while (currentTop > -1) {
      System.out.print(myStack[currentTop] + " ");
      currentTop--;
    }
    System.out.println();
  }

  private void push() {
    if (isFull()) {
      System.out.println("Stack Overflow!");
      return;
    }

    top++;
    System.out.println("Enter element to be pushed to the stack: ");
    int newElement = scanner.nextInt();
    myStack[top] = newElement;
    display();
  }

  private void pop() {
    if (isEmpty()) {
      System.out.println("Stack is empty");
      return;
    }

    System.out.println("Element popped: " + myStack[top]);
    top--;
  }

  private void peek() {
    if (isEmpty()) {
      System.out.println("Stack is empty! ");
      return;
    }

    System.out.println("Element at top: " + myStack[top]);
  }

  private boolean isEmpty() {
    return top == -1;
  }

  private boolean isFull() {
    return top == capacity - 1;
  }
}
