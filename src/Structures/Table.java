package Structures;

import Food.Dish;
import People.Client;

public class Table {
	private GenericList<Client> clients;
	private GenericList<Dish> order;
	private int tableID;
	
	public Table(int tableID){
		
		this.tableID = tableID;
		this.clients= new GenericList<Client>();
		this.order = new GenericList<Dish>();
			
	}
	
	
	public void addClient(Client client){
		this.clients.addLast(client);
	}
	
	public void addClient(int clientID, String name, OrderType clientCathegory, Table clientTable){
		Client newClient = Client(clientID, name, clientCathegory, clientTable);
		this.clients.addLast(newClient);
	}

	private Client Client(int clientID, String name, OrderType clientCathegory, Table clientTable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addDish(Dish dish){
		this.order.addLast(dish);
	}
	
	public void deleteDish(Dish dish){
		this.order.deleteNode(dish);
	}

	
	public GenericList<Client> getClients() {
		return clients;
	}

	public void setClients(GenericList<Client> clients) {
		this.clients = clients;
	}

	public GenericList<Dish> getOrder() {
		return order;
	}

	public void setOrder(GenericList<Dish> order) {
		this.order = order;
	}

	public int getTableID() {
		return tableID;
	}

	public void setTableID(int tableID) {
		this.tableID = tableID;
	}
}
