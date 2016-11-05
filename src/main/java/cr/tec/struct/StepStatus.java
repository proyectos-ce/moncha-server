package cr.tec.struct;

/**
 * Created by joseph on 11/4/16.
 */
public class StepStatus {
	private RecipeStep step;
	private boolean completed = false;

	public StepStatus() {

	}

	public StepStatus(RecipeStep step) {
		this.step = step;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public void complete() {
		this.completed = true;
	}

	public RecipeStep getStep() {
		return step;
	}

	public void setStep(RecipeStep step) {
		this.step = step;
	}
}
