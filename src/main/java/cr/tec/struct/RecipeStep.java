package cr.tec.struct;

/**
 * Created by Jimena on 10/26/16.
 */

public class RecipeStep {
	private String title;
	private String description;
	private double aproxTime;
	private long realTime;

	public RecipeStep(String title, String description, double aproxTime){
		this.title = title;
		this.description = description;
		this.aproxTime = aproxTime;

	}

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

	public double getAproxTime() {
		return aproxTime;
	}

	public void setAproxTime(double aproxTime) {
		this.aproxTime = aproxTime;
	}

	public long getRealTime() {
		return realTime;
	}

	public void setRealTime(long realTime) {
		this.realTime = realTime;
	}


	@Override
	public String toString() {
		String result = getTitle() + ":\n" + getDescription() + "\n" + "Approximated time " + getAproxTime() + " hours\n";
		return result;
	}




}