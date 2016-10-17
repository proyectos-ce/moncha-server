package Structures;

public class OrdersPriorityQueue extends GenericList<Order> implements Comparable<Order>{
	/*@Override
	public void addLast(Order newOrder){

		if(this.getHead() == null){
			this.addFirst(newOrder);
		} else {

			Nodo<Order> current = this.getHead();
			while (current.getNext() != null) {
				System.out.println(current.getNext().getDato().compareTo(newOrder));
				if (current.getNext().getDato().compareTo(newOrder) >= 1) {
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
		Nodo<Order> newOrder1 = new Nodo<Order>(newOrder);
		addLast(newOrder1);
	}

	/* (non-Javadoc)
	 * @see Structures.GenericLinkedList#add(Structures.GenericNode)
	 */
	@Override

	public void addLast(Nodo<Order> newOrder) {
		
		if (this.getHead()==null) {
			System.out.println(newOrder.getDato().getOrderPriority());
			this.setHead(newOrder);}
		
		else if(this.getLenght()==1){
			System.out.println("test" + getHead().getDato().compareTo(newOrder.getDato()));
			if (getHead().getDato().compareTo(newOrder.getDato()) >= 1){
				Order newFirstOrder = new Order(newOrder.getDato().getOrderPriority(), newOrder.getDato().getTable(), newOrder.getDato().getDishes(), newOrder.getDato().getOrderTime());
				addFirst(newFirstOrder);
				this.setLenght(this.getLenght()-1);
				
			}else{
				getHead().setNext(newOrder);
			}
					
		}
		
		else {
			
			Nodo<Order> current = this.getHead();
			while (current.getNext() != null) {
				System.out.println(current.getNext().getDato().compareTo(newOrder.getDato()));
				if (current.getNext().getDato().compareTo(newOrder.getDato()) >= 1){
					System.out.println(4444);
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
		return getAt(0).getDato();
	}

	public Order poll() {
		Order headOrder = getAt(0).getDato();
		deleteAt(0);
		return headOrder;
		
	}
	
	@Override
	public String toString(){
		String result = "";
		System.out.println("largo de ordenes " + this.getLenght() );
		for(int i=0; i < this.getLenght(); i++){
			result += ("Orden " + (i+1)+ "\n"+ this.getAt(i).getDato().getDishes().toString())+"\n";
		}
		return result;
	}

	@Override
	public int compareTo(Order o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
