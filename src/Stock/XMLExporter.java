package Stock;
import Food.Ingredient;
import Structures.GenericList;

import java.io.File;
import javax.xml.bind.*;

public class XMLExporter {
	public static void main(String[] args){
		Fruits stockFruits = new Fruits();
		Vegetables stockVegetables = new Vegetables();
		Milky stockMilky = new Milky();
		Grains stockGrains = new Grains();
	
	try {
		
		
		File file = new File("C:\\RestCHEF\\Server\\Fruits.xml");
		File file1 = new File("C:\\RestCHEF\\Server\\Vegetables.xml");
		File file2 = new File("C:\\RestCHEF\\Server\\Milky.xml");
		File file3 = new File("C:\\RestCHEF\\Server\\Grains.xml");
		
		
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Fruits.class, Vegetables.class, Grains.class, Milky.class, Ingredient.class, GenericList.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		

		jaxbMarshaller.marshal(stockFruits, file);
		jaxbMarshaller.marshal(stockVegetables, file1);
		jaxbMarshaller.marshal(stockMilky, file2);
		jaxbMarshaller.marshal(stockGrains, file3);
		
				

	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
		
	}
	
	

}
