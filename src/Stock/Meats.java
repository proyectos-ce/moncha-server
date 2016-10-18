package Stock;

import Food.Ingredient;
import Structures.FoodType;
import Structures.GenericList;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Meats {
	private GenericList<Ingredient> stockMeats;
	
	Ingredient c1 = new Ingredient(FoodType.meat, "Chicken", 99);
	Ingredient c2 = new Ingredient(FoodType.meat, "Fish", 99);
	Ingredient c3 = new Ingredient(FoodType.meat, "Tuna", 99);
	Ingredient c4 = new Ingredient(FoodType.meat, "ChickenStrips", 99);
	Ingredient c5 = new Ingredient(FoodType.meat, "Lamb", 99);
	Ingredient c6 = new Ingredient(FoodType.meat, "Pork", 99);
	Ingredient c7 = new Ingredient(FoodType.meat, "Bacon", 99);
	Ingredient c8 = new Ingredient(FoodType.meat, "Ham", 99);
	Ingredient c9 = new Ingredient(FoodType.meat, "Goat", 99);
	Ingredient c10 = new Ingredient(FoodType.meat, "Beef", 99);
	Ingredient c11= new Ingredient(FoodType.meat, "Buffalo", 99);
	Ingredient c12 = new Ingredient(FoodType.meat, "Chicken", 99);
	Ingredient c13 = new Ingredient(FoodType.meat, "Octopus", 99);
	Ingredient c14 = new Ingredient(FoodType.meat, "Turkey", 99);
	Ingredient c15 = new Ingredient(FoodType.meat, "Goose", 99);
	Ingredient c16 = new Ingredient(FoodType.meat, "Duck", 99);
	Ingredient c17 = new Ingredient(FoodType.meat, "Ostrich", 99);
	Ingredient c18 = new Ingredient(FoodType.meat, "Quail", 99);
	Ingredient c19 = new Ingredient(FoodType.meat, "Turtle", 99);
	Ingredient c20 = new Ingredient(FoodType.meat, "Cornish", 99);

	public Meats(){
		stockMeats = new GenericList<Ingredient>();
		
		stockMeats.addLast(c1);
		stockMeats.addLast(c2);
		stockMeats.addLast(c3);
		stockMeats.addLast(c4);
		stockMeats.addLast(c5);
		stockMeats.addLast(c6);
		stockMeats.addLast(c7);
		stockMeats.addLast(c8);
		stockMeats.addLast(c9);
		stockMeats.addLast(c10);
		stockMeats.addLast(c11);
		stockMeats.addLast(c12);
		stockMeats.addLast(c13);
		stockMeats.addLast(c14);
		stockMeats.addLast(c15);
		stockMeats.addLast(c16);
		stockMeats.addLast(c17);
		stockMeats.addLast(c18);
		stockMeats.addLast(c19);
		stockMeats.addLast(c20);
		
	}

	public GenericList<Ingredient> getStockMeats() {
		return stockMeats;
	}
	@XmlElement
	public void setStockMeats(GenericList<Ingredient> stockMeats) {
		this.stockMeats = stockMeats;
	}
	
	

}
