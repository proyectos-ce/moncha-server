package cr.tec.rest;

import cr.tec.struct.Dish;
import cr.tec.struct.Message;
import cr.tec.utils.Database;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joseph on 10/26/16.
 */

@Path( "/dishes" )
public class DishesApi {


	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Dish> getMenu() {
		ArrayList<Dish> menu = Database.getDishes();
		return menu;
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Dish getDish(@PathParam("id") int id) {
		ArrayList<Dish> menu = Database.getDishes();
		return menu.get(id);
	}

	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Message createDish(@FormParam("name") String name) {
		Dish newDish = new Dish();
		newDish.setName(name);

		ArrayList<Dish> menu = Database.getDishes();
		menu.add(newDish);

		Database.saveDishes(menu);

		return new Message("ok", "Dish (" + newDish + ") added successfully.");

	}

}
