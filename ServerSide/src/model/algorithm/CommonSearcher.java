package model.algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;


public abstract class CommonSearcher implements Searcher{				//the common for all Searchers
	
	protected volatile boolean stop=false;								//for the stopSearch()
	protected PriorityQueue<State> openSet=new PriorityQueue<State>();	
	protected  ArrayList<State> closedSet = new ArrayList<State>();
	
	protected ArrayList<Action> reconstrucePath(State cameFrom, State goal) {		//finds us the Path from start to goal
		ArrayList<Action> totalPath= new ArrayList<Action>();
		if(goal.getCameWithAction() == null)									//if we got to the goal with no action, therefore goal==start
			return null;	
		totalPath.add(goal.getCameWithAction());
		while (cameFrom.getCameFrom() != null) {
			totalPath.add(0, cameFrom.getCameWithAction());
			cameFrom=cameFrom.getCameFrom();
		}
		return totalPath;
	}
}
