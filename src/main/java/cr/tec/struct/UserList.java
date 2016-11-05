package cr.tec.struct;

import cr.tec.struct.User;
import cr.tec.struct.generic.Node;
import cr.tec.utils.sort.BinarySearch;

import java.util.LinkedList;

/**
 * Created by joseph on 11/5/16.
 * Handles all the users that had been registered at the moment
 */
public class UserList {
	private static LinkedList<User> list = new LinkedList<>();

	public static LinkedList<User> getList() {
		return list;
	}
/**
 * Adds a new user to the list
 * @param toAdd
 */
	public static void add(User toAdd) {
		list.add(toAdd);
	}

/**
 * gets a specific user by its id
 * @param id
 * @return
 */
	public static User get(int id) {
		return BinarySearch.userSearch(list, id);
	}
}
