package cr.tec.struct;

import java.util.LinkedList;

/**
 * Created by Jimena on 10/26/16.
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

	public Order() {
		this.id = lastId + 1;
		lastId++;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	public boolean isPayed() {
		return payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
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

	@Override
	public int compareTo(Order o) {
		System.out.println(5665);
		System.out.println(this.type);
		return this.type.compareTo(o.getType());
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
