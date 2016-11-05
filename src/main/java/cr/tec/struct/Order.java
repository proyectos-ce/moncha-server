package cr.tec.struct;

import java.util.LinkedList;

/**
 * Created by Jimena on 10/26/16.
 */

/**
 * 
 * @author Jimena
 *Main class Order
 */
public class Order implements Comparable<Order> {
	private static int lastId = 0;
	private OrderType type;
	private int table;
	private int user;
	private LinkedList<Suborder> suborders;
	private String chef;
	private int id;
	private boolean completed;
	private boolean delivered;
	private boolean payed;
/**
 * Empty constructor for order
 */
	public Order() {
		this.id = lastId + 1;
		lastId++;
	}
/**
 * Determines if the order is complete
 * @return true or false according to the state of the orders
 */
	public boolean isCompleted() {
		return completed;
	}
/**
 * Sets if the order is complete or not
 * @param completed true or false according to the state of the order
 */
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
/**
 * Determines if the order has been delivered or not
 * @return true or false according to the state of the order
 */
	public boolean isDelivered() {
		return delivered;
	}
/**
 *  Sets if the order has been delivered or not
 * @param delivered
 */
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
/**
 * Determines if the order has been payed or not
 * @return true or false according to the state of the order
 */
	public boolean isPayed() {
		return payed;
	}
/**
 *  Sets if the order has been payed or not
 * @param delivered
 */
	public void setPayed(boolean payed) {
		this.payed = payed;
	}
	
/**
 * Method that compares the orders to make the priority queue
 * @param o  order which is going to be compared with
 * @return if the order has major category or not
 */
	@Override
	public int compareTo(Order o) {
		System.out.println(5665);
		System.out.println(this.type);
		return this.type.compareTo(o.getType());
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}

	public int getTable() {
		return table;
	}

	public void setTable(int table) {
		this.table = table;
	}


	public LinkedList<Suborder> getSuborders() {
		return suborders;
	}

	public void setSuborders(LinkedList<Suborder> suborders) {
		this.suborders = suborders;
	}

	public String getChef() {
		return chef;
	}

	public void setChef(String chef) {
		this.chef = chef;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}
}
