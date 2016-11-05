package cr.tec.struct;

import cr.tec.struct.generic.GenericList;
import cr.tec.struct.generic.Node;

/**
 * Created by Jimena on 11/5/16.
 */
public class OrdersPriorityQueue extends GenericList<Order> implements Comparable<Order>{
	/*@Override
	public void addLast(Order newOrder){

		if(this.getHead() == null){
			this.addFirst(newOrder);
		} else {

			Nodo<Order> current = this.getHead();
			while (current.getNext() != null) {
				System.out.println(current.getNext().getData().compareTo(newOrder));
				if (current.getNext().getData().compareTo(newOrder) >= 1) {
					break;
				} else {
					current = current.getNext();
				}
			}
			newOrder.setNext(current.getNext());
			current.setNext(newNode);

		}

	}*/






	@Override
	public void addLast(Order newOrder) {
		Node<Order> newOrder1 = new Node<Order>(newOrder);
		addLast(newOrder1);
	}

	/* (non-Javadoc)
	 * @see Structures.GenericLinkedList#add(Structures.GenericNode)
	 */
	public void addLast(Node<Order> newOrder) {

		if (this.getHead()==null) {
			this.setHead(newOrder);}

		else if(this.getLenght()==1){
			if (getHead().getData().compareTo(newOrder.getData()) >= 1){
				Order newFirstOrder = newOrder.getData();
				addFirst(newFirstOrder);
				this.setLenght(this.getLenght()-1);

			}else{
				getHead().setNext(newOrder);
			}

		}

		else {

			Node<Order> current = this.getHead();
			while (current.getNext() != null) {
				if (current.getNext().getData().compareTo(newOrder.getData()) >= 1){
					break;
				} else {
					current = current.getNext();
				}
			}
			newOrder.setNext(current.getNext());
			current.setNext(newOrder);


		}

		this.setLenght(this.getLenght()+1);

	}


	public Order peek() {
		return getAt(0).getData();
	}

	public Order poll() {
		Order headOrder = getAt(0).getData();
		deleteAt(0);
		return headOrder;

	}

	@Override
	public int compareTo(Order o) {
		// TODO Auto-generated method stub
		return 0;
	}

}