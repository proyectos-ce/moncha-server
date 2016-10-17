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
	
	try {
		File file = new File("C:\\RestCHEF\\Fruits.xml");
		File file1 = new File("C:\\RestCHEF\\Vegetables.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Fruits.class, Vegetables.class, Ingredient.class, GenericList.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(stockFruits, file);
		jaxbMarshaller.marshal(stockVegetables, file1);
		
		jaxbMarshaller.marshal(stockFruits, System.out);
		jaxbMarshaller.marshal(stockVegetables, System.out);
		

	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
		
	}
	
	

}
