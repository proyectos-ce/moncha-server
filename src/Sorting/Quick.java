package Sorting;

import Structures.GenericList;

public class Quick {
	
	public static void quickSort(GenericList<String> list){
		int izq = 0;
		int der = list.getLenght()-1;
		quickSortAux(list, izq, der);
		
	}
	private static void quickSortAux(GenericList<String> list, int izq, int der){
		String pivote = list.getAt(izq).getDato();
		int i = izq;
		int j = der;
		String aux;
		while(i<j){
			while(list.getAt(i).getDato().compareTo(pivote) <= 0 && i<j)i++;
			while(list.getAt(j).getDato().compareTo(pivote) > 0)j--;
			if(i<j){
				aux = list.getAt(i).getDato();
				list.getAt(i).setDato(list.getAt(j).getDato());
				list.getAt(j).setDato(aux);
			}
		}
		list.getAt(izq).setDato(list.getAt(j).getDato());
		list.getAt(j).setDato(pivote);
		if(izq<j-1)quickSortAux(list, izq, j-1);
		if(j+1 < der)quickSortAux(list, j+1, der);
		
		
	}
}
