package Stock;
import Food.Ingredient;
import Structures.FoodType;
import Structures.GenericList;

import java.io.File;
import javax.xml.bind.*;

public class XMLExporter {
	public static void main(String[] args){
		Fruits stockFruits = new Fruits();
	
	try {
		File file = new File("C:\\RestCHEF\\Fruits.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Fruits.class, Ingredient.class, GenericList.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(stockFruits, file);
		jaxbMarshaller.marshal(stockFruits, System.out);

	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
		
	}
	
	

}
