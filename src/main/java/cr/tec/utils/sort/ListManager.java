package cr.tec.utils.sort;

import cr.tec.struct.Ingredient;
import cr.tec.struct.generic.GenericList;

import java.util.LinkedList;

/**
 * Created by joseph on 11/5/16.
 */

public class ListManager {
	public static GenericList<Ingredient> LLtoGL(LinkedList<Ingredient> llist){
		GenericList<Ingredient> newGL = new GenericList<Ingredient>();
		for(int i = 0; i<llist.size(); i++){
			newGL.addLast(llist.get(i));
			System.out.println(llist.get(i).getName());
		}
		return newGL;
	}

	public static LinkedList<Ingredient> GLtoLL(GenericList<Ingredient> glist){
		LinkedList<Ingredient> newLL = new LinkedList<Ingredient>();
		for(int i = 0; i< glist.getLenght(); i++){
			newLL.add(glist.getAt(i).getData());
		}
		return newLL;
	}

}