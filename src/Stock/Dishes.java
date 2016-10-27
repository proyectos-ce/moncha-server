package Stock;

import Food.Dish;
import Food.Ingredient;
import Structures.FoodType;
import Structures.GenericList;
import javax.xml.bind.annotation.*;
import Stock.Fruits;

@XmlRootElement
public class Dishes {
	private GenericList<Dish> stockDishes;

	
	Dish d1 =  new Dish("Pizza");
	Dish d2 =  new Dish("Hamburger");
	Dish d3 =  new Dish("Fruit Salad");
	Dish d4 =  new Dish("Sopa Azteca");
	Dish d5 =  new Dish("Brownies");
	Dish d6 =  new Dish("Gallo Pinto");
	Dish d7 =  new Dish("Chorreadas");
	Dish d8 =  new Dish("Green Salad");
	Dish d9 =  new Dish("Olla de Carne");
	Dish d10 =  new Dish("Fried Fish");
	Dish d11 =  new Dish("Rice Beans");
	Dish d12 =  new Dish("Spaghetti Bolognese");
	Dish d13 =  new Dish("Cheese Dice");
	Dish d14 =  new Dish("Sushi");
	Dish d15 =  new Dish("Chocolate Cake");
	
	public Dishes(){
		d1.addIngredient("Ham", FoodType.meat,  20);
	
	}
	
	
	
}
