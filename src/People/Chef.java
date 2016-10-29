package People;

import Food.Dish;
import Structures.GenericList;
import Structures.Order;
import Structures.OrderType;
import Structures.OrdersPriorityQueue;
import Structures.Table;

public class Chef {
	private String id, name;
	private GenericList<Order> chefOrderList;
	
	
	public Chef(String id, String name){
		this.id = id;
		this.name = name;
		this.chefOrderList = new GenericList<Order>();
	}
	
	public void addOrder(OrderType orderPriority, Table table, GenericList<Dish> dishes, long orderTime){
		Order newOrder = new Order(orderPriority, table, dishes, orderTime);
		chefOrderList.addLast(newOrder);
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public GenericList<Order> getChefOrderList() {
		return chefOrderList;
	}

	public void setChefOrderList(GenericList<Order> chefOrderList) {
		this.chefOrderList = chefOrderList;
	}
	
	
}
