package cr.tec.struct;

import cr.tec.struct.generic.Node;
import cr.tec.utils.Database;

import java.util.LinkedList;

/**
 * Created by joseph on 11/3/16.
 */
public class TableList {
	private static Node<Table> head;

	public TableList() {
		head = null;
	}

	private static void add(Table toAdd) {
		if (head == null) {
			head = new Node<Table>(toAdd);
			return;
		}

		Node<Table> actual = head;
		while (actual.getNext() != null) {
			actual.getNext();
		}

		actual.setNext(new Node<Table>(toAdd));
	}


	public static Table get(int id) {
			Node<Table> actual = head;
			while (actual != null) {
				if (actual.getData().getId() == id) {
					return actual.getData();
				}
				actual = actual.getNext();
			}
			Table newTable = new Table(id);
			add(newTable);
			return newTable;
	}


	public static Table getTablebyUser(User user) {
		return get(user.getTable());

	}

	public static void cleanTable(int table) {
		get(table).clean();
	}

	public static Message placeOrder(int tableId, OrderType type, LinkedList<Suborder> suborders) {
		if (tableId <= 0 || suborders == null || suborders.size() == 0) {
			return new Message("error", "Invalid data");
		}
		Table table = get(tableId);
		Boolean found = false;
		for (Suborder sub : suborders) {
			for (Dish dish : Database.getDishes()) {
				found = dish.getId() == sub.getDishId() && sub.getQuantity() > 0;
				if (found) {
					break;
				}
			}
			if (!found) {
				return new Message("error", "The order has an invalid dish.");
			}
		}
		Order order = new Order();
		order.setSuborders(suborders);
		order.setTable(tableId);
		order.setType(type);
		table.getOrders().add(order);
		return new Message("ok", "Order added succesfully.");

	}

	public static LinkedList<Order> getAllOrders() {
		LinkedList<Order> orderList = new LinkedList<Order>();
		Node<Table> actual = head;
		while (actual != null) {
			orderList.addAll(actual.getData().getOrders());
			actual = actual.getNext();
		}

		return orderList;
	}


}
