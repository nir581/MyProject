package model.domains;

import java.util.HashMap;
import java.util.Random;

import model.algorithm.Action;
import model.algorithm.State;



public class EightPuzzleDomain implements SearchDomain {

	//please pay attention, the game is initialized with a Random Start State and the Goal State is always the same one.
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5556940048105306126L;
	private static final int size = 3;
	int puzzleStateSize;
	private EightPuzzleState start, goal;
	private final int numOfSwitches = 100;
	
	public EightPuzzleDomain() {}
	
	public EightPuzzleDomain(String args) {
		puzzleStateSize = size*size;
		this.goal = new EightPuzzleState("123456780");					//sets the Goal
		this.start = new EightPuzzleState(setPuzzle());					//sets a random Start
		System.out.println("Starting 8-Puzzle Game");
		System.out.println("Start Puzzle is:");
		System.out.println(start.getState().substring(0, size)+'\n'
							+start.getState().substring(size, 2*size)+'\n'
							+start.getState().substring(2*size, puzzleStateSize));
		System.out.println("Goal Puzzle is:");
		System.out.println(goal.getState().substring(0, size)+'\n'
				+goal.getState().substring(size, 2*size)+'\n'
				+goal.getState().substring(2*size, puzzleStateSize));
	}
	
	public int getPuzzleStateSize() {
		return puzzleStateSize;
	}

	public void setPuzzleStateSize(int puzzleStateSize) {
		this.puzzleStateSize = puzzleStateSize;
	}

	public EightPuzzleState getStart() {
		return start;
	}

	public void setStart(EightPuzzleState start) {
		this.start = start;
	}

	public EightPuzzleState getGoal() {
		return goal;
	}

	public void setGoal(EightPuzzleState goal) {
		this.goal = goal;
	}

	public static int getSize() {
		return size;
	}

	public int getNumOfSwitches() {
		return numOfSwitches;
	}

	@Override
	public State getStartState() {
		return start;
	}

	@Override
	public State getGoalState() {
		return goal;
	}
	
	public String setPuzzle() {
		String s = new String(goal.getState());
		String temp = new String(s);
		for (int i=1; i<numOfSwitches; i++) {
			//System.out.println("i is "+ i);
			//System.out.println("s is: "+s);
			Random r = new Random();
			int move = r.nextInt(4) + 1;	//will return an integer between 1-4, 4 different moves
				switch (move) {
					case 1: temp = moveUp(temp);
						if (!(temp.equals("FAILED"))) {	//if successed
							s = temp;							//set the new switched string temp to s				
							break; }
						else {
							temp = s;
							i--;
							break;
						}
					case 2: temp = moveDown(temp);
					if (!(temp.equals("FAILED"))) {	//if successed
						s = temp;							//set the new switched string temp to s				
						break; }
					else {
						temp = s;
						i--;
						break;
					}
					case 3: temp = moveLeft(temp);
					if (!(temp.equals("FAILED"))) {	//if successed
						s = temp;							//set the new switched string temp to s				
						break; }
					else {
						temp = s;
						i--;
						break;
					}
					case 4: temp = moveRight(temp);
					if (!(temp.equals("FAILED"))) {	//if successed
						s = temp;							//set the new switched string temp to s				
						break; }
					else {
						temp = s;
						i--;
						break;
					}
			}
		}
		return s;
	}
/*	
	public String setRandomPuzzleState() {
		StringBuilder s= new StringBuilder();
		Random r = new Random();
		r.nextInt(10);
		while (s.length()<puzzleStateSize) {								//runs 8 times for 8 number
			int randomNumber =(int)(Math.random()*puzzleStateSize) + 1;		//will return an integer between 1-9 including
			char randomChar = (char)('0'+randomNumber);
			if (s.indexOf(Character.toString(randomChar)) == -1)			//if the  numeric char is not already in s then append it
				s.append(randomChar);
		}
		int setNull = s.indexOf("9");										// the index of '9' in s will tell me where to place my 'N' (NULL)
		s.setCharAt(setNull, '0');
		return s.toString();
	}
*/
	public String moveUp(String s) {
		int indexOfN = s.indexOf('0');
		if (indexOfN < size)												//if 'N' is at index 0 / 1 / 2 (top row) => you can't move up
			return "FAILED";
		else {
			char[] chars = s.toCharArray();
			int newIndexOfN = indexOfN - size;								//if i want to moveUp the State, 'N' has to move to index of N - 3 (one row up)
			switchChars(chars, indexOfN, newIndexOfN);
			return new String(chars);
		}
	}
	
