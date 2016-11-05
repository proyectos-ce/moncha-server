package cr.tec.struct;

import java.util.LinkedList;

/**
 * Created by joseph on 11/3/16.
 * Class Suborder handles each kind of Dish in a separate suborder  to verify if it is completes and to distribute it among the chefs
 */
public class Suborder {
	private int dishId;
	private String comment;
	private int quantity;
	private boolean completed;
	private LinkedList<StepStatus> steps = new LinkedList<>();

	public Suborder() {
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LinkedList<StepStatus> getSteps() {
		return steps;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}
