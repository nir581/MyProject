package model;

import java.util.Observer;

import model.domains.SearchDomain;
import tasks.Task;

public interface Model extends Task {
	void selectDomain(SearchDomain domain);				//change!!!!
	void selectAlgorithm(String algorithmName);
	void solveDomain();
	Solution getSolution();
	void addObserver(Observer o);	
	void stopDomain();
	
}
