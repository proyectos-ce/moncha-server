package Sorting;

import Food.Ingredient;
import Structures.GenericList;

public class Shell {
	public static void shellSort(GenericList<Ingredient> list){
		int j;
		for(int gap = list.getLenght()/2; gap >0; gap /=2){
			for(int i = gap; i< list.getLenght(); i++){
				String temp = list.getAt(i).getData().getName();
				for(j=i; j>=gap && list.getAt(j-gap).getData().getName().compareTo(temp) > 0; j-=gap){
					list.getAt(j).getData().setName(list.getAt(j-gap).getData().getName());
				}
				list.getAt(j).getData().setName(temp);
			}
		}
		
		for(int i = 0; i<list.getLenght(); i++){
			list.getAt(i).getData().setId(i+21);
		}
	}
}
