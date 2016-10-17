package Stock;

import Food.Ingredient;
import Structures.FoodType;
import Structures.GenericList;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Fruits {
	private GenericList<Ingredient> stockFruits;
	Ingredient f1 = new Ingredient(FoodType.fruits, "Papaya", 99);
	Ingredient f2 = new Ingredient(FoodType.fruits, "Mango", 99);
	Ingredient f3 = new Ingredient(FoodType.fruits, "Apple", 99);
	Ingredient f4 = new Ingredient(FoodType.fruits, "Grape", 99);
	Ingredient f5 = new Ingredient(FoodType.fruits, "Strawberry", 99);
	Ingredient f6 = new Ingredient(FoodType.fruits, "Maracuya", 99);
	Ingredient f7 = new Ingredient(FoodType.fruits, "Kiwi", 99);
	Ingredient f8 = new Ingredient(FoodType.fruits, "Orange", 99);
	Ingredient f9 = new Ingredient(FoodType.fruits, "Lemon", 99);
	Ingredient f10 = new Ingredient(FoodType.fruits, "Pineapple", 99);
	Ingredient f11 = new Ingredient(FoodType.fruits, "Watermelon", 99);
	Ingredient f12 = new Ingredient(FoodType.fruits, "Apricot", 99);
	Ingredient f13 = new Ingredient(FoodType.fruits, "Avocado", 99);
	Ingredient f14 = new Ingredient(FoodType.fruits, "Blueberry", 99);
	Ingredient f15 = new Ingredient(FoodType.fruits, "Tangerine", 99);
	Ingredient f16 = new Ingredient(FoodType.fruits, "Pear", 99);
	Ingredient f17 = new Ingredient(FoodType.fruits, "Banana", 99);
	Ingredient f18 = new Ingredient(FoodType.fruits, "Coconut", 99);
	Ingredient f19 = new Ingredient(FoodType.fruits, "Peach", 99);
	Ingredient f20 = new Ingredient(FoodType.fruits, "Plum", 99);
	


	public Fruits(){
		this.stockFruits = new GenericList<Ingredient>();
		this.stockFruits.addFirst(f1);
		this.stockFruits.addFirst(f2);
		this.stockFruits.addFirst(f3);
		this.stockFruits.addFirst(f4);
		this.stockFruits.addFirst(f5);
		this.stockFruits.addFirst(f6);
		this.stockFruits.addFirst(f7);
		this.stockFruits.addFirst(f8);
		this.stockFruits.addFirst(f9);
		this.stockFruits.addFirst(f10);
		this.stockFruits.addFirst(f11);
		this.stockFruits.addFirst(f12);
		this.stockFruits.addFirst(f13);
		this.stockFruits.addFirst(f14);
		this.stockFruits.addFirst(f15);
		this.stockFruits.addFirst(f16);
		this.stockFruits.addFirst(f17);
		this.stockFruits.addFirst(f18);
		this.stockFruits.addFirst(f19);
		this.stockFruits.addFirst(f20);
	}
	
	public GenericList<Ingredient> getStockFruits() {
		return stockFruits;
	}
	
	@XmlElement
	public void setStockFruits(GenericList<Ingredient> stockFruits) {
		this.stockFruits = stockFruits;
	}
	
	
}
