package Structures;

public class OrdersPriorityQueue extends GenericList<Order> {
	@Override
	public void add(Item newItem) {
		GenericNode<Item> newNode = new GenericNode<>(newItem);
		add(newNode);
	}


	@Override

	public void add(GenericNode<Item> newNode) {

		if (isEmpty()) {
			setHead(newNode);
		} else {

			GenericNode<Item> current = getHead();
			while (current.getNext() != null) {
				System.out.println(current.getNext().getData().compareTo(newNode.getData()));
				if (current.getNext().getData().compareTo(newNode.getData()) >= 1) {
					break;
				} else {
					current = current.getNext();
				}
			}
			newNode.setNext(current.getNext());
			current.setNext(newNode);

		}

	}


	public Item peek() {
		return getAtPosition(0);
	}

	public Item poll() {
		Item headItem = getAtPosition(0);
		deleteAtPosition(0);
		return headItem;
		
	}
	
}
