package cr.tec.utils.sort;

import cr.tec.struct.*;
import cr.tec.struct.generic.GenericList;

public class Insertion {
	public static <T> void insertionSort(GenericList<Ingredient> list){
		int i, j;
		String aux;
		for(i=1; i<list.getLength(); i++){
			aux = list.getAt(i).getData().getName();
			for(j= i -1; j >= 0 && aux.compareTo(list.getAt(j).getData().getName())<0; j--){
				list.getAt(j+1).getData().setName(list.getAt(j).getData().getName());
			}
			list.getAt(j+1).getData().setName(aux);
		}
		for(int k = 0; k<list.getLength(); k++){
			list.getAt(k).getData().setId(k+81);
		}
	}
}
