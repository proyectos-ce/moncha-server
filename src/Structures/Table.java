package Structures;

import People.Client;

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
