package com.pp.hackerRank.ds;

import java.util.Scanner;

/**
 * <b>Source</b> <a href="https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem">Hacker Rank</a>
 * 
 * </br></br>
 * If you're new to linked lists, this is a great exercise for learning about
 * them. Given a pointer to the head node of a linked list, print its elements
 * in order, one element per line. If the head pointer is null (indicating the
 * list is empty), don’t print anything.
 * 
 * </br><b>Input Format</b></br>
 * 
 * The first line of input contains , the number of elements in the linked list.
 * The next lines contain one element each, which are the elements of the linked
 * list.
 * </br>
 * Note: Do not read any input from stdin/console. Complete the printLinkedList
 * function in the editor below.
 * 
 * </br><b>Constraints</b></br>
 * 
 * # 1 <= n <= 100
 * # 1 <= list[i] <= 1000, where list[i] is the i element of the linked list.
 * 
 * </br><b>Output Format</b></br>
 * 
 * Print the integer data for each element of the linked list to stdout/console
 * (e.g.: using printf, cout, etc.). There should be one element per line.
 * 
 * </br><b>Sample Input</b></br>
 * 
 * 2 
 * 16 
 * 13 
 * 
 * </br><b>Sample Output</b></br>
 * 
 * 16 
 * 13 
 * 
 * </br><b>Explanation</b></br>
 * 
 * There are two elements in the linked list. They are represented as 16 -> 13
 * -> NULL. So, the printLinkedList function should print 16 and 13 each in a
 * new line.
 *
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

	/**
	 * Complete printLinkedList function.
	 * 
	 * @param head
	 */
	static void printLinkedList(SinglyLinkedListNode head) {
		while (true) {
			System.out.println(head.data);
			if (head.next == null) {
				break;
			} else {
				head = head.next;
			}

		}
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

		printLinkedList(llist.head);

		scanner.close();
	}
}
