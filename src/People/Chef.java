package People;

import Food.Dish;
import Structures.GenericList;
import Structures.Order;
import Structures.OrderType;
import Structures.OrdersPriorityQueue;
import Structures.Table;

public class Chef {
	private String id, name;
	private OrdersPriorityQueue ordersQueue;
	
	
	public Chef(String id, String name){
		this.id = id;
		this.name = name;
		this.ordersQueue = new OrdersPriorityQueue();
	}
	
	public void addOrder(OrderType orderPriority, Table table, GenericList<Dish> dishes, long orderTime){
		Order newOrder = new Order(orderPriority, table, dishes, orderTime);
		ordersQueue.addLast(newOrder);
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


	public OrdersPriorityQueue getOrdersQueue() {
		return ordersQueue;
	}


	public void setOrdersQueue(OrdersPriorityQueue ordersQueue) {
		this.ordersQueue = ordersQueue;
	}
	
	
	
	
}
