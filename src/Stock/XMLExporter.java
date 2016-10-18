package Stock;
import Food.Ingredient;
import Structures.FoodType;
import Structures.GenericList;

import java.io.File;
import javax.xml.bind.*;

public class XMLExporter {
	public static void main(String[] args){
		Fruits stockFruits = new Fruits();
		Vegetables stockVegetables = new Vegetables();
		Milky stockMilky = new Milky();
	
	try {
		
		
		File file = new File("C:\\RestCHEF\\Server\\Fruits.xml");
		File file1 = new File("C:\\RestCHEF\\Server\\Vegetables.xml");
		File file2 = new File("C:\\RestCHEF\\Server\\Milky.xml");
		
		
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Fruits.class, Vegetables.class, Milky.class, Ingredient.class, GenericList.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		

		jaxbMarshaller.marshal(stockFruits, file);
		jaxbMarshaller.marshal(stockVegetables, file1);
		jaxbMarshaller.marshal(stockMilky, file2);
		
				

	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
		
	}
	
	

}
