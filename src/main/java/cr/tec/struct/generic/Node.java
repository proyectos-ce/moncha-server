package cr.tec.struct.generic;

import java.io.Serializable;
/**
 * 
 * @author Jimena
 *Main class Node that works as a container for the other structures
 * @param <T>
 */
public class Node<T> implements Serializable {
	private T data;
	private Node<T> next;
	private static final long serialVersionUID = -6452243518230709681L;


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
