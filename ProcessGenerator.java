import java.util.Random;

/**
 * Class that creates random Process objects
 * @author Keener
 *
 */

public class ProcessGenerator {

	private double probability;			//probability a process will be created per unit time (0.0 - no chance, 1.0 - perfect chance)
	Random rand;

	/**
	 * Constructor
	 * @param probability - desired probability to be checked per unit time
	 */
	
	public ProcessGenerator(double probability) {
		this.probability = probability;
		rand = new Random();
	}

	/**
	 * Decides whether a process should be made based off of given probability
	 * @return - true if probability event has occurred
	 */
	
	public boolean query() {

		boolean retVal = false;
		double chance = rand.nextDouble();			// generate number between 0.0 and 1.0

		if (chance <= probability){					//if that number is less than or equal to given probability, return true
			retVal = true;
		}

		return retVal;
	}
	
	/**
	 * Creates a new process. Randomly generates time it takes to process and priority level
	 * 
	 * @param currentTime - time the process has been made (not randomized)
	 * @param maxProcessTime - the max process time that can be generated
	 * @param maxLevel - the max priority level that can be generated
	 * @return
	 */

	public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {

		rand = new Random();

		int priority = rand.nextInt(maxLevel) + 1;
		int processTime = rand.nextInt(maxProcessTime) + 1;

		Process retVal = new Process(priority, processTime, currentTime);

		return retVal;
	}

}
