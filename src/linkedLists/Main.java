package linkedLists;

public class Main {
	
	public static void main(String[] args) {
		Main main = new Main();
		LinkedList myLinkedList = new LinkedList(4);
	
		//main.testRemoveFirst(myLinkedList, 1);
		main.appendElements(myLinkedList, 8);
		myLinkedList.printList();
		System.out.println();
//		System.out.println("Remove First: " + myLinkedList.removeFirst().value);
//		System.out.println("Remove Last: " + myLinkedList.removeLast().value);
//		System.out.println(myLinkedList.get(0) == null ? "Out of bounds" : "Node @ index 0: " + myLinkedList.get(0).value);
//		System.out.println(myLinkedList.get(-1) == null ? "Out of bounds" : "Node @ index -1: " + myLinkedList.get(-1).value);
//		System.out.println(myLinkedList.get(10) == null ? "Out of bounds" : "Node @ index 10: " + myLinkedList.get(10).value);
		
		myLinkedList.set(0, 100);
		myLinkedList.set(7, 100);
	
		myLinkedList.insert(2, 3);
		myLinkedList.remove(2);
		myLinkedList.reverse();
		
		myLinkedList.getHead();
		myLinkedList.getTail();
		myLinkedList.getLength();
		myLinkedList.printList();
	}
	
	public void appendElements(LinkedList myLinkedList, int length) {
		for (int i=1; i < length; i++) {
			myLinkedList.append((int) (Math.random() * 10));
		}
	}
}
