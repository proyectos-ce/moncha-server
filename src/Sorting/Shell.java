package Sorting;

import Food.Ingredient;
import Structures.GenericList;

public class Shell {
	public static void shellSort(GenericList<Ingredient> list){
		int j;
		for(int gap = list.getLenght()/2; gap >0; gap /=2){
			for(int i = gap; i< list.getLenght(); i++){
				String temp = list.getAt(i).getDato().getName();
				for(j=i; j>=gap && list.getAt(j-gap).getDato().getName().compareTo(temp) > 0; j-=gap){
					list.getAt(j).getDato().setName(list.getAt(j-gap).getDato().getName());
				}
				list.getAt(j).getDato().setName(temp);
			}
		}
		
		for(int i = 0; i<list.getLenght(); i++){
			list.getAt(i).getDato().setId(i+21);
		}
	}
}
