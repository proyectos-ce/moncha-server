package cr.tec.struct;

import cr.tec.struct.generic.GenericList;

import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Created by Jimena on 10/26/16.
 */
/**
 * 
 * @author Jimena
 *Main class table
 */
public class Table {
	private GenericList<User> users;
	private LinkedList<Order> orders;
	private int id;
/**
 * Constructor that takes the number of table
 * @param id
 */
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
/**
 * Deletes the clients of the users of the tables
 */
	public void clean() {
		this.users= new GenericList<User>();
		this.orders = new LinkedList<Order>();
	}
}