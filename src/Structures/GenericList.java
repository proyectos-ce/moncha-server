package Structures;


import java.io.Serializable;
import java.util.Iterator;

public class GenericList<T> implements Iterable<T>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6452243518230709681L;
	private Node<T> head;
	private int lenght;
	// private Iterator<T> it;

	public GenericList() {
		this.head = null;
		this.lenght = 0;
	}

	public void addFirst(T data) {
		if (this.head == null) {
			this.head = new Node<T>(data);
		} else {
			Node<T> newNodo = new Node<T>(data);
			newNodo.setNext(this.head);
			this.head = newNodo;
		}
		this.lenght++;
	}

	public void addLast(T data) {
		if (this.head == null) {
			addFirst(data);
		} else {
			Node<T> temp = this.head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			Node<T> newNodo = new Node<T>(data);
			temp.setNext(newNodo);

			this.lenght++;
		}
	}

	public void deleteNode(T data) {
		if (this.head == null) {
			System.out.println("La lista est� vac�a");
		} else if (getHead().equals(data)) {
			deleteFirst();
		} else {
			for (int i = 0; i < this.lenght; i++) {
				if (i == this.lenght - 1) {
					deleteLast();
				} else if (getAt(i).equals(data)) {
					getAt(i - 1).setNext(getAt(i).getNext());
				}
			}
		}
	}

	public void deleteFirst() {
		if (this.head == null) {
			System.out.println("La lista est� vac�a");
		} else {
			if (this.lenght > 1) {
				this.head = this.head.getNext();
			} else {
				this.head = null;
			}
			this.lenght--;
		}
	}

	public void deleteLast() {
		if (this.head == null) {
			System.out.println("La lista est� vac�a");
		} else {
			if (this.lenght > 1) {
				Node<T> temp = this.head;
				while (temp.getNext().getNext() != null) {
					temp = temp.getNext();
				}
				temp.setNext(null);
			} else {
				this.head = null;
			}
			this.lenght--;
		}
	}

	public void deleteAt(int index) {
		if (this.head == null) {
			System.out.println("La lista est� vac�a");
		} else if (index == 0) {
			deleteFirst();
		} else if (index == this.lenght - 1) {
			deleteLast();
		} else if (index > 0 && index < this.lenght - 1) {
			Node<T> temp = this.head;
			for (int i = 0; i < this.lenght - 1; i++) {
				if (index == i + 1) {
					temp.setNext(temp.getNext().getNext());
					this.lenght--;
					break;
				}
				temp = temp.getNext();
			}
		} else {
			System.out.println("Index out of range");
		}
	}

	public void swap(int i, int j) {
		if (i >= 0 && i < this.lenght && j >= 0 && j < this.lenght) {
			T temp = getAt(i).getData();
			setAt(i, getAt(j).getData());
			setAt(j, temp);
		} else {
			System.out.println("Index out of range");
		}

	}

	public Node<T> getAt(int index) {
		if (this.head == null) {
			System.out.println("La lista est� vac�a");
		} else {
			if (index >= 0 && index < this.lenght) {
				Node<T> temp = this.head;
				for (int i = 0; i < this.lenght; i++) {
					if (index == i) {
						return temp;
					}
					temp = temp.getNext();
				}

			}
		}
		return null;
	}

	public void setAt(int index, T data) {
		if (this.head == null) {
			System.out.println("La lista est� vac�a");
		} else {
			if (index >= 0 && index < this.lenght) {
				Node<T> temp = this.head;
				for (int i = 0; i < this.lenght; i++) {
					if (index == i) {
						temp.setData(data);
					}
					temp = temp.getNext();
				}
			}
		}
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < getLenght(); i++) {
			result += ((i + 1) + ". " + getAt(i).getData().toString());
		}
		return result;
	}

	public void printList() {
		if (this.head == null) {
			System.out.println("Lista Vac�a");
		} else {
			Node<T> temp = this.head;
			while (temp != null) {
				System.out.println(temp.getData());
				temp = temp.getNext();
			}

		}
	}


	@Override
	public Iterator<T> iterator() {
		Iterator<T> newItetaror = new SimpleIterator<>(this);
		return newItetaror;
	}

}
