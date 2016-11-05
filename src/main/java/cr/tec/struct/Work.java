package cr.tec.struct;

/**
 * Created by joseph on 11/5/16.
 */
public class Work {
	private int order;
	private int suborder;

	public Work() {}

	public Work(int order, int suborder) {
		this.order = order;
		this.suborder = suborder;
	}

	public int getSuborder() {
		return suborder;
	}

	public void setSuborder(int suborder) {
		this.suborder = suborder;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
}
