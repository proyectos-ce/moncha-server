package cr.tec.struct;

import cr.tec.struct.generic.GenericList;

/**
 * Created by Jimena on 10/26/16.
 */
/**
 * 
 * @author Jimena
 *
 */
public class Client {
	private int clientID;
	private String name;
	private OrderType clientCathegory;
	private Table clientTable;
	private double receipt;
	private GenericList<Order> clientOrders;
/**
 * Constructor of the clients that takes his ID, name and number of table
 * @param clientID
 * @param name
 * @param clientCathegory
 * @param clientTable
 */

	public Client(int clientID, String name, OrderType clientCathegory, Table clientTable){
		this.clientID = clientID;
		this.name = name;
		this.clientCathegory = clientCathegory;
		this.clientTable = clientTable;
		this.receipt = 0.0;
		this.clientOrders = new GenericList<Order>();
	}

}