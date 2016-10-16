package Sorting;

import Structures.GenericList;

public class Insertion {
	public static <T> void insertionSort(GenericList<String> list){
		int i, j;
		String aux;
		for(i=1; i<list.getLenght(); i++){
			aux = list.getAt(i).getDato();
			for(j= i -1; j >= 0 && aux.compareTo(list.getAt(j).getDato())<0; j--){
				list.getAt(j+1).setDato(list.getAt(j).getDato());
			}
			list.getAt(j+1).setDato(aux);
		}
	}
}
