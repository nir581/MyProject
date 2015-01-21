package model;

import java.util.HashMap;

import model.algorithm.Astar;
import model.algorithm.BFS;
import model.algorithm.Searcher;

public class SearchAlgorithmsFactory {
	
	HashMap<String, Creator> AlgorithmsCreator;
	
	public SearchAlgorithmsFactory() {	
		AlgorithmsCreator = new HashMap<String, Creator>();
		AlgorithmsCreator.put("Astar", new AstarCreator());
		AlgorithmsCreator.put("BFS", new BFSCreator());
	}
		
	public Searcher createSearcherAlgorithm(String searcherType) {	
		Creator c = AlgorithmsCreator.get(searcherType);
		if (c != null)
			return c.CreateSearcher();
		return null;
	}
	
	//InterFace Creator, 1 method
	private interface Creator { public Searcher CreateSearcher(); }		
	
	//implementations of Creator:
	private class BFSCreator implements Creator {
		@Override
		public Searcher CreateSearcher() { return new BFS(); } }		//BFSCreator, 1 method returns BFS			
		
	private class AstarCreator implements Creator {									
		@Override
		public Searcher CreateSearcher() { return new Astar(); } }		//AstarCreator, 1 method returns Astar
	
}