package Food;

import Structures.FoodType;

public class Ingredient{
	private FoodType type;
	private String name;
	
	public Ingredient(FoodType type, String name){
		this.type=type;
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public FoodType getType() {
		return type;
	}

	public void setType(FoodType type) {
		this.type = type;
	}
	
}
