package cr.tec.struct;

import cr.tec.struct.generic.Node;

/**
 * Created by joseph on 11/3/16.
 * Class Table handles all the tables that are available
 */
class TableList {
	private static Node<Table> head;

	public TableList() {
		head = null;
	}

	static Node<Table> getHead() {
		return head;
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

/**
 * Gets a specific data according to its ID
 * @param id
 * @return
 */
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

/**
 * Gets the table of a specific user
 * @param user
 * @return
 */
	public static Table getTablebyUser(User user) {
		return get(user.getTable());

	}
/**
 * Removes all the users from the table
 * @param table
 */
	public static void cleanTable(int table) {
		get(table).clean();
	}


}
