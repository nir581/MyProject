package model.domains; 

import java.util.HashMap;

public class SearchDomainFactory {

	HashMap<String, Creator> DomainsCreator;
	
	public SearchDomainFactory() {
		DomainsCreator = new HashMap<String, Creator>();
		DomainsCreator.put("Maze", new MazeCreator());
		DomainsCreator.put("Puzzle", new PuzzleCreator());
	}
		
	public SearchDomain createSearchDomain(String domainName, String args) {
		Creator c = DomainsCreator.get(domainName);
		if (c != null)
			return c.CreateDomain(args);
		return null;
	}
	
	//InterFace Creator, 1 method
	private interface Creator { public SearchDomain CreateDomain(String args); }		
	
	//implementations of Creator:
	private class PuzzleCreator implements Creator {
		@Override	
		public SearchDomain CreateDomain(String args) { return new EightPuzzleDomain(args); } }
	
	private class MazeCreator implements Creator {
		@Override
		public SearchDomain CreateDomain(String args) {  return new MazeGameDomain(args); } }
}
