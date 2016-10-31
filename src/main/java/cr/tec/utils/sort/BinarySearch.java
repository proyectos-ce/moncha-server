package cr.tec.utils.sort;
import cr.tec.struct.*;
import cr.tec.struct.generic.GenericList;

public class BinarySearch {
	public static int binarySearch(GenericList<Ingredient> list, String data){
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
