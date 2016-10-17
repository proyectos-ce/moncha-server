package Food;

import Structures.FoodType;
import Structures.GenericList;
import Structures.RecipeStep;

public class Dish {
	private double price;
	private int nutValue, prepTime;
	private  GenericList<Ingredient> ingredientsList;
	private GenericList<RecipeStep> recipe;
	private String name;
	
	public Dish(String name){
		this.name=name;
		this.price = 0;
		this.nutValue = 0;
		this.prepTime = 0;
		this.ingredientsList = new GenericList<Ingredient>();
		this.recipe = new GenericList<RecipeStep>();
		
	}
	
	public void addIngredient(String ingredientName, FoodType type, int quantity){
		Ingredient newIngre = new Ingredient(type, ingredientName, quantity);
		ingredientsList.addFirst(newIngre);
	}
	
	public void addRecipeStep(String title, String description, double d){
		RecipeStep newStep = new RecipeStep(title, description,d);
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

	public GenericList<Ingredient> getIngredientsList() {
		return ingredientsList;
	}

	public void setIngredientsList(GenericList<Ingredient> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GenericList<RecipeStep> getRecipe() {
		return recipe;
	}

	public void setRecipe(GenericList<RecipeStep> recipe) {
		this.recipe = recipe;
	}


	
	
}
