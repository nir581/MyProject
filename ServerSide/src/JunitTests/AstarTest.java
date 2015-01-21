package JunitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import model.algorithm.Action;
import model.algorithm.Astar;
import model.algorithm.Searcher;
import model.domains.MazeGameDomain;
import model.domains.SearchDomain;

import org.junit.Test;

public class AstarTest {

	@Test
	public void test() {

		SearchDomain domain=new MazeGameDomain("(0,0) (1,1) 2 0");
		
		Searcher s = new Astar();
		
		ArrayList<Action> actions=s.search(domain);
		
		assertEquals(2, actions.size());				
		
		assertTrue(actions.get(0).toString().equals("(0,0) moves RIGHT"));
		assertTrue(actions.get(1).toString().equals("(0,1) moves DOWN"));
	}

}
