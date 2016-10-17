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
		String pivote = list.getAt(izq).getDato().getName();
		int i = izq;
		int j = der;
		String aux;
		while(i<j){
			while(list.getAt(i).getDato().getName().compareTo(pivote) <= 0 && i<j)i++;
			while(list.getAt(j).getDato().getName().compareTo(pivote) > 0)j--;
			if(i<j){
				aux = list.getAt(i).getDato().getName();
				list.getAt(i).getDato().setName(list.getAt(j).getDato().getName());
				list.getAt(j).getDato().setName(aux);
			}
		}
		list.getAt(izq).getDato().setName(list.getAt(j).getDato().getName());
		list.getAt(j).getDato().setName(pivote);
		if(izq<j-1)quickSortAux(list, izq, j-1);
		if(j+1 < der)quickSortAux(list, j+1, der);
		
		for(int k = 0; k<list.getLenght(); k++){
			list.getAt(k).getDato().setId(k+1);
		}	
	}
}
