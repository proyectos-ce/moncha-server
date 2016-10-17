package Structures;
import Structures.GenericList;
import Food.Dish;
import Sorting.BinarySearch;
import Sorting.Bubble;
import Sorting.Insertion;
import Sorting.Quick;
import Sorting.Radix;
import Sorting.Shell;

public class MainPruebas {

	public static void main(String[] args) {
		GenericList<String> l = new GenericList<String>();
		Dish di = new Dish("Pizza");
		
		di.addRecipeStep("Amasar", "Prepare la masa y pasele el rodillo por encima", 5);
		di.addRecipeStep("Hornear", "Ponga en el horno a 350 grados Fahrenheit", 2);
		di.addRecipeStep("Preparación de la salsa", "Mezcle salsa de tomate con especies", 0.5);
		
		di.addIngredient("Queso", FoodType.milky, 6);
		di.addIngredient("Jamon", FoodType.meat, 10);
		di.addIngredient("Hongos", FoodType.vegetable, 30);
		
		System.out.println(di.getRecipe());
		System.out.println(di.getIngredientsList());



		
		
		l.addFirst("banano");
		l.addFirst("fresa");
		l.addFirst("mango");
		l.addFirst("manzana");
		l.addFirst("pera");
		l.addFirst("zapallo");
		l.addLast("papaya");
		l.printList();
		

		Quick.quickSort(l);
		System.out.println();
		System.out.println("Ordenada----------");

		
		l.printList();
		
		System.out.println(BinarySearch.binarySearch(l, "mango"));

		

	}

}
