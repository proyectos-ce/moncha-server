package Stock;

import Structures.FoodType;
import javax.xml.bind.annotation.*;


@XmlRootElement
public class TestIngredient {
	private String name;
	private FoodType type;
	
	public TestIngredient(String name, FoodType type){
		setName(name);
		setType(type);
	}
	
	public TestIngredient(){
		
	}

	public String getName() {
		return name;
	}
	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	public FoodType getType() {
		return type;
	}
	@XmlAttribute
	public void setType(FoodType type) {
		this.type = type;
	}
	

}
