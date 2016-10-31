package tests;
import java.util.Iterator;

import Structures.*;
public class TestIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int item1 = 1;
		int item2 = 2;
		int item3 = 3;
		int item4 = 4;
		int item5 = 5;
		int item6 = 6;
		int item7 = 7;
		int item8 = 8;
		int item9 = 9;
		GenericList<Integer> newList= new GenericList<>();
		newList.addLast(item1);
		newList.addLast(item2);
		newList.addLast(item3);
		newList.addLast(item4);
		newList.addLast(item5);
		newList.addLast(item6);
		newList.addLast(item7);
		newList.addLast(item8);
		newList.addLast(item9);
		Iterator<Integer> myIterator =  newList.iterator();
		while(myIterator.hasNext()){
			System.out.println(myIterator.next());
		}
	}

}
