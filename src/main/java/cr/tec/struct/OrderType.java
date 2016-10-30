package cr.tec.struct;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joseph on 10/26/16.
 */
public enum OrderType {
	Platinum(1), Gold(2), Bronze(3);
	public int value;

	OrderType(int value) {
		this.value = value;

	}

	OrderType() {

	}

	public int getValue() {
		return value;
	}

	private static final Map<Integer, OrderType> intToTypeMap = new HashMap<Integer, OrderType>();
	static {
		for (OrderType type : OrderType.values()) {
			intToTypeMap.put(type.value, type);
		}
	}

	public static OrderType fromInt(int i) {
		OrderType type = intToTypeMap.get(Integer.valueOf(i));
		if (type == null)
			return null;
		return type;
	}
}