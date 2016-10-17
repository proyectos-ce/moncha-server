package Structures;

import Food.Dish;

public class Order {
	private OrderType orderPriority;
	private Table table;
	private GenericList<Dish> dishes;
	private long  orderTime;
	
	public Order(OrderType orderPriority, Table table, GenericList<Dish> dishes, long orderTime){
		this.orderPriority = orderPriority;
		this.dishes = dishes;
		this.table = table;
		this.orderTime = orderTime;
	}
	
}
