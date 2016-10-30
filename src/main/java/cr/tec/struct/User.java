package cr.tec.struct;

import java.io.Serializable;

/**
 * Created by joseph on 10/30/16.
 */
public class User implements Serializable {

	private int table;
	private OrderType orderType;
	private Role role;
	private int id;

	public User() {

	}

	public User(int table, OrderType orderType) {
		this.table = table;
		this.orderType = orderType;
	}

	public User(int table, int type) {
		this.table = table;
		this.orderType = OrderType.fromInt(type);
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTable() {
		return table;
	}

	public void setTable(int table) {
		this.table = table;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
}
