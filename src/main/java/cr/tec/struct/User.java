package cr.tec.struct;

import java.io.Serializable;

/**
 * Created by joseph on 10/30/16.
 */
public class User implements Serializable {

	private String lid;
	private String name;
	private String avatar;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
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
