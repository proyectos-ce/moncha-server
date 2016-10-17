package Stock;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import Food.Ingredient;
import Sorting.Bubble;
import Sorting.Quick;
import Sorting.Shell;
import Structures.GenericList;

public class XMLImporter {
	public static void main(String[] args) {

	 try {

		File file = new File("C:\\RestCHEF\\Fruits.xml");
		File file1 = new File("C:\\RestCHEF\\Vegetables.xml");
		
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Fruits.class, Vegetables.class, Ingredient.class, GenericList.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		
		
		
		Fruits stockFruits = (Fruits) jaxbUnmarshaller.unmarshal(file);
		Vegetables stockVegetables = (Vegetables) jaxbUnmarshaller.unmarshal(file1);
		
		
		
		
		
		
		Quick.quickSort(stockFruits.getStockFruits());
		Shell.shellSort(stockVegetables.getStockVegetables());
		
		System.out.println("Frutas ordenadas\n");
		System.out.println(stockFruits.getStockFruits());
		
		System.out.println("Vegetales ordenados\n");
		System.out.println(stockVegetables.getStockVegetables());

	  } catch (JAXBException e) {
		e.printStackTrace();
	  }

	}
}

