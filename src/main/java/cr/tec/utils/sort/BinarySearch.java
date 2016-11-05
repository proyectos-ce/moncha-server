package cr.tec.utils.sort;
import cr.tec.struct.*;
import cr.tec.struct.generic.GenericList;

import java.util.LinkedList;

public class BinarySearch {
	public static Ingredient ingredientSearch(LinkedList<Ingredient> list, int data){
		int minIndex = 0;
		int maxIndex =  list.size();
		while(maxIndex >=minIndex){
			int middle = (minIndex + maxIndex)/2;
			if(list.get(middle).getId() - data < 0){
				minIndex = middle +1;
			} else if (list.get(middle).getId() - data > 0){
				maxIndex = middle-1;
			} else{
				return list.get(middle);
			}
			
		}
		return null;
		
	}

	public static Dish dishSearch(LinkedList<Dish> list, int data){
		int minIndex = 0;
		int maxIndex =  list.size();
		while(maxIndex >=minIndex){
			int middle = (minIndex + maxIndex)/2;
			if(list.get(middle).getId() - data < 0){
				minIndex = middle +1;
			} else if (list.get(middle).getId() - data > 0){
				maxIndex = middle-1;
			} else{
				return list.get(middle);
			}

		}
		return null;

	}

	public static Order orderSearch(LinkedList<Order> list, int data){
		int minIndex = 0;
		int maxIndex =  list.size();
		while(maxIndex >=minIndex){
			int middle = (minIndex + maxIndex)/2;
			if(list.get(middle).getId() - data < 0){
				minIndex = middle +1;
			} else if (list.get(middle).getId() - data > 0){
				maxIndex = middle - 1;
			} else{
				return list.get(middle);
			}

		}
		return null;

	}

}
