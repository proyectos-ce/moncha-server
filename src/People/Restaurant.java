package People;

import Food.Dish;
import Structures.GenericList;
import Structures.Order;
import Structures.OrderType;
import Structures.OrdersPriorityQueue;
import Structures.Table;

public class Restaurant {
	
	private OrdersPriorityQueue orderList;
	private GenericList<Chef> chefList;
	
	public Restaurant(){
		this.orderList = new OrdersPriorityQueue();
		this.chefList = new GenericList<Chef>();
		
	}



	public OrdersPriorityQueue getOrderList() {
		return orderList;
	}
	
	public void addOrder(OrderType orderPriority, Table table, GenericList<Dish> dishes, long orderTime){
		Order newOrder = new Order(orderPriority, table, dishes, orderTime);
		orderList.addLast(newOrder);
	}

	public void setOrderList(OrdersPriorityQueue orderList) {
		this.orderList = orderList;
	}


	public GenericList<Chef> getChefList() {
		return chefList;
	}

	public void setChefList(GenericList<Chef> chefList) {
		this.chefList = chefList;
	}
	
	
	
}
