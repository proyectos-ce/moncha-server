package Sorting;

import java.util.LinkedList;
import Sorting.Converter;

import Food.Ingredient;
import Structures.GenericList;

public class Bubble {
	public static LinkedList<Ingredient> bubbleSort(LinkedList<Ingredient> inlist){
		GenericList<Ingredient> list = Converter.LLtoGL(inlist);
		int in, out;
		for(out = list.getLenght(); out > 1; out--){
			for(in = 0; in < out-1; in++){
				if(list.getAt(in).getData().getName().compareTo(list.getAt(in+1).getData().getName()) > 0){
					list.swap(in, in+1);
				}
			}
		}
		
	for(int i = 0; i<list.getLenght(); i++){
		list.getAt(i).getData().setId(i+41);
	}
	LinkedList<Ingredient> outlist= Converter.GLtoLL(list);
	return outlist;
	}

}
