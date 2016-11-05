package cr.tec.struct;

import cr.tec.struct.generic.GenericList;

import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Created by Jimena on 10/26/16.
 */

public class Table {
	private GenericList<User> users;
	private LinkedList<Order> orders;
	private int id;

	public Table(int id){
		this.id = id;
		this.users= new GenericList<User>();
		this.orders = new LinkedList<Order>();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LinkedList<Order> getOrders() {
		return orders;
	}

	public LinkedList<Order> getOrders (OrderType type) {
		return this.getOrders().stream().filter(order -> order.getType() == type).collect(Collectors.toCollection(LinkedList::new));
	}

	public void clean() {
		this.users= new GenericList<User>();
		this.orders = new LinkedList<Order>();
	}
}