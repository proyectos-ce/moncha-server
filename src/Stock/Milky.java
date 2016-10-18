package Stock;

import Food.Ingredient;
import Structures.FoodType;
import Structures.GenericList;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Milky {
	private GenericList<Ingredient> stockMilky;
	
	Ingredient m1 = new Ingredient(FoodType.milky, "Milk", 99);
	Ingredient m2 = new Ingredient(FoodType.milky, "TurrialbaCheese", 99);
	Ingredient m3 = new Ingredient(FoodType.milky, "Yogurt", 99);
	Ingredient m4 = new Ingredient(FoodType.milky, "IceCream", 99);
	Ingredient m5 = new Ingredient(FoodType.milky, "Chocolate", 99);
	Ingredient m6 = new Ingredient(FoodType.milky, "Butter", 99);
	Ingredient m7 = new Ingredient(FoodType.milky, "PowderedMilk", 99);
	Ingredient m8 = new Ingredient(FoodType.milky, "CondensedMilk", 99);
	Ingredient m9 = new Ingredient(FoodType.milky, "GoodaCheese", 99);
	Ingredient m10 = new Ingredient(FoodType.milky, "BlueCheese", 99);
	Ingredient m11 = new Ingredient(FoodType.milky, "CreamCheese", 99);
	Ingredient m12 = new Ingredient(FoodType.milky, "MozzarellaCheese", 99);
	Ingredient m13 = new Ingredient(FoodType.milky, "Custard", 99);
	Ingredient m14 = new Ingredient(FoodType.milky, "GoatMilk", 99);
	Ingredient m15 = new Ingredient(FoodType.milky, "DonkeyMilk", 99);
	Ingredient m16 = new Ingredient(FoodType.milky, "SkimmedMilk", 99);
	Ingredient m17 = new Ingredient(FoodType.milky, "SoyMilk", 99);
	Ingredient m18 = new Ingredient(FoodType.milky, "GarlicButter", 99);
	Ingredient m19 = new Ingredient(FoodType.milky, "Mayonnaise", 99);
	Ingredient m20 = new Ingredient(FoodType.milky, "AmericanCheese", 99);
	
	
	public Milky(){
		stockMilky = new GenericList<Ingredient>();
		stockMilky.addLast(m1);
		stockMilky.addLast(m2);
		stockMilky.addLast(m3);
		stockMilky.addLast(m4);
		stockMilky.addLast(m5);
		stockMilky.addLast(m6);
		stockMilky.addLast(m7);
		stockMilky.addLast(m8);
		stockMilky.addLast(m9);
		stockMilky.addLast(m10);
		stockMilky.addLast(m11);
		stockMilky.addLast(m12);
		stockMilky.addLast(m13);
		stockMilky.addLast(m14);
		stockMilky.addLast(m15);
		stockMilky.addLast(m16);
		stockMilky.addLast(m17);
		stockMilky.addLast(m18);
		stockMilky.addLast(m19);
		stockMilky.addLast(m20);

	}


	public GenericList<Ingredient> getStockMilky() {
		return stockMilky;
	}

	@XmlElement
	public void setStockMilky(GenericList<Ingredient> stockMilky) {
		this.stockMilky = stockMilky;
	}

	
	
	
}
