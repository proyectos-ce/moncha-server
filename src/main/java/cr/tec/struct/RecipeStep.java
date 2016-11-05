package cr.tec.struct;

/**
 * Created by Jimena on 10/26/16.
 */
/**
 * 
 * @author Jimena
 *Class RecipeStep
 */
public class RecipeStep {
	private String title;
	private String description;
	private double time;
/**
 * Constructor that takes all the aspects related to the steps of the recipe
 * @param title title of the step
 * @param description string that describes in what consists the step 
 * @param time approximated time that will take the step to be made
 */
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