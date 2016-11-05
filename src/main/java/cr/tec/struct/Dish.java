package cr.tec.struct;

import cr.tec.utils.Database;

import java.util.LinkedList;

/**
 * Created by Jimena on 10/26/16.
 */

/**
 * 
 * @author Jimena
 *
 */
public class Dish {
	private double price;
	private int nutValue, prepTime;
	private LinkedList<Ingredient> ingredientsList;
	private LinkedList<RecipeStep> recipe;
	private String name;
	private int id;
/**
 * Empty constructor
 */
	public Dish() {
		this("null");
	}
/*
 * Constructor that takes only the number of the dish
 */
	public Dish(String name) {
		this.name = name;
		this.price = 0;
		this.nutValue = 0;
		this.prepTime = 0;
		this.ingredientsList = new LinkedList<Ingredient>();
		this.recipe = new LinkedList<RecipeStep>();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
/**
 * Adds an ingredient to the list of ingredients from the stock
 * @param newIngredient  Ingredient from the stock
 */
	public void addIngredient(Ingredient newIngredient) {
		ingredientsList.addFirst(newIngredient);
	}
/**
 * Creates a new ingredient and adds it to the list of ingredients of the stock
 * @param ingredientName name for the new ingredient
 * @param type cathegory of the new ingredient
 * @param quantity the amount of the ingredient that needs tha dish
 */
	public void addIngredient(String ingredientName, FoodType type, int quantity) {
		Ingredient newIngre = new Ingredient(type, ingredientName, quantity);
		ingredientsList.addFirst(newIngre);
	}
/**
 * Adds a new step for the recipe of the dish
 * @param title the title of the step
 * @param description description of the step
 * @param approximatedTime time that it will take to finish the step
 */
	public void addRecipeStep(String title, String description, double approximatedTime) {
		RecipeStep newStep = new RecipeStep(title, description, approximatedTime);
		recipe.addLast(newStep);
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNutValue() {
		return nutValue;
	}

	public void setNutValue(int nutValue) {
		this.nutValue = nutValue;
	}

	public int getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}

	public LinkedList<Ingredient> getIngredientsList() {
		return ingredientsList;
	}

	public void setIngredientsList(LinkedList<Ingredient> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<RecipeStep> getRecipe() {
		return recipe;
	}

	public void setRecipe(LinkedList<RecipeStep> recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		String result = "Dish's name: " + getName();
		return result;
	}


}
