package Sorting;

import java.util.LinkedList;

import Food.Ingredient;
import Structures.GenericList;

public class BinarySearch {
	public static int binarySearch(LinkedList<Ingredient> inlist, String data){
		GenericList<Ingredient> list = Converter.LLtoGL(inlist);
		int minIndex = 0;
		int maxIndex =  list.getLenght()-1;
		while(maxIndex >=minIndex){
			int middle = (minIndex + maxIndex)/2;
			if(list.getAt(middle).getData().getName().compareTo(data) < 0){
				minIndex = middle +1;
			}else  if(list.getAt(middle).getData().getName().compareTo(data) > 0){
				maxIndex = middle-1;
			}else{
				return middle;
			}
			
		}
		return -1;
		
	}

}
