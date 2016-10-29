package cr.tec.rest;

import cr.tec.struct.Dish;
import cr.tec.struct.Message;
import cr.tec.utils.Database;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 * Created by joseph on 10/26/16.
 */

@Path( "/dishes" )
public class DishesApi {


	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public LinkedList<Dish> getMenu() {
		LinkedList<Dish> menu = Database.getDishes();
		return menu;
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Response getDish(@PathParam("id") int id) {
		LinkedList<Dish> menu = Database.getDishes();
		for (Dish item: menu) {
			if (item.getId()==id) {
				return Response.ok(item).build();
			}
		}
		return Response.status(Response.Status.NOT_FOUND).entity(new Message("error", "Dish not found.")).build();
	}

	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Message createDish(Dish newDish) {
		LinkedList<Dish> menu = Database.getDishes();

		try {
			newDish.setId(menu.getLast().getId() + 1);
		} catch (Exception e) {
			newDish.setId(1);
		}

		menu.add(newDish);

		try {
			Database.saveDishes(menu);
			return new Message("ok", "Dish (" + newDish + ") added successfully.");
		} catch (FileNotFoundException e) {
			return new Message("error", "An error occured while adding the dish.");
		}

	}

	@DELETE
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Message deleteDish(@PathParam("id") int id) throws FileNotFoundException {
		LinkedList<Dish> menu = Database.getDishes();
		for (Dish item: menu) {
			if (item.getId()==id) {
				menu.remove(item);
				Database.saveDishes(menu);
				return new Message("ok", "Dish deleted successfully.");
			}
		}
		return new Message("error", "Dish not found.");
	}

	@POST
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Message updateDish(Dish updatedDish, @PathParam("id") int id) throws FileNotFoundException {
		LinkedList<Dish> menu = Database.getDishes();
		for (Dish oldDish: menu) {
			if (oldDish.getId()==id) {
				oldDish.setName(updatedDish.getName());
				oldDish.setPrice(updatedDish.getPrice());
				oldDish.setRecipe(updatedDish.getRecipe());
				oldDish.setIngredientsList(updatedDish.getIngredientsList());
				oldDish.setPrepTime(updatedDish.getPrepTime());
				oldDish.setNutValue(updatedDish.getNutValue());
				Database.saveDishes(menu);
				return new Message("ok", "Dish updated successfully.");
			}
		}
		return new Message("error", "Dish not found.");
	}


	@GET
	@Path("/fake")
	@Produces({MediaType.APPLICATION_JSON})
	public Response fakeDishes() {
		String data = "[\n" +
				"\t{\n" +
				"\t\t\"id\": 1,\n" +
				"\t\t\"title\": \"Pizza\",\n" +
				"\t\t\"summary\": \" Fresca con ingrediantes organicos\",\n" +
				"\t\t\"price\": 100,\n" +
				"\t\t\"totalTime\": 30,\n" +
				"\t\t\"ingredients\": [\n" +
				"\t\t\t\"1\",\n" +
				"\t\t\t\"2\",\n" +
				"\t\t\t\"3\"\n" +
				"\t\t],\n" +
				"\t\t\"recipie\": [\n" +
				"\t\t\t{\n" +
				"\t\t\t\t\"title\": \"Batir\",\n" +
				"\t\t\t\t\"estimatedTime\": 10,\n" +
				"\t\t\t\t\"instruction\": \" Batir lentamente \"\n" +
				"\t\t\t},\n" +
				"\t\t\t{\n" +
				"\t\t\t\t\"title\": \"Picar vegetales\",\n" +
				"\t\t\t\t\"estimatedTime\": 3,\n" +
				"\t\t\t\t\"instruction\": \"Picar finamente el tomate\"\n" +
				"\t\t\t},\n" +
				"\t\t\t{\n" +
				"\t\t\t\t\"title\": \"Hornear\",\n" +
				"\t\t\t\t\"estimatedTime\": 20,\n" +
				"\t\t\t\t\"instruction\": \"Meter al hornor precalentado a 300 grados, por 10 minutos\"\n" +
				"\t\t\t}\n" +
				"\t\t]\n" +
				"\t},\n" +
				"\t{\n" +
				"\t\t\"id\": 2,\n" +
				"\t\t\"title\": \"Brownie\",\n" +
				"\t\t\"summary\": \"especial 420\",\n" +
				"\t\t\"price\": 420,\n" +
				"\t\t\"totalTime\": 20,\n" +
				"\t\t\"ingredients\": [\n" +
				"\t\t\t\"4\",\n" +
				"\t\t\t\"5\",\n" +
				"\t\t\t\"6\"\n" +
				"\t\t],\n" +
				"\t\t\"recipie\": [\n" +
				"\t\t\t{\n" +
				"\t\t\t\t\"title\": \"Batir\",\n" +
				"\t\t\t\t\"estimatedTime\": 10,\n" +
				"\t\t\t\t\"instruction\": \" Batir huevos y chocolate organico \"\n" +
				"\t\t\t},\n" +
				"\t\t\t{\n" +
				"\t\t\t\t\"title\": \"Hornear\",\n" +
				"\t\t\t\t\"estimatedTime\": 20,\n" +
				"\t\t\t\t\"instruction\": \"Meter al hornor precalentado a 150 grados, por 10 minutos\"\n" +
				"\t\t\t}\n" +
				"\t\t]\n" +
				"\t},\n" +
				"\t{\n" +
				"\t\t\"id\": 3,\n" +
				"\t\t\"title\": \"Sopa\",\n" +
				"\t\t\"summary\": \"Para el dia siguiente\",\n" +
				"\t\t\"price\": 400,\n" +
				"\t\t\"totalTime\": 25,\n" +
				"\t\t\"ingredients\": [\n" +
				"\t\t\t\"7\",\n" +
				"\t\t\t\"8\",\n" +
				"\t\t\t\"9\"\n" +
				"\t\t],\n" +
				"\t\t\"recipie\": [\n" +
				"\t\t\t{\n" +
				"\t\t\t\t\"title\": \"Picar\",\n" +
				"\t\t\t\t\"estimatedTime\": 10,\n" +
				"\t\t\t\t\"instruction\": \" Picar vegetales frescos\"\n" +
				"\t\t\t},\n" +
				"\t\t\t{\n" +
				"\t\t\t\t\"title\": \"hervir pasta\",\n" +
				"\t\t\t\t\"estimatedTime\": 15,\n" +
				"\t\t\t\t\"instruction\": \"Poner en aguar hiviendo la pasta\"\n" +
				"\t\t\t},\n" +
				"\t\t\t{\n" +
				"\t\t\t\t\"title\": \"Mezclar\",\n" +
				"\t\t\t\t\"estimatedTime\": 5,\n" +
				"\t\t\t\t\"instruction\": \"Mezclar la pasta y vegetales en una taza\"\n" +
				"\t\t\t}\n" +
				"\t\t]\n" +
				"\t}\n" +
				"]";

		return Response.status(200).entity(data).type(MediaType.APPLICATION_JSON).build();

	}

}
