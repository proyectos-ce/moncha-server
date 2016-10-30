package tests;
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
		
		SimpleIterator<Integer> myIterator = new SimpleIterator<>();
		myIterator.add(item1);
		myIterator.add(item2);
		myIterator.add(item3);
		myIterator.add(item4);
		myIterator.add(item5);
		myIterator.add(item6);
		myIterator.add(item7);
		myIterator.add(item8);
		myIterator.add(item9);
		
		while(myIterator.hasNext()){
			System.out.println(myIterator.next());
		}
	}

}
