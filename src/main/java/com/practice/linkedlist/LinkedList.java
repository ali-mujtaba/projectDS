package com.practice.linkedlist;

// Implementation of Linked List Operations

import java.util.Scanner;

public class LinkedList {
  private static LinkedListNode head;

  public static void main(String[] args) {
    int choice = 0;
    while (choice != 8) {
      System.out.println("\nEnter your choice :-\n 1. insert 2. insert at position 3. insert at beginning 4. delete \n5. delete from position 6. delete from beginning 7. display list 8. exit");
      Scanner scanner = new Scanner(System.in);
      choice = scanner.nextInt();
      switch (choice) {
        case 1:
          insert();
          break;
        case 2:
          insertAt();
          break;
        case 3:
          insertAtBeginning();
          break;
        case 4:
          delete();
          break;
        case 5:
          deleteFromPosition();
          break;
        case 6:
          deleteFromBeginning();
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

  private static void insert() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the value to be inserted: ");
    int data = scanner.nextInt();
    LinkedListNode node = new LinkedListNode(data);

    if (isEmpty()) {
      head = node;
    } else {
      LinkedListNode current = head;

      while (current.next != null) {
        current = current.next;
      }

      current.next = node;
    }
  }

  private static void insertAt() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the value to be inserted: ");
    int data = scanner.nextInt();
    System.out.println("Enter the position you want to insert at: ");
    int position = scanner.nextInt();
    LinkedListNode node = new LinkedListNode(data);
    LinkedListNode curr = head;
    // TODO revisit this logic, looks too complex
    if (isEmpty()) {
      head = node;
    } else if (position == 1) {
      node.next = head;
      head = node;
    } else {
      while (position > 2) {
        if (curr.next == null) {
          break;
        }
        curr = curr.next;
        position--;
      }
      node.next = curr.next;
      curr.next = node;
    }
  }

  private static void insertAtBeginning() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the element to be inserted: ");
    int data = scanner.nextInt();
    LinkedListNode node = new LinkedListNode(data);

    if (isEmpty()) {
      head = node;
    } else {
      node.next = head;
      head = node;
    }
  }

  private static void display() {
    if (isEmpty()) {
      System.out.println("List is empty!");
    } else {
      System.out.println("Linked List is as follows:-");
      LinkedListNode current = head;

      while (current != null) {
        System.out.print(current.data + " -> ");
        current = current.next;
      }
    }
  }

  private static void delete() {
    // TODO revisit logic, why is this soo complex
    int flag = 0;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the element to be deleted: ");
    int element = scanner.nextInt();
    if (isEmpty()) {
      System.out.println("List is empty!");
    } else if (head.next == null) {
      if (head.data == element) {
        flag = 1;
        head = null;
      }
    } else {
      LinkedListNode curr = head;
      if (head.data == element) {
        flag = 1;
        head = head.next;
      } else if (head.next.data == element) {
        flag = 1;
        head.next = head.next.next;
      } else {
        while (curr.next.next != null) {
          if (curr.next.data == element) {
            flag = 1;
            curr.next = curr.next.next;
            break;
          }
          curr = curr.next;
        }
      }
      if (flag == 1) {
        System.out.println("Element found and deleted!");
      } else {
        if (curr.next.data == element) {
          System.out.println("Element found and deleted!");
          curr.next = null;
        } else {
          System.out.println("Element not found!");
        }
      }
    }
  }

  private static void deleteFromBeginning() {
    if (isEmpty()) {
      System.out.println("List is empty!");
    } else {
      System.out.println("Element removed: " + head.data);
      head = head.next;
    }
  }

  private static void deleteFromPosition() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the position you want to delete from: ");
    int position = scanner.nextInt();
    LinkedListNode curr = head;
    // TODO revisit too complex
    if (isEmpty()) {
      System.out.println("List is empty!");
    } else if (position == 1) {
      System.out.println("Element removed: " + head.data);
      head = head.next;
    } else {
      while (position > 2) {
        if (curr.next == null) {
          break;
        }
        curr = curr.next;
        position--;
      }
      // TODO it will throw NullPointerException in the below linw
      System.out.println("Element removed: " + curr.next.data);
      curr.next = curr.next.next;
    }
  }

  private static boolean isEmpty() {
    return head == null;
  }
}
