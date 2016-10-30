package Structures;

/**
 * @author gsegura96
 *
 * @param <T>
 */
public class SimpleLinkedList<T> {
	private GenericNode<T> head;

	/**
	 * Constructs an empty generic linked list
	 */
	public SimpleLinkedList() {
		super();
	}

	/**
	 * Returns the head node of the list.
	 * @return Head node
	 */
	public GenericNode<T> getHead() {
		return head;
	}

	/**
	 * Sets the head node of the list
	 * @param head New head node.
	 */
	public void setHead(GenericNode<T> head) {
		head.setNext(this.getHead());
		this.head = head;
	}

	/**
	 * Adds a new node at the end of the list, with the specified element.
	 * @param data Element to be added.
	 */
	public void add(T data) {
		GenericNode<T> newNode = new GenericNode<>(data);
		this.add(newNode);
	}

	/**
	 * Adds the specified node at the end of the list.
	 * @param newNode
	 */
	public void add(GenericNode<T> newNode) {
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
	private GenericNode<T> getLast() {
		GenericNode<T> current = head;
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
		GenericNode<T> current = head;
		int cont = 0;
		while (current != null) {
			cont++;
			current = current.getNext();
		}
		return cont;
	}

	/**
	 * Returns the element at the specified position.
	 * @param position Index of the element to check.
	 * @return The element at the specified position.
	 */
	public T getAtPosition(int position) {
		return this.getNodeAtPosition(position).getData();
	}

	/**
	 * Returns the node at the specified position.
	 * @param position Index of the node to check.
	 * @return The node at the specified position.
	 */
	public GenericNode<T> getNodeAtPosition(int position) {
		GenericNode<T> current = head;
		GenericNode<T> result = null;
		int cont = 0;

		if (this.checkPosition(position)) {
			while (cont < position) {
				current = current.getNext();
				cont++;
			}
			result = current;
		}

		return result;
	}

	/**
	 * Inserts the specified element at the specified position.
	 * @param data Element to be inserted.
	 * @param position Index where the element will be inserted.
	 * @return true if the element was correctly inserted, else false.
	 */
	public boolean insertAtPosition(T data, int position) {
		GenericNode<T> newNode = new GenericNode<>(data);
		return this.insertAtPosition(newNode, position);
	}

	/**
	 * Inserts the specified node at the specified position.
	 * @param newNode Node to be inserted.
	 * @param position Index where the element will be inserted.
	 * @return true if the element was correctly inserted, else false.
	 */
	public boolean insertAtPosition(GenericNode<T> newNode, int position) {
		GenericNode<T> current = head;
		int cont = 0;
		boolean result = false;
		if (this.checkPosition(position)) {
			if (position == 0) {
				this.insertAtBeggining(newNode);
				result = true;
			} else {
				while (cont < position) {
					current = current.getNext();
					cont++;
				}
				newNode.setNext(current.getNext());
				current.setNext(newNode);
				result = true;
			}
		}
		return result;
	}

	/**
	 * Deletes and returns the node at the specified position.
	 * @param position Index of the ode to be deleted.
	 * @return The element of the deleted node.
	 */
	public T deleteAtPosition(int position) {
		GenericNode<T> current = head;
		T result = null;
		if (this.checkPosition(position)) {
			if (position == 0) {
				result = head.getData();
				head = head.getNext();

			} else if (position == this.getSize() - 1) {
				result = deleteLast();
			}

			else {
				current = this.getNodeAtPosition(position - 1);
				result = current.getNext().getData();
				current.setNext(current.getNext().getNext());
			}

		}
		return result;
	}

	/**
	 * Deletes the last node and returns it's current element.
	 * @return The deleted node element.
	 */
	public T deleteLast() {
		GenericNode<T> current = head;
		GenericNode<T> prev = head;
		T result = null;
		if (current.getNext() == null) {
			result = current.getData();
			head = null;

		} else {
			while (current.getNext() != null) {
				prev = current;
				current = current.getNext();
				result = current.getData();
			}
			prev.setNext(null);

		}
		return result;
	}

	/**
	 * Checks if the specified number is a valid index for the list.
	 * @param position Index to check. 
	 * @return true if it's a valid number, else false.
	 */
	private boolean checkPosition(int position) {
		return position >= 0 && position < this.getSize();
	}

	/**
	 * Inserts the specified element at the first item position.
	 * @param data Element to be inserted.
	 */
	public void insertAtBeggining(T data) {
		GenericNode<T> newNode = new GenericNode<>(data);
		this.insertAtBeggining(newNode);
	}

	/**
	 * Inserts The specified node at the first item position.
	 * @param newNode Node to be inserted.
	 */

	public void insertAtBeggining(GenericNode<T> newNode) {
		newNode.setNext(this.head);
		this.head = newNode;
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
		GenericNode<T> current = this.getHead();
		while (current != null) {
			result += current.getData().toString() + ", ";
			current = current.getNext();
		}
		result += ")";
		return result;
	}

}
