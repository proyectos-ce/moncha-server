package cr.tec.struct.generic;

/**
 * Created by joseph on 10/26/16.
 */

public class Nodo<T> {
	private T dato;
	private Nodo<T> next;

	public Nodo() {
		this.dato = null;
		this.next = null;

	}

	public Nodo(T data) {
		super();
		this.dato = data;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public Nodo<T> getNext() {
		return next;
	}

	public void setNext(Nodo<T> next) {
		this.next = next;
	}

}