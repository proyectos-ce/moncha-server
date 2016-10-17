package Stock;

import Food.Ingredient;
import Structures.FoodType;
import Structures.GenericList;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Vegetables {
	private GenericList<Ingredient> stockVegetables;
	
	Ingredient v1 = new Ingredient(FoodType.vegetable, "Potato", 99);
	Ingredient v2 = new Ingredient(FoodType.vegetable, "Tomato", 99);
	Ingredient v3 = new Ingredient(FoodType.vegetable, "Cucumber", 99);
	Ingredient v4 = new Ingredient(FoodType.vegetable, "Broccoli", 99);
	Ingredient v5 = new Ingredient(FoodType.vegetable, "Asparagus", 99);
	Ingredient v6 = new Ingredient(FoodType.vegetable, "Sprout", 99);
	Ingredient v7 = new Ingredient(FoodType.vegetable, "Greenbeans", 99);
	Ingredient v8 = new Ingredient(FoodType.vegetable, "Peas", 99);
	Ingredient v9 = new Ingredient(FoodType.vegetable, "Carrot", 99);
	Ingredient v10 = new Ingredient(FoodType.vegetable, "Cauliflower", 99);
	Ingredient v11 = new Ingredient(FoodType.vegetable, "Cabbage", 99);
	Ingredient v12 = new Ingredient(FoodType.vegetable, "Corn", 99);
	Ingredient v13 = new Ingredient(FoodType.vegetable, "Zucchini", 99);
	Ingredient v14 = new Ingredient(FoodType.vegetable, "Spinach", 99);
	Ingredient v15 = new Ingredient(FoodType.vegetable, "Pepper", 99);
	Ingredient v16 = new Ingredient(FoodType.vegetable, "Onion", 99);
	Ingredient v17 = new Ingredient(FoodType.vegetable, "Mushroom", 99);
	Ingredient v18 = new Ingredient(FoodType.vegetable, "Greens", 99);
	Ingredient v19 = new Ingredient(FoodType.vegetable, "Yam", 99);
	Ingredient v20 = new Ingredient(FoodType.vegetable, "Eggplant", 99);
	
	public Vegetables(){
		stockVegetables = new GenericList<Ingredient>();
		stockVegetables.addLast(v1);
		stockVegetables.addLast(v2);
		stockVegetables.addLast(v3);
		stockVegetables.addLast(v4);
		stockVegetables.addLast(v5);
		stockVegetables.addLast(v6);
		stockVegetables.addLast(v7);
		stockVegetables.addLast(v8);
		stockVegetables.addLast(v9);
		stockVegetables.addLast(v10);
		stockVegetables.addLast(v11);
		stockVegetables.addLast(v12);
		stockVegetables.addLast(v13);
		stockVegetables.addLast(v14);
		stockVegetables.addLast(v15);
		stockVegetables.addLast(v16);
		stockVegetables.addLast(v17);
		stockVegetables.addLast(v18);
		stockVegetables.addLast(v19);
		stockVegetables.addLast(v20);
	}

	public GenericList<Ingredient> getStockVegetables() {
		return stockVegetables;
	}
	@XmlElement
	public void setStockVegetables(GenericList<Ingredient> stockVegetables) {
		this.stockVegetables = stockVegetables;
	}

}
