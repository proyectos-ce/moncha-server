package Sorting;

import java.util.LinkedList;

import Food.Ingredient;
import Structures.GenericList;

public class Insertion {
	public static LinkedList<Ingredient> insertionSort(LinkedList<Ingredient> inlist){
		GenericList<Ingredient> list = Converter.LLtoGL(inlist);
		int i, j;
		String aux;
		for(i=1; i<list.getLenght(); i++){
			aux = list.getAt(i).getData().getName();
			for(j= i -1; j >= 0 && aux.compareTo(list.getAt(j).getData().getName())<0; j--){
				list.getAt(j+1).getData().setName(list.getAt(j).getData().getName());
			}
			list.getAt(j+1).getData().setName(aux);
		}
		for(int k = 0; k<list.getLenght(); k++){
			list.getAt(k).getData().setId(k+81);
		}
		LinkedList<Ingredient> outlist= Converter.GLtoLL(list);
		return outlist;
	}
}
