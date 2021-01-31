package com.macmak.data_structures.list.linked_list;

/**
 * 
 * @author mayur.somani
 *
 * @param <T> data
 */
public class LinkedList<T> {

	private Node<T> head;

	/**
	 * 
	 * @param value
	 */
	public void insert(T value) {
		Node<T> n = new Node<>();
		n.data = value;
		if (head != null) {
			Node<T> tempNode = head;
			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}
			tempNode.next = n;
		} else {
			head = n;
		}
	}

	/**
	 * 
	 * @param index at which value is to be entered.
	 */
	public void insertAtStart(T value) {
		Node<T> n = new Node<>();
		n.data = value;
		if (head != null) {
			n.next = head;
		}
		head = n;
	}

	/**
	 * 
	 * @param index at which value is to be entered.
	 * @param value which needs to be entered.
	 */
	public void insertAtIndex(int index, T value) throws IndexOutOfBoundsException {
		Node<T> n = new Node<>();
		n.data = value;
		Node<T> tempNode;
		if (index > 0 && head != null && index < size()) {
			tempNode = head;
			while (tempNode.next != null) {
				if (index != 0) {
					index--;
					if (index != 0) {
						tempNode = tempNode.next;
					}
				} else {
					n.next = tempNode.next;
					tempNode.next = n;
					return;
				}
			}
		} else if (index < 0) {
			throw new IndexOutOfBoundsException("Index " + index + " is invalid!");
		} else if (index == 0) {
			insertAtStart(value);
			return;
		} else if (index == size()) {
			insert(value);
			return;
		}
		throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
	}

	public void delete(T value) {

	}

	public void deleteAt(int index) {

	}

	/**
	 * 
	 * @return size of LinkedList
	 */
	public int size() {
		int size = 0;
		Node<T> n;
		if (head != null) {
			n = head;
			while (n.next != null) {
				size++;
				n = n.next;
			}
			size++;
		} else {
			// No elements in linked-list
		}
		return size;
	}

	/**
	 * 
	 * <b>Prints:</b> data of LinkedList
	 */
	public void print() {
		Node<T> n;
		if (head != null) {
			n = head;
			while (n.next != null) {
				System.out.print(n.data + " ");
				n = n.next;
			}
			System.out.println(n.data + " ");
		} else {
			// No elements in linked-list
		}
	}
}
