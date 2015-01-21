package model.domains;

import java.io.Serializable;
import java.util.HashMap;

import model.algorithm.Action;
import model.algorithm.State;

// the expected functionality from a search problem 
public interface SearchDomain extends Serializable {
	
	State getStartState();
	State getGoalState();
	HashMap<Action,State> getAllPossibleMoves(State current);
	public double getG(State s);										//for G score
	public double getHiuristicValueOfState(State state, State goal);	//for H score		F = G + H
	String getDomainDescription();
	
}
