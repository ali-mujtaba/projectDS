package com.practice.linkedlist;

// Implementation of Circular Queue using Linked List

import java.util.Scanner;

public class CircularQueue {
  static LinkedListNode rear, front;

  public static void main(String[] args) {
    Scanner st = new Scanner(System.in);
    int c = 0;
    while (c != 4) {
      System.out.println("\nEnter your choice:-\n 1. Enqueue 2. Dequeue 3. Peek 4. Exit");
      c = st.nextInt();
      System.out.println();
      switch (c) {
        case 1:
          System.out.print("Enter the element to be pushed: ");
          int d = st.nextInt();
          enqueue(d);
          break;
        case 2:
          dequeue();
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

  static void enqueue(int d) {
    LinkedListNode linkedListNode = new LinkedListNode();
    linkedListNode.data = d;
    if (front == null) {
      rear = linkedListNode;
      front = linkedListNode;
    } else {
      rear.next = linkedListNode;
      rear = rear.next;
      rear.next = front;
    }

  }

  static void dequeue() {
    if (front == null) {
      System.out.println("Queue is empty!");
    } else {
      System.out.println("Element removed: " + front.data);
      if (front == rear)
        front = rear = null;
      else
        front = front.next;
    }
  }

  static void peek() {
    if (front == null)
      System.out.println("Queue is empty! ");
    else
      System.out.println("Element at front: " + front.data);
  }

  static void display() {
    LinkedListNode curr = new LinkedListNode();
    curr = front;
    System.out.print("Queue: ");
    if (front != null) {
      while (curr != rear) {
        System.out.print(curr.data + " -> ");
        curr = curr.next;
      }
      System.out.print(curr.data);
    }
    System.out.println();
  }
}