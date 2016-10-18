package Sorting;

import Food.Ingredient;
import Structures.GenericList;

public class Insertion {
	public static <T> void insertionSort(GenericList<Ingredient> list){
		int i, j;
		String aux;
		for(i=1; i<list.getLenght(); i++){
			aux = list.getAt(i).getDato().getName();
			for(j= i -1; j >= 0 && aux.compareTo(list.getAt(j).getDato().getName())<0; j--){
				list.getAt(j+1).getDato().setName(list.getAt(j).getDato().getName());
			}
			list.getAt(j+1).getDato().setName(aux);
		}
		for(int k = 0; k<list.getLenght(); k++){
			list.getAt(k).getDato().setId(k+81);
		}
	}
}
