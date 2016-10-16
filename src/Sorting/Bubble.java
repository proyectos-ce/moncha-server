package Sorting;

import Structures.GenericList;

public class Bubble {
	public static <T> void bubbleSort(GenericList<String> list){
		int in, out;
		for(out = list.getLenght(); out > 1; out--){
			for(in = 0; in < out-1; in++){
				if(list.getAt(in).getDato().compareTo(list.getAt(in+1).getDato()) > 0){
					list.swap(in, in+1);
				}
			}
		}
	}

}
