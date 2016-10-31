package Sorting;

import java.util.LinkedList;

import Food.Ingredient;
import Structures.FoodType;
import Structures.GenericList;
import Sorting.Converter;

public class PruebasConvertidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Ingredient> newll = new LinkedList<Ingredient>();
		Ingredient i1 = new Ingredient(FoodType.fruits, "uvas", 99);
		Ingredient i2 = new Ingredient(FoodType.fruits, "fresas", 99);
		Ingredient i3 = new Ingredient(FoodType.fruits, "mangos", 99);
		Ingredient i4 = new Ingredient(FoodType.fruits, "bananos", 99);
		newll.add(i1);
		newll.add(i2);
		newll.add(i3);
		newll.add(i4);
		
		GenericList<Ingredient> newgl = new GenericList<Ingredient>();
		newgl.addLast(i1);
		newgl.addLast(i2);
		newgl.addLast(i3);
		newgl.addLast(i4);
		
		System.out.println(Converter.LLtoGL(newll));
		System.out.println(Converter.GLtoLL(newgl));
		
		

	}

}
