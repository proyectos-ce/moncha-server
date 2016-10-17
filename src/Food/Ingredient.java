package Food;

import Structures.FoodType;

public class Ingredient{
	private FoodType type;
	private String name;
	private int quantity, id;
	
	public Ingredient(FoodType type, String name, int quantity){
		this.type=type;
		this.name=name;	
		this.quantity=quantity;
	}
	
	public Ingredient(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		String result = "Name: " + getName() + "\nType: " + getType() +"\n" + "ID: " + getId() + "\n";
		return result;
	}
	
}
