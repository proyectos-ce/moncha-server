package People;

import Structures.GenericList;
import Structures.Order;
import Structures.OrderType;
import Structures.Table;

public class Client {
	private int clientID;
	private String name;
	private OrderType clientCathegory;
	private Table clientTable;
	private double receipt;
	private GenericList<Order> clientOrders;
	
	public Client(int clientID, String name, OrderType clientCathegory, Table clientTable){
		this.clientID = clientID;
		this.name = name;
		this.clientCathegory = clientCathegory;
		this.clientTable = clientTable;
		this.receipt = 0.0;
		this.clientOrders = new GenericList<Order>();
	}

}
