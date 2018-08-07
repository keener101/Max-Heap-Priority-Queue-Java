
/**
 * Represents a single Process for a CPU simulation
 * 
 * @author Keener
 *
 */

public class Process implements Comparable<Process> {

	private int priority;				//current priority of the process. Greater numbers have higher priority
	private int timeRemaining;			//time remaining to finish computing the process
	private int arrivalTime;			//when the process entered the priority queue
	private int timeNotProcessed;		//how much unit time has passed since the process entered without being computed

	
	/**
	 * Constructor
	 * 
	 * @param pLevel -priority level of the process
	 * @param timeToFinish	- time to take this process to finish
	 * @param arrivalTime	- when process was made
	 */
	
	public Process (int pLevel, int timeToFinish, int arrivalTime){
		this.priority = pLevel;
		this.timeRemaining = timeToFinish;
		this.arrivalTime = arrivalTime;
		timeNotProcessed = 0;
	}

	/**
	 * Increments the priority of this process by one
	 */
	
	public void incrementPriority(){
		priority++;
	}
	
	/**
	 * returns the priority of the process
	 * @return int for priority
	 */

	public int getPriority() {
		int retVal = priority;
		return retVal;
	}
	
	/**
	 * sets priority
	 * @param pLevel - desired priority
	 */

	public void setPriority(int pLevel) {
		this.priority = pLevel;
	}

	/**
	 * returns the time remaining for this process
	 * @return int for time remaining
	 */
	public int getTimeRemaining() {
		int retVal = timeRemaining;
		return retVal;
	}
	
	/**
	 * sets time remaining
	 * @param timeToFinish - desired value
	 */

	public void setTimeRemaining(int timeToFinish) {
		this.timeRemaining = timeToFinish;
	}

	
	/**
	 * returns arrival time of process
	 * @return - int value
	 */
	public int getArrivalTime() {
		int retVal = arrivalTime;
		return retVal;
	}

	/**
	 * set arrival time of process
	 * @param arrivalTime - int of desired value
	 */
	
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * Compares this process to another process. Uses priority time - larger priority > smaller priority
	 * 
	 * @return if this object has larger priority, return 1. if smaller, -1. if equal, 0.
	 */
	
	@Override
	public int compareTo(Process otherProcess) {
		int retVal = 0;

		if (priority > otherProcess.getPriority()){
			retVal = 1;
		} else if (priority < otherProcess.getPriority()){
			retVal = -1;
		}

		return retVal;
	}

	/**
	 * Allows for a tick of unit time to be simulated during computation
	 * 
	 * 
	 */
	
	public void reduceTimeRemaining(){
		timeRemaining--;
	}

	/**
	 * Checks if a process is finished
	 * @return true if finished
	 */
	
	public boolean finish() {

		boolean retVal = false;

		if (timeRemaining == 0){
			retVal = true;;
		} 

		return retVal;


	}
	
	/**
	 * resets the time in which a process has not been computed to zero (ie "touch" a process)
	 */

	public void resetTimeNotProcessed() {
		timeNotProcessed = 0;		
	}

	/**
	 * returns the time a process has sat without being computed
	 * @return int unit time it has sat
	 */
	
	public int getTimeNotProcessed(){
		int retVal = timeNotProcessed;

		return retVal;
	}


}
