package com.macmak.data_structures.list.linked_list;

public class Main {

	public static void main(String[] args) {

		LinkedList<Integer> linkedList = new LinkedList<>();

		// Insert
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(4);

		// InsertAtIndex
		linkedList.insertAtIndex(3, 5);
		linkedList.insertAtIndex(0, 0);
		linkedList.insertAtIndex(3, 3);
		linkedList.insertAtIndex(3, -3);

		// InsertAtStart
		linkedList.insertAtStart(-1);
		linkedList.insertAtStart(-2);
		linkedList.insertAtStart(-3);

		// Delete
		// TODO
		// Print
		linkedList.print();

	}
}
