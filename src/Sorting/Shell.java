package Sorting;

import Structures.GenericList;

public class Shell {
	public static void shellSort(GenericList<String> list){
		int j;
		for(int gap = list.getLenght()/2; gap >0; gap /=2){
			for(int i = gap; i< list.getLenght(); i++){
				String temp = list.getAt(i).getDato();
				for(j=i; j>=gap && list.getAt(j-gap).getDato().compareTo(temp) > 0; j-=gap){
					list.getAt(j).setDato(list.getAt(j-gap).getDato());
				}
				list.getAt(j).setDato(temp);
			}
		}
	}
}
