package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class SolutionManager {

	private HashMap<String, Solution> solutionsMap;
	private static SolutionManager instance = null;
	private static final String FILE_NAME = "resources/solutions.dat";
	
	protected SolutionManager() {							//Loads the Solutions file to the program
		solutionsMap = new HashMap<String, Solution>();
		File f = new File(FILE_NAME);
			try {
				if (f.isFile()) {
					BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
					ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
					solutionsMap = (HashMap<String, Solution>)in.readObject();
					br.close();
					in.close();
				}
			} catch (IOException e) {
				System.out.println("\nException Occurred: unvalid path to File");
			} catch (ClassNotFoundException e) {
				System.out.println("\nException Occurred: error reading from File");
			}
	}
		
	public static SolutionManager getInstance() {				//only one Instance
		
		if (instance == null)
			instance = new SolutionManager();
		return instance;
	}
	
	public void addSolution(Solution solution) {
		solutionsMap.put(solution.getProblemDescription(), solution);
	}
	
	public Solution getSolution(String problemDescription) {
		return solutionsMap.get(problemDescription);
	}
	
	public void saveSolutionsInFile() {							//saves the Solutions to a File
		FileOutputStream out = null;
		ObjectOutputStream oos = null;
		File f = new File(FILE_NAME);
		try {
			f.createNewFile();
			out = new FileOutputStream(FILE_NAME);
			oos = new ObjectOutputStream(out);
			oos.writeObject(solutionsMap);
		} catch (FileNotFoundException e) {
			System.out.println("\nException Occurred: unvalid path to File");
		} catch (IOException e) {
			System.out.println("\nException Occurred: error writing to File");
		} finally {
			try {
				out.close();
				oos.close();
			} catch (IOException e) {}
		}
	}
}
	

