package cr.tec.struct;

/**
 * Created by Jimena on 10/26/16.
 */
/**
 * 
 * @author Jimena
 *Main class Ingredient
 */
public class Ingredient{
	private FoodType type;
	private String name;
	private int quantity, id;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
/**
 * Constructor that takes the type, name and quantity of the ingredient object
 * @param type the kind of ingredient
 * @param name the name of the ingredient
 * @param quantity the quantity of the ingredient in the dish
 */
	public Ingredient(FoodType type, String name, int quantity){
		this.type=type;
		this.name=name;
		this.quantity=quantity;
	}
/**
 * Empty constructor
 */
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