	public String moveDown(String s) {
		int indexOfN = s.indexOf('0');
		if (indexOfN > 2*size-1)											//if 'N' is at index 6 / 7 / 8 (bottom row) => you can't move down
			return "FAILED";
		else {
			char[] chars = s.toCharArray();
			int newIndexOfN = indexOfN + size;								//if i want to moveDown the State, 'N' has to move to index of N + 3 (one row down)
			switchChars(chars, indexOfN, newIndexOfN);
			return new String(chars);
		}
	}
	
	public String moveRight(String s) {
		int indexOfN = s.indexOf('0');
		if ((indexOfN % size) == 2)											//if 'N' is at index 2 / 5 / 8 (right column) => you can't move right
			return "FAILED";
		else {
			char[] chars = s.toCharArray();
			int newIndexOfN = indexOfN + 1;									//if i want to moveRight the State, 'N' has to move to index of N + 1 (one column right)
			switchChars(chars, indexOfN, newIndexOfN);
			return new String(chars);
		}
	}
	
	public String moveLeft(String s) {
		int indexOfN = s.indexOf('0');
		if ((indexOfN % size) == 0)											//if 'N' is at index 0 / 3 / 6 (left column) => you can't move left
			return "FAILED";
		else {
			char[] chars = s.toCharArray();
			int newIndexOfN = indexOfN - 1;									//if i want to moveLeft the State, 'N' has to move to index of N - 1 (one column left)
			switchChars(chars, indexOfN, newIndexOfN);
			return new String(chars);
		}
	}
	
	// switch two chars in array
	private void switchChars(char[] chars,int i, int j){
		char tmp=chars[i];
		chars[i]=chars[j];
		chars[j]=tmp;
	}
	
	@Override
	public HashMap<Action, State> getAllPossibleMoves(State current) {
		HashMap<Action, State> moves=new HashMap<>();
		String state=current.getState();
		Action a;
		MazeGameState newState;
		
		String up = moveUp(state);
		if (!up.equals("FAILED")) {
			a= new Action(state.substring(0, size)+'\n'+state.substring(size, 2*size)+'\n'
					+state.substring(2*size, puzzleStateSize)+'\n'+"moves UP");
			newState = new MazeGameState(up);
			double cost = getHiuristicValueOfState(newState, goal);
			a.setCost((int)(cost));
			moves.put(a, newState);
		}
				
		String down= moveDown(state);
		if (!down.equals("FAILED")) {
			a= new Action(state.substring(0, size)+'\n'+state.substring(size, 2*size)+'\n'
					+state.substring(2*size, puzzleStateSize)+'\n'+"moves DOWN");
			newState = new MazeGameState(down);
			double cost = getHiuristicValueOfState(newState, goal);
			a.setCost((int)(cost));
			moves.put(a, newState);
		}
			
		String right= moveRight(state);
		if (!right.equals("FAILED")) {
			a= new Action(state.substring(0, size)+'\n'+state.substring(size, 2*size)+'\n'
					+state.substring(2*size, puzzleStateSize)+'\n'+"moves RIGHT");
			newState = new MazeGameState(right);
			double cost = getHiuristicValueOfState(newState, goal);
			a.setCost((int)(cost));
			moves.put(a, newState);
		}
			
		String left= moveLeft(state);
		if (!left.equals("FAILED")) {
			a= new Action(state.substring(0, size)+'\n'+state.substring(size, 2*size)+'\n'
					+state.substring(2*size, puzzleStateSize)+'\n'+"moves LEFT");
			newState = new MazeGameState(left);
			double cost = getHiuristicValueOfState(newState, goal);
			a.setCost((int)(cost));
			moves.put(a, newState);
		}
		return moves;
	}

	@Override
	//G score
	public double getG(State s) {
		if (s.getCameFrom() == null)
		return 0;
		else
			return (s.getCameFrom().getgScore()+ s.getCameWithAction().getCost());
	}

	@Override
	//H function
	public double getHiuristicValueOfState(State state, State goal) {
		int sum=0;
		for(int i=0; i<puzzleStateSize; i++) {
			char c1=state.getState().charAt(i);
			char c2=goal.getState().charAt(i);
			if (c1 != c2)
				sum++;
		}
		return sum;
	}

	@Override
	public String getDomainDescription() {
		return ("EightPuzzle:Start "+start.getState());
	}

}
