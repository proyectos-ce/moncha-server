package cr.tec.struct;

/**
 * Created by Jimena on 10/26/16.
 */

public class RecipeStep {
	private String title;
	private String description;
	private double time;

	public RecipeStep(String title, String description, double time){
		this.title = title;
		this.description = description;
		this.time = time;

	}

	public RecipeStep() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return getTitle();
	}




}