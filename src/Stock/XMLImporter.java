package Stock;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import Food.Ingredient;
import Structures.GenericList;

public class XMLImporter {
	public static void main(String[] args) {

	 try {

		File file = new File("C:\\RestCHEF\\Fruits.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Fruits.class, Ingredient.class, GenericList.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Fruits stockFruits = (Fruits) jaxbUnmarshaller.unmarshal(file);
		System.out.println(stockFruits.getStockFruits());

	  } catch (JAXBException e) {
		e.printStackTrace();
	  }

	}
}

