package model.algorithm;

import java.io.Serializable;

public class Action implements Serializable {
	//will represent an action taken in the domain. an action brings you from one state to another.

	private String description;
	private double cost;

	public Action() {}
	
	public Action(String description) {		//Ctor
		this.description=description;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		if (this.description == null)
			return 0;
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode(){					//for the HashMap
		return description.hashCode();
	}
	
	@Override
	public String toString(){
		return description;
	}
}
