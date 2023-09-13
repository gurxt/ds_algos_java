package linkedLists;

public class LinkedList {
	private Node head;
	private Node tail;
	private int length;
	
	class Node {
		int value;
		Node next;
		
		Node(int value) {
			this.value = value;
		}
	}
	
	public LinkedList(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}
	
	public void printList() {
		if (length == 0) return;
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
	}
	
	public void getHead() { System.out.println("Head: " + (head != null ? head.value : null )); }
	
	public void getTail() { System.out.println("Tail: " + (tail != null ? tail.value : null )); }
	
	public void getLength() { System.out.println("Length: " + length); }
	
	public Node get(int index) {
		if (index >= length || index < 0) return null; // ensure the desires index is in bounds.
	
		Node temp = head;
		
		for (int i=0; i < index; i++) {
			temp = temp.next;
		}
		
		return temp;
	}
	
	public boolean set(int index, int value) {
		Node temp = get(index);
		if (temp != null) {
			temp.value = value;
			return true;
		}
		return false;
	}
	
	public boolean insert(int index, int value) {
		if (index > length || index < 0) return false;
		if (index == 0) { prepend(value); return true; }
		if (index == length) { append(value); return true; }
	
		Node newNode = new Node(value);
		Node temp = get(index - 1);
		newNode.next = temp.next;
		temp.next = newNode;
		length++;
		return true;
	}
	
	public Node remove(int index) {
		if (index < 0 || index >= length) return null;
		if (index == 0) return removeFirst();
		if (index == length - 1) return removeLast();

		Node prev = get(index - 1);
		Node temp = prev.next;
		
		prev.next = temp.next;
		temp.next = null;
		length--;
		
		return temp;
	}
	
	public void reverse() {
		Node temp = head;
		head = tail;
		tail = temp;
		
		Node after = temp.next;
		Node before = null;
		
		for (int i=0; i < length; i++) {
			after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
		}
		
	}
	
	public void append(int value) {
		Node newNode = new Node(value);
		
		if (length == 0) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}			
		
		length++;
	}
	
	public void prepend(int value) {
		Node newNode = new Node(value);
		
		if (length == 0) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		
		length++;
	}
	
	public Node removeLast() {
		// we don't know if we are at the end of the array until we run into a node with a null value.
		if (length == 0) return null;
		
		Node pre = head;
		Node temp = head;
		
		while (temp.next != null) {
			pre = temp;
			temp = temp.next;
		}

		tail = pre;
		tail.next = null;
		length--;
		if (length == 0) {
			head = null;
			tail = null;
		}
		return temp;
	}
	
	public Node removeFirst() {
		if (length == 0) return null;
	
		Node temp = head; // store reference for return variable
		head = head.next;
		temp.next = null;
		length--;
		
		if (length == 0) {
			tail = null;
		}
		
		return temp;
	}
	
}