package Structures;

import java.util.List;
import java.util.NoSuchElementException;


/**
 * @author gsegura96
 *
 * @param <T>
 */
public class SimpleIterator<T> implements java.util.Iterator<T>, List<T>{
	private Node<T> head;
	private Node<T> current;

	/**
	 * Constructs an empty generic linked list
	 */
	public SimpleIterator() {
		super();
		this.head = new Node<T>();
		this.current = this.head;
	}
	public SimpleIterator(GenericList<T> importedList) {
		super();
		this.head = new Node<T>();
		this.current = this.head;
		this.importList(importedList);
	}

	/**
	 * Returns the head node of the list.
	 * @return Head node
	 */
	private Node<T> getHead() {
		return head;
	}

	/**
	 * Sets the head node of the list
	 * @param head New head node.
	 */
	private void setHead(Node<T> head) {
		head.setNext(this.getHead());
		this.head = head;
	}

	/**
	 * Adds a new node at the end of the list, with the specified element.
	 * @param data Element to be added.
	 */
	private void add(T data) {
		Node<T> newNode = new Node<>(data);
		this.add(newNode);
	}

	/**
	 * Adds the specified node at the end of the list.
	 * @param newNode
	 */
	private void add(Node<T> newNode) {
		if (this.head != null) {
			this.getLast().setNext(newNode);
		} else {
			this.head = newNode;
		}
	}

	/**
	 * Returns the last node of the list.
	 * @return The last node of the list
	 */
	private Node<T> getLast() {
		Node<T> current = head;
		if (head != null) {
			while (current.getNext() != null) {
				current = current.getNext();
			}

		}
		return current;
	}

	/**
	 * Returns the current length of the list. 
	 * @return The current length of the list
	 */
	public int getSize() {
		Node<T> current = head;
		int cont = 0;
		while (current != null) {
			cont++;
			current = current.getNext();
		}
		return cont;
	}

	/**
	 * Checks if the list is empty.
	 * @return true if it's empty, else false.
	 */
	public boolean isEmpty() {
		return head == null;

	}

	@Override
	public String toString() {
		String result = "(";
		Node<T> current = this.getHead();
		while (current != null) {
			result += current.getData().toString() + ", ";
			current = current.getNext();
		}
		result += ")";
		return result;
	}

	@Override
	public boolean hasNext() {
		if(this.current == null){
			throw new NoSuchElementException();
		}
		
		boolean result= false;
		if(current.getNext() != null){
			result = true;
		}
		return result;
	}

	@Override
	public T next() {
		T result= null;
		if(this.hasNext()){
			this.current = current.getNext();
			result = current.getData();
		}
		return result;
	}
	
	@Override
	public void remove() {
		if(this.hasNext()){
			this.head.setNext(head.getNext().getNext());
		}	}
	private void importList(GenericList<T> importedList){
		Node<T> current =  importedList.getHead();
		while(current != null){
			this.add(current.getData());
			current = current.getNext();
		}
	}
}
