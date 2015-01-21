package model.algorithm;

import java.io.Serializable;

public abstract class State implements Comparable<State>, Serializable {			//represent an abstract state in a game

	private String state;    		// a state is represented by a string
	private double gScore;
	private State cameFrom;
	private Action cameWithAction;
	private double fScore;
	
	public State() {}
	
	public State(String state) {    // CTOR    
        this.state = state;
    }

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getgScore() {
		return gScore;
	}

	public void setgScore(double gScore) {
		this.gScore = gScore;
	}

	public State getCameFrom() {
		return cameFrom;
	}

	public void setCameFrom(State cameFrom) {
		this.cameFrom = cameFrom;
	}

	public Action getCameWithAction() {
		return cameWithAction;
	}

	public void setCameWithAction(Action cameWithAction) {
		this.cameWithAction = cameWithAction;
	}

	public double getfScore() {
		return fScore;
	}

	public void setfScore(double fScore) {
		this.fScore = fScore;
	}

	@Override
    public boolean equals(Object obj){ 		
        return state.equals(((State)obj).state);
    }
    
	@Override
    public String toString() {
    	return this.state;
    }
 
    @Override
	public int compareTo(State state)
	{
		if (this.getfScore() > state.getfScore())			//if myF (this.F) is bigger put it at the bottom (it losses)
			return 1;										//the Priority Queue puts the Max val at the top
		else if (this.getfScore() < state.getfScore())
			return -1;
		return 0;
	}
}