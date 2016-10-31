package cr.tec.struct;

import cr.tec.struct.generic.GenericList;

/**
 * Created by Jimena on 10/26/16.
 */

public class Table {
	private GenericList<Client> clients;
	private GenericList<Order> orders;
	private int tableID;

	public Table(int tableID){
		this.tableID = tableID;
		this.clients= new GenericList<Client>();
		this.orders = new GenericList<Order>();

	}
}