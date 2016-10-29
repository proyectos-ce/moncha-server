package cr.tec.struct;

/**
 * Created by joseph on 10/26/16.
 */
public enum OrderType {
	Platinum(1), Gold(2), Bronze(3);
	private int value;

	OrderType(int value) {
		this.value = value;

	}

}