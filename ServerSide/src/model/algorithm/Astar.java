package model.algorithm;

import java.util.ArrayList;
import java.util.HashMap;

import model.domains.SearchDomain;



public class Astar extends CommonSearcher {			//Algorithm #1 Astar

	public Astar() {
		System.out.println("------------------------");
		System.out.println("Astar Algorithm Chosen");
		System.out.println("------------------------");
	}
	@Override
	public ArrayList<Action> search(SearchDomain domain) {
		System.out.println("Activating Astar Search Method");
		State start=domain.getStartState();
		State goal=domain.getGoalState();
		start.setgScore(domain.getG(start));
		start.setCameWithAction(null);
		start.setfScore(start.getgScore() + domain.getHiuristicValueOfState(start, goal));
		
		openSet.add(start);
		while (!openSet.isEmpty() && !stop) {
			State current=openSet.peek();
			if (current.equals(goal))
				return (reconstrucePath(current.getCameFrom(), current));
			openSet.remove(current);
			closedSet.add(current);
			HashMap<Action, State> nextStates = domain.getAllPossibleMoves(current);
			for (Action a : nextStates.keySet()) {		
				State neighbor = nextStates.get(a);
				if (closedSet.contains(neighbor))
					continue;
				double tentativeGScore=current.getgScore() + a.getCost();
				if ( !openSet.contains(neighbor) || (tentativeGScore < neighbor.getgScore()) ) {
					neighbor.setCameFrom(current);
					neighbor.setgScore(tentativeGScore);
					neighbor.setfScore(neighbor.getgScore() + domain.getHiuristicValueOfState(neighbor, goal));
					neighbor.setCameWithAction(a);
					if (!openSet.contains(neighbor))
						openSet.add(neighbor);
				}
			}
		}
		return null;	//FAILURE!!!!
	}
	
	@Override
	public void stopSearch() {	//stops the search()
		this.stop=true;
		
	}
}
