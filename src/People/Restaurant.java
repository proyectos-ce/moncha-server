package People;

import Structures.GenericList;
import Structures.Order;

public class Restaurant {
	
	private GenericList<Order> orderList;
	private GenericList<Chef> chefList;
	
	public Restaurant(){
		this.orderList = new GenericList<Order>();
		this.chefList = new GenericList<Chef>();
		
	}

	public GenericList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(GenericList<Order> orderList) {
		this.orderList = orderList;
	}

	public GenericList<Chef> getChefList() {
		return chefList;
	}

	public void setChefList(GenericList<Chef> chefList) {
		this.chefList = chefList;
	}
	
	
	
}
