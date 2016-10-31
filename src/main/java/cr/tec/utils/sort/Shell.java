package cr.tec.utils.sort;

import cr.tec.struct.*;
import cr.tec.struct.generic.GenericList;

public class Shell {
	public static void shellSort(GenericList<Ingredient> list){
		int j;
		for(int gap = list.getLength()/2; gap >0; gap /=2){
			for(int i = gap; i< list.getLength(); i++){
				String temp = list.getAt(i).getData().getName();
				for(j=i; j>=gap && list.getAt(j-gap).getData().getName().compareTo(temp) > 0; j-=gap){
					list.getAt(j).getData().setName(list.getAt(j-gap).getData().getName());
				}
				list.getAt(j).getData().setName(temp);
			}
		}

		for(int i = 0; i<list.getLength(); i++){
			list.getAt(i).getData().setId(i+21);
		}
	}
}
