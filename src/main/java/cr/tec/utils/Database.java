package cr.tec.utils;

import cr.tec.struct.Dish;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;

/**
 * Created by joseph on 10/26/16.
 */
public class Database {

	private static XStream dishesWorker = new XStream();
	private static boolean configured = false;

	public static void configure() {
		if (!configured) {
			dishesWorker.alias("dish", Dish.class);
			dishesWorker.alias("dishes", ArrayList.class);
			dishesWorker.addImplicitCollection(ArrayList.class, "list");
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
		printStream.close();
	}

	public static void saveDishes(ArrayList<Dish> dishList) throws FileNotFoundException {
		String xml = dishesWorker.toXML(dishList);
		saveFile("dishes.xml", xml);

	}

	public static ArrayList<Dish> getDishes() {
		String xml = getFile("dishes.xml");
		return (ArrayList<Dish>)dishesWorker.fromXML(xml);
	}
}
