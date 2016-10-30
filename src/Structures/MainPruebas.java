package Structures;
import Structures.GenericList;

import java.util.Iterator;

import Food.Dish;
import People.Chef;
import Sorting.BinarySearch;
import Sorting.Bubble;
import Sorting.Insertion;
import Sorting.Quick;
import Sorting.Radix;
import Sorting.Shell;

public class MainPruebas {

	public static void main(String[] args) {
/*		GenericList<String> l = new GenericList<String>();
		Dish di = new Dish("Pizza");
		Dish di1 = new Dish("Helado");
		Dish di2 = new Dish("Roast Beef");
		Dish di3 = new Dish("Subway");
		
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
		
		Table t = new Table(1);
		Chef ch = new Chef("nsdjkfndks55", "Pedro");
		GenericList<Dish> dishes = new GenericList<Dish>();
		GenericList<Dish> dishes1 = new GenericList<Dish>();
		GenericList<Dish> dishes2 = new GenericList<Dish>();
		
		dishes.addLast(di);
		dishes.addLast(di1);
		dishes.addLast(di2);
		dishes1.addLast(di3);
		dishes2.addLast(di1);
		dishes2.addLast(di3);
		ch.addOrder(OrderType.Bronze, t, dishes, 2);
		
		ch.addOrder(OrderType.Platinum, t, dishes1, 2);
		ch.addOrder(OrderType.Gold, t, dishes2, 2);
		ch.addOrder(OrderType.Bronze, t, dishes1, 2);
		
		
		System.out.println(ch.getOrdersQueue());*/
		
		/*GenericList<Dish> d = new GenericList<Dish>();
		Iterator<Dish> iter = d.iterator();
		
		
		
		
		
		Dish n1 = new Dish("Papas");
		Dish n2 = new Dish("Fresas");
		Dish n3 = new Dish("Uvas");
		
		d.addLast(n3);
		d.addLast(n2);
		d.addLast(n1);
		
		d.printList();
		
		System.out.println("holi");
		d.deleteNode(n2);
		d.printList();*/
		
		GenericList<Dish> d = new GenericList<Dish>();
		Iterator<Dish> iter = d.iterator();
		Dish n1 = new Dish("Papas");
		Dish n2 = new Dish("Fresas");
		Dish n3 = new Dish("Uvas");
		d.addLast(n3);
		d.addLast(n2);
		d.addLast(n1);
		
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		



		

	}

}
