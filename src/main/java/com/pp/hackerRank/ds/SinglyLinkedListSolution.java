package com.pp.hackerRank.ds;

import java.util.Scanner;

/**
 * <b>Source</b> 
 * </br>1. <a href="https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem">Hacker Rank: Print the Elements of a Linked List</a>
 * </br>2. <a href="https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem">Hacker Rank: Insert a Node at the Tail of a Linked List</a>
 */
public class SinglyLinkedListSolution {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	// Complete the printLinkedList function below.
	static void printLinkedList(SinglyLinkedListNode head) {
		
		if(head == null){
			return;
		}
		while (true) {
			System.out.println(head.data);
			if (head.next == null) {
				break;
			} else {
				head = head.next;
			}
		}
	}
	
    // Complete the insertNodeAtTail function below.
	static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

		SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
		
        if (head == null) {
            head = newNode;
        } else {
            SinglyLinkedListNode lastNode = head;
            SinglyLinkedListNode nextNode = head.next;
            while (true) {
                if (nextNode == null) {
                    break;
                }
                lastNode = nextNode;
                nextNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        return head;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SinglyLinkedList llist = new SinglyLinkedList();

		int llistCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < llistCount; i++) {
			int llistItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			llist.insertNode(llistItem);
		}

		System.out.println("======");
		printLinkedList(llist.head);
		
		llist.head = insertNodeAtTail(llist.head, 12);
		System.out.println("======");
		printLinkedList(llist.head);

		scanner.close();
	}
}
