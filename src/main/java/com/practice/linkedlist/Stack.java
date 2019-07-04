package com.practice.linkedlist;

// Implementation of Stack using Linked List

import java.util.Scanner;

public class Stack {
  static LinkedListNode top;

  public static void main(String[] args) {
    Scanner st = new Scanner(System.in);
    int c = 0;
    while (c != 4) {
      System.out.println("\nEnter your choice:-\n 1. Push 2. Pop 3. Peek 4. Exit");
      c = st.nextInt();
      System.out.println();
      switch (c) {
        case 1:
          System.out.print("Enter the element to be pushed: ");
          int d = st.nextInt();
          push(d);
          break;
        case 2:
          pop();
          break;
        case 3:
          peek();
          break;
        case 4:
          break;
        default:
          System.out.println("Invalid input! Try Again. ");
          break;
      }
      display();
    }
  }

  static void push(int d) {
    LinkedListNode node = new LinkedListNode();
    node.data = d;
    if (top == null)
      top = node;
    else {
      node.next = top;
      top = node;
    }

  }

  static void pop() {
    if (top == null) {
      System.out.println("Stack Underflow!");
    } else {
      System.out.println("Element popped: " + top.data);
      top = top.next;
    }

  }

  static void peek() {
    if (top == null)
      System.out.println("Stack is empty! ");
    else
      System.out.println("Element at top: " + top.data);
  }

  static void display() {
    LinkedListNode curr = new LinkedListNode();
    curr = top;
    System.out.print("Stack: ");
    if (top != null) {
      while (curr.next != null) {
        System.out.print(curr.data + " -> ");
        curr = curr.next;
      }
      System.out.print(curr.data);
    }
    System.out.println();
  }
}