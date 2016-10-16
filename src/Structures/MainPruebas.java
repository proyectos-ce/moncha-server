package Structures;
import Structures.GenericList;
import Sorting.BinarySearch;
import Sorting.Bubble;
import Sorting.Insertion;
import Sorting.Quick;
import Sorting.Radix;
import Sorting.Shell;

public class MainPruebas {

	public static void main(String[] args) {
		GenericList<String> l = new GenericList<String>();
		
		
		l.addFirst("banano");
		l.addFirst("fresa");
		l.addFirst("mango");
		l.addFirst("manzana");
		l.addFirst("pera");
		l.addFirst("zapallo");
		l.printList();
		

		Quick.quickSort(l);
		System.out.println();
		System.out.println("Ordenada----------");

		
		l.printList();
		
		System.out.println(BinarySearch.binarySearch(l, "banano"));

	}

}
