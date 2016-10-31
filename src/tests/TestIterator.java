package tests;
import java.util.Iterator;

import Food.Dish;
import Structures.*;
public class TestIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dish d1 = new Dish("Papas");
		Dish d2 = new Dish("Fresas");
		Dish d3 = new Dish("Uvas");
		Dish d4 = new Dish("Chocolate");
		Dish d5 = new Dish("Brownie");
		Dish d6 = new Dish("Banano");
		
		GenericList<Dish> newList= new GenericList<>();
		newList.addLast(d1);
		newList.addLast(d2);
		newList.addLast(d3);
		newList.addLast(d4);
		newList.addLast(d5);
		newList.addLast(d6);

		Iterator<Dish> myIterator =  newList.iterator();
		while(myIterator.hasNext()){
			System.out.println(myIterator.next().getName());
		}
	}

}
