package cr.tec.rest;

import com.sun.research.ws.wadl.Link;
import cr.tec.struct.Ingredient;
import cr.tec.struct.Message;
import cr.tec.struct.Role;
import cr.tec.utils.Database;
import cr.tec.utils.security.Secured;
import cr.tec.utils.sort.*;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by joseph on 10/29/16.
 */
@Path("/ingredients")
public class IngredientsApi {


	@GET
	@Secured()
	@Produces({MediaType.APPLICATION_JSON})
	public LinkedList<Ingredient> getIngredients() {
		try {
			return Database.getIngredients();
		} catch (Exception e) {
			// Regresa lista vacía en lugar de error si no hay Ingredients
			return new LinkedList<Ingredient>();
		}
	}

	@GET
	@Path("/type/{type}")
	@Secured()
	@Produces({MediaType.APPLICATION_JSON})
	public LinkedList<Ingredient> getIngredients(@PathParam("type") String type) {
		LinkedList<Ingredient> list;
		LinkedList<Ingredient> finalList = new LinkedList<>();
		try {
			list = Database.getIngredients();
		} catch (Exception e) {
			// Regresa lista vacía en lugar de error si no hay Ingredients
			return new LinkedList<Ingredient>();
		}

		for (Ingredient item : list) {
			if (Objects.equals(item.getType().toString().toLowerCase(), type.toLowerCase().trim())) {
				finalList.add(item);
			}
		}

		if (Objects.equals(type, "vegetable")) {
			return Shell.shellSort(finalList);
		} else if (Objects.equals(type, "meat")) {
			return Insertion.insertionSort(finalList);
		} else if (Objects.equals(type, "fruits")) {
			return Quick.quickSort(finalList);
		} else if (Objects.equals(type, "grains")) {
			return Radix.radixSort(finalList);
		} else if (Objects.equals(type, "milky")) {
			return Bubble.bubbleSort(finalList);
		}

		return null;



	}

	@GET
	@Secured()
	@Path("{id}")
	@Produces("application/json")
	public Response getIngredient(@PathParam("id") int id) {
		LinkedList<Ingredient> ingredientList = Database.getIngredients();
		Ingredient result = BinarySearch.ingredientSearch(ingredientList, id);
		if (result != null) {
			return Response.ok(result).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity(new Message("error", "Ingredient not found.")).build();
		}
	}

	@POST
	@Secured
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Message createIngredient(Ingredient newIngredient) {
		LinkedList<Ingredient> ingredientList = null;
		try {
			ingredientList = Database.getIngredients();
		} catch (Exception ignored) {
			ingredientList = new LinkedList<Ingredient>();
		}
		try {
			newIngredient.setId(ingredientList.getLast().getId() + 1);
		} catch (Exception e) {
			newIngredient.setId(1);
		}

		ingredientList.add(newIngredient);

		try {
			Database.saveIngredients(ingredientList);
			return new Message("ok", "Ingredient (" + newIngredient + ") added successfully.");
		} catch (FileNotFoundException e) {
			return new Message("error", "An error occured while adding the ingredient.");
		}

	}

	@DELETE
	@Secured()
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Message deleteIngredient(@PathParam("id") int id) throws FileNotFoundException {
		LinkedList<Ingredient> ingredientList = Database.getIngredients();
		for (Ingredient item : ingredientList) {
			if (item.getId() == id) {
				ingredientList.remove(item);
				Database.saveIngredients(ingredientList);
				return new Message("ok", "Ingredient deleted successfully.");
			}
		}
		return new Message("error", "Ingredient not found.");
	}

	@POST
	@Secured()
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Message updateIngredient(Ingredient updatedIngredient, @PathParam("id") int id) throws FileNotFoundException {
		LinkedList<Ingredient> ingredientList = Database.getIngredients();
		for (Ingredient oldIngredient : ingredientList) {
			if (oldIngredient.getId() == id) {
				oldIngredient.setName(updatedIngredient.getName());
				oldIngredient.setQuantity(updatedIngredient.getQuantity());
				oldIngredient.setType(updatedIngredient.getType());

				Database.saveIngredients(ingredientList);
				return new Message("ok", "Ingredient updated successfully.");
			}
		}
		return new Message("error", "Ingredient not found.");
	}
}
