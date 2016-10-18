package Stock;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import Food.Ingredient;
import Sorting.Bubble;
import Sorting.Quick;
import Sorting.Radix;
import Sorting.Shell;
import Structures.GenericList;

public class XMLImporter {
	public static void main(String[] args) {

	 try {

		File file = new File("C:\\RestCHEF\\Server\\Fruits.xml");
		File file1 = new File("C:\\RestCHEF\\Server\\Vegetables.xml");
		File file2 = new File("C:\\RestCHEF\\Server\\Milky.xml");
		File file3 = new File("C:\\RestCHEF\\Server\\Grains.xml");
		
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Fruits.class, Grains.class, Vegetables.class, Milky.class, Ingredient.class, GenericList.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		
		
		
		Fruits stockFruits = (Fruits) jaxbUnmarshaller.unmarshal(file);
		Vegetables stockVegetables = (Vegetables) jaxbUnmarshaller.unmarshal(file1);
		Milky stockMilky = (Milky) jaxbUnmarshaller.unmarshal(file2);
		Grains stockGrains = (Grains) jaxbUnmarshaller.unmarshal(file3);

		
		
		
		
		
		
		Quick.quickSort(stockFruits.getStockFruits());
		Shell.shellSort(stockVegetables.getStockVegetables());
		Bubble.bubbleSort(stockMilky.getStockMilky());
		Radix.radixSort(stockGrains.getStockGrains());
		
		System.out.println("Frutas ordenadas\n");
		System.out.println(stockFruits.getStockFruits());
		
		System.out.println("Vegetales ordenados\n");
		System.out.println(stockVegetables.getStockVegetables());

		System.out.println("Lacteos ordenados\n");
		System.out.println(stockMilky.getStockMilky());
		
		System.out.println("Granos ordenados\n");
		System.out.println(stockGrains.getStockGrains());
		
		

	  } catch (JAXBException e) {
		e.printStackTrace();
	  }

	}
}

