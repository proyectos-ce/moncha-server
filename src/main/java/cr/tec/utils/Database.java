package cr.tec.utils;

import cr.tec.struct.Dish;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import cr.tec.struct.Ingredient;
import cr.tec.struct.Message;
import cr.tec.struct.Suborder;
import cr.tec.utils.sort.BinarySearch;

/**
 * Created by joseph on 10/26/16.
 */
public class Database {

	private static XStream dishesWorker = new XStream();
	private static XStream ingredientsWorker = new XStream();
	private static boolean configured = false;

	static void configure() {
		if (!configured) {
			dishesWorker.alias("dish", Dish.class);
			dishesWorker.alias("dishes", LinkedList.class);
			dishesWorker.addImplicitCollection(LinkedList.class, "list");

			ingredientsWorker.alias("ingredient", Ingredient.class);
			ingredientsWorker.alias("ingredients", LinkedList.class);
			ingredientsWorker.addImplicitCollection(LinkedList.class, "list");


			configured = true;
		}


	}

	private static String getFile(String fileName) {

		StringBuilder result = new StringBuilder("");

		//Get file from resources folder
		ClassLoader classLoader = Database.class.getClassLoader();
		File file = new File(classLoader.getResource("db/" + fileName).getFile());

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();

	}

	private static void saveFile(String filename, String data) throws FileNotFoundException {
		String dir = Database.class.getResource("/db/").getFile();
		OutputStream os = new FileOutputStream(dir + filename);
		final PrintStream printStream = new PrintStream(os);
		printStream.println(data);
		printStream.flush();
		printStream.close();
	}

	public static void saveDishes(LinkedList<Dish> dishList) throws FileNotFoundException {
		String xml = dishesWorker.toXML(dishList);
		saveFile("dishes.xml", xml);

	}

	public static LinkedList<Dish> getDishes() {
		String xml = getFile("dishes.xml");
		return (LinkedList<Dish>)dishesWorker.fromXML(xml);
	}

	public static void saveIngredients(LinkedList<Ingredient> ingredientList) throws FileNotFoundException {
		String xml = ingredientsWorker.toXML(ingredientList);
		saveFile("ingredients.xml", xml);

	}

	public static LinkedList<Ingredient> getIngredients() {
		String xml = getFile("ingredients.xml");
		return (LinkedList<Ingredient>)ingredientsWorker.fromXML(xml);
	}

	public static Dish getDish(int id) {
		return BinarySearch.dishSearch(Database.getDishes(), id);
	}
}
