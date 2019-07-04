package com.practice.linkedlist;

// Implementation of Linked List Operations

import java.util.Scanner;

public class LinkedList {
  static LinkedListNode head;

  public static void main(String[] args) {
    int c = 0;
    while (c != 8) {
      System.out.println("\nEnter your choice :-\n 1. insert 2. insert at position 3. insert at beginning 4. delete \n5. delete from position 6. delete from beginning 7. display list 8. exit");
      Scanner ll = new Scanner(System.in);
      c = ll.nextInt();
      switch (c) {
        case 1:
          insert();
          break;
        case 2:
          insertAt();
          break;
        case 3:
          insertAtBeg();
          break;
        case 4:
          delete();
          break;
        case 5:
          deleteFromPos();
          break;
        case 6:
          deleteFromBeg();
          break;
        case 7:
          display();
          break;
        case 8:
          break;
        default:
          System.out.println("Invalid option! Try Again!");
          break;
      }
    }
  }

  static void insert() {
    Scanner ll = new Scanner(System.in);
    System.out.println("Enter the value to be inserted: ");
    int d = ll.nextInt();
    LinkedListNode node = new LinkedListNode();
    node.data = d;
    if (head == null)
      head = node;
    else {
      LinkedListNode curr;
      curr = head;
      while (curr.next != null)
        curr = curr.next;
      curr.next = node;
    }
  }

  static void insertAt() {
    Scanner ll = new Scanner(System.in);
    System.out.println("Enter the value to be inserted: ");
    int d = ll.nextInt();
    System.out.println("Enter the position you want to insert at: ");
    int p = ll.nextInt();
    LinkedListNode node = new LinkedListNode();
    node.data = d;
    LinkedListNode curr = new LinkedListNode();
    curr = head;
    if (head == null)
      head = node;
    else if (p == 1) {
      node.next = head;
      head = node;
    } else {
      while (p > 2) {
        if (curr.next == null)
          break;
        curr = curr.next;
        p--;
      }
      node.next = curr.next;
      curr.next = node;
    }
  }

  static void insertAtBeg() {
    Scanner ll = new Scanner(System.in);
    System.out.println("Enter the element to be inserted: ");
    int d = ll.nextInt();
    LinkedListNode node = new LinkedListNode();
    node.data = d;
    if (head == null)
      head = node;
    else {
      node.next = head;
      head = node;
    }
  }

  static void display() {
    System.out.println("Linked List is as follows:-");
    if (head == null)
      System.out.println("List is empty!");
    else {
      LinkedListNode curr;
      curr = head;
      while (curr.next != null) {
        System.out.print(curr.data + " -> ");
        curr = curr.next;
      }
      System.out.println(curr.data);
    }
  }

  static void delete() {
    int flag = 0;
    Scanner ll = new Scanner(System.in);
    System.out.println("Enter the element to be deleted: ");
    int d = ll.nextInt();
    if (head == null)
      System.out.println("List is empty!");
    else if (head.next == null) {
      if (head.data == d) {
        flag = 1;
        head = null;
      }
    } else {
      LinkedListNode curr = new LinkedListNode();
      curr = head;
      if (head.data == d) {
        flag = 1;
        head = head.next;
      } else if (head.next.data == d) {
        flag = 1;
        head.next = head.next.next;
      } else {
        while (curr.next.next != null) {
          if (curr.next.data == d) {
            flag = 1;
            curr.next = curr.next.next;
            break;
          }
          curr = curr.next;
        }
      }
      if (flag == 1)
        System.out.println("Element found and deleted!");
      else {
        if (curr.next.data == d) {
          System.out.println("Element found and deleted!");
          curr.next = null;
        } else
          System.out.println("Element not found!");
      }
    }
  }

  static void deleteFromBeg() {
    if (head == null)
      System.out.println("List is empty!");
    else {
      System.out.println("Element removed: " + head.data);
      head = head.next;
    }
  }

  static void deleteFromPos() {
    Scanner ll = new Scanner(System.in);
    System.out.println("Enter the position you want to delete from: ");
    int p = ll.nextInt();
    LinkedListNode curr = new LinkedListNode();
    curr = head;
    if (head == null)
      System.out.println("List is empty!");
    else if (p == 1) {
      System.out.println("Element removed: " + head.data);
      head = head.next;
    } else {
      while (p > 2) {
        if (curr.next == null)
          break;
        curr = curr.next;
        p--;
      }
      System.out.println("Element removed: " + curr.next.data);
      curr.next = curr.next.next;
    }
  }
}