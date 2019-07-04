package com.practice.array;

// Implementation of Circular Queue using array

import java.util.Scanner;

class ArrayCircularQueue {
  int cqueue[], front, rear, size;
  Scanner cq = new Scanner(System.in);

  public static void main(String[] args) {
    ArrayCircularQueue acq = new ArrayCircularQueue();
    acq.cqueueDef();
    acq.cqueueOps();
  }

  void cqueueDef() {
    System.out.println("Enter the size of the queue: ");
    size = cq.nextInt();
    front = rear = -1;
    cqueue = new int[size];
  }

  void cqueueOps() {

    System.out.println("\nEnter your choice of operation: \n 1. Enqueue  2. Dequeue  3. Peek  4. Display  5. Exit");
    int c = cq.nextInt();
    System.out.println();
    switch (c) {
      case 1:
        enqueue();
        break;

      case 2:
        dequeue();
        break;

      case 3:
        peek();
        break;

      case 4:
        dispQueue();
        break;

      case 5:
        break;
      default:
        System.out.println("Invalid choice. Try Again\n");
        break;
    }

    if (c != 5)
      cqueueOps();
  }

  void enqueue() {
    if (front == -1)
      front = rear = 0;
    if (front == 0) {
      if (rear == size)
        System.out.println("Queue is Full!");

      else {
        System.out.println("Enter the element to be inserted: ");
        int x = cq.nextInt();
        cqueue[rear] = x;
        rear++;
      }
    } else {
      if ((rear % size) == front)
        System.out.println("Queue is Full!");
      else {
        System.out.println("Enter the element to be inserted: ");
        int x = cq.nextInt();
        cqueue[rear % size] = x;
        rear++;
      }
    }
  }

  void dequeue() {
    if (front == rear)
      System.out.println("Queue Empty!");
    else {
      System.out.println("Element removed: " + cqueue[front % size]);
      front++;

      if (front == rear)
        front = rear = -1;
    }

  }

  void peek() {
    if (front == rear)
      System.out.println("Queue Empty!");
    else
      System.out.println("Element at Front: " + cqueue[front % size]);
  }

  void dispQueue() {
    int tf = front;
    System.out.print("Queue: ");
    if (front == 0) {
      while (tf < size) {
        System.out.print(cqueue[tf % size] + " ");
        tf++;
      }
    } else {
      while (tf != rear) {
        System.out.print(cqueue[tf % size] + " ");
        tf++;
      }
    }
    System.out.println();
  }
}