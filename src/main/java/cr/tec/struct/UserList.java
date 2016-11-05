package cr.tec.struct;

import cr.tec.struct.User;
import cr.tec.struct.generic.Node;
import cr.tec.utils.sort.BinarySearch;

import java.util.LinkedList;

/**
 * Created by joseph on 11/5/16.
 */
public class UserList {
	private static LinkedList<User> list = new LinkedList<>();

	public static LinkedList<User> getList() {
		return list;
	}

	public static void add(User toAdd) {
		list.add(toAdd);
	}


	public static User get(int id) {
		return BinarySearch.userSearch(list, id);
	}
}
