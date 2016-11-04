package cr.tec.struct;

import java.util.LinkedList;

/**
 * Created by Jimena on 10/26/16.
 */


public class Order implements Comparable<Order> {
	private OrderType type;
	private int table;
	private LinkedList<Suborder> suborders;


	public Order(OrderType orderPriority, int table, LinkedList<Suborder> suborders, long time) {
		this.type = orderPriority;
		this.suborders = suborders;
		this.table = table;
	}

	public Order() {
		super();
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
}
