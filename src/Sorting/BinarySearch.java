package Sorting;

import Structures.GenericList;

public class BinarySearch {
	public static int binarySearch(GenericList<String> list, String data){
		int minIndex = 0;
		int maxIndex =  list.getLenght()-1;
		while(maxIndex >=minIndex){
			int middle = (minIndex + maxIndex)/2;
			if(list.getAt(middle).getDato().compareTo(data) < 0){
				minIndex = middle +1;
			}else  if(list.getAt(middle).getDato().compareTo(data) > 0){
				maxIndex = middle-1;
			}else{
				return middle;
			}
			
		}
		return -1;
		
	}

}
