package Structures;

import java.io.Serializable;

public class Node<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4724696687378023792L;
	private T data;
	private Node<T> next;

	public Node() {
		this.data = null;
		this.next = null;
		
	}
	
	public Node(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T dato) {
		this.data = dato;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

}
