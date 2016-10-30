package Sorting;

import Food.Ingredient;
import Structures.GenericList;

public class Quick {
	
	public static void quickSort(GenericList<Ingredient> list){
		int izq = 0;
		int der = list.getLenght()-1;
		quickSortAux(list, izq, der);
		
	}
	private static void quickSortAux(GenericList<Ingredient> list, int izq, int der){
		String pivote = list.getAt(izq).getData().getName();
		int i = izq;
		int j = der;
		String aux;
		while(i<j){
			while(list.getAt(i).getData().getName().compareTo(pivote) <= 0 && i<j)i++;
			while(list.getAt(j).getData().getName().compareTo(pivote) > 0)j--;
			if(i<j){
				aux = list.getAt(i).getData().getName();
				list.getAt(i).getData().setName(list.getAt(j).getData().getName());
				list.getAt(j).getData().setName(aux);
			}
		}
		list.getAt(izq).getData().setName(list.getAt(j).getData().getName());
		list.getAt(j).getData().setName(pivote);
		if(izq<j-1)quickSortAux(list, izq, j-1);
		if(j+1 < der)quickSortAux(list, j+1, der);
		
		for(int k = 0; k<list.getLenght(); k++){
			list.getAt(k).getData().setId(k+1);
		}	
	}
}
