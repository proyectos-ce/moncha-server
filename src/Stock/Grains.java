package Stock;

import Food.Ingredient;
import Structures.FoodType;
import Structures.GenericList;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Grains {
	private GenericList<Ingredient> stockGrains;
	
	Ingredient g1 = new Ingredient(FoodType.grains, "Beans", 99);
	Ingredient g2 = new Ingredient(FoodType.grains, "Rice", 99);
	Ingredient g3 = new Ingredient(FoodType.grains, "Sorghum", 99);
	Ingredient g4 = new Ingredient(FoodType.grains, "Wheat", 99);
	Ingredient g5 = new Ingredient(FoodType.grains, "Oats", 99);
	Ingredient g6 = new Ingredient(FoodType.grains, "Quinoa", 99);
	Ingredient g7 = new Ingredient(FoodType.grains, "Clover", 99);
	Ingredient g8 = new Ingredient(FoodType.grains, "Alfalfa", 99);
	Ingredient g9 = new Ingredient(FoodType.grains, "Peanuts", 99);
	Ingredient g10 = new Ingredient(FoodType.grains, "Tamarind", 99);
	Ingredient g11 = new Ingredient(FoodType.grains, "Lentils", 99);
	Ingredient g12 = new Ingredient(FoodType.grains, "Carob", 99);
	Ingredient g13 = new Ingredient(FoodType.grains, "WhiteBeans", 99);
	Ingredient g14 = new Ingredient(FoodType.grains, "SoyBeans", 99);
	Ingredient g15 = new Ingredient(FoodType.grains, "WildRice", 99);
	Ingredient g16 = new Ingredient(FoodType.grains, "Millet", 99);
	Ingredient g17 = new Ingredient(FoodType.grains, "Spelt", 99);
	Ingredient g18 = new Ingredient(FoodType.grains, "Farro", 99);
	Ingredient g19 = new Ingredient(FoodType.grains, "Triticale", 99);
	Ingredient g20 = new Ingredient(FoodType.grains, "Fonio", 99);
	
	
	public Grains(){
		stockGrains = new GenericList<Ingredient>();
		stockGrains.addLast(g1);
		stockGrains.addLast(g2);
		stockGrains.addLast(g3);
		stockGrains.addLast(g4);
		stockGrains.addLast(g5);
		stockGrains.addLast(g6);
		stockGrains.addLast(g7);
		stockGrains.addLast(g8);
		stockGrains.addLast(g9);
		stockGrains.addLast(g10);
		stockGrains.addLast(g11);
		stockGrains.addLast(g12);
		stockGrains.addLast(g13);
		stockGrains.addLast(g14);
		stockGrains.addLast(g15);
		stockGrains.addLast(g16);
		stockGrains.addLast(g17);
		stockGrains.addLast(g18);
		stockGrains.addLast(g19);
		stockGrains.addLast(g20);
	}


	public GenericList<Ingredient> getStockGrains() {
		return stockGrains;
	}

	@XmlElement
	public void setStockGrains(GenericList<Ingredient> stockGrains) {
		this.stockGrains = stockGrains;
	}
	
}
