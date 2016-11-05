package cr.tec.struct;

import cr.tec.struct.User;
import cr.tec.struct.generic.Node;

/**
 * Created by joseph on 11/5/16.
 * Handles all the users that had been registered at the moment
 */
public class UserList {
	private static Node<User> head;

	public UserList() {
		head = null;
	}

	static Node<User> getHead() {
		return head;
	}
/**
 * Adds a new user to the list
 * @param toAdd
 */
	public static void add(User toAdd) {
		if (head == null) {
			head = new Node<User>(toAdd);
			return;
		}

		Node<User> actual = head;
		while (actual.getNext() != null) {
			actual.getNext();
		}

		actual.setNext(new Node<User>(toAdd));
	}

/**
 * gets a specific user by its id
 * @param id
 * @return
 */
	public static User get(int id) {
		Node<User> actual = head;
		while (actual != null) {
			if (actual.getData().getId() == id) {
				return actual.getData();
			}
			actual = actual.getNext();
		}
		return null;
	}
}
