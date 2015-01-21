package model.algorithm;

import java.util.ArrayList;

import model.domains.SearchDomain;

public interface Searcher {

	public ArrayList<Action> search(SearchDomain domain);
	public void stopSearch();
}
