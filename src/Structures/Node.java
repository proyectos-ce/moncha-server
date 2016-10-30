package Structures;

public class Node<T> {
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
