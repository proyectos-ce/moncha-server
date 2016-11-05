package cr.tec.struct;

import cr.tec.struct.generic.Node;
import cr.tec.utils.Database;
import cr.tec.utils.sort.BinarySearch;

import java.util.LinkedList;

/**
 * Created by joseph on 11/4/16.
 */
public class OrderManager {
	public static Message placeOrder(User user, LinkedList<Suborder> suborders) {
		int tableId = user.getTable();
		OrderType type = user.getType();

		if (tableId <= 0 || suborders == null || suborders.size() == 0) {
			return new Message("error", "Invalid data");
		}
		Table table = TableList.get(tableId);
		for (Suborder sub : suborders) {
			Dish dish = Database.getDish(sub.getDishId());
			if (dish == null) {
				return new Message("error", "The order has an invalid dish.");
			}

			for (RecipeStep step : dish.getRecipe()) {
				sub.getSteps().add(new StepStatus(step));
			}
		}

		Order order = new Order();
		order.setSuborders(suborders);
		order.setTable(tableId);
		order.setType(type);
		order.setUser(user.getId());
		table.getOrders().add(order);
		return new Message("ok", "Order added succesfully.");

	}



	public static LinkedList<Order> getAllOrders() {
		LinkedList<Order> orderList = new LinkedList<>();

		for (OrderType type : OrderType.values()) {
			Node<Table> actual = TableList.getHead();
			while (actual != null) {
				orderList.addAll(actual.getData().getOrders(type));
				actual = actual.getNext();
			}
		}

		return orderList;
	}

	public static Order getOrder(int id) {
		LinkedList<Order> orders = getAllOrders();

		return BinarySearch.orderSearch(orders, id);

	}

}
