package cr.tec.struct;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by joseph on 10/30/16.
 */
public class User implements Serializable {

	private static int lastId = 0;

	private String lid;
	private String name;
	private String avatar;
	private int table;
	private OrderType type;
	private Role role;
	private int id;
	private LinkedList<Work> currentWorks = new LinkedList<>();
	private String firebaseToken;

	public User() {
		this.id = lastId + 1;
		lastId++;
	}

	public User(int table, OrderType type) {
		this.table = table;
		this.type = type;
		this.id = lastId + 1;
		lastId++;
	}

	public User(int table, int type) {
		this.table = table;
		this.type = OrderType.fromInt(type);
		this.id = lastId + 1;
		lastId++;
	}

	public String getFirebaseToken() {
		return firebaseToken;
	}

	public void setFirebaseToken(String firebaseToken) {
		this.firebaseToken = firebaseToken;
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

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}

	public LinkedList<Work> getCurrentWorks() {
		return currentWorks;
	}

	public void setCurrentWorks(LinkedList<Work> currentWorks) {
		this.currentWorks = currentWorks;
	}
}
