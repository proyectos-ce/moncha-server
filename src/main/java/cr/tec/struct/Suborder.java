package cr.tec.struct;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by joseph on 11/3/16.
 */
@JsonIgnoreProperties({"steps"})
public class Suborder {
	private int dishId;
	private String comment;
	private int quantity;
	private boolean completed;
	private HashMap<RecipeStep, Boolean> steps = new HashMap<>();

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

	public HashMap<RecipeStep, Boolean> getSteps() {
		return steps;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}
