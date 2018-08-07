import java.util.ArrayList;

/**
 * Represents a Priority Queue. Wraps a max heap of Process objects
 * 
 * @author Keener
 *
 */

public class PQueue {

	MaxHeap<Process> pq;			//MaxHeap of processes
	
	/**
	 * Constructor, takes no parameters
	 */
	
	public PQueue(){
		pq = new MaxHeap<>(new ArrayList<Process>());		
	}
	
	/**
	 * Adds a process to the priority queue, and sorts it
	 * @param myProcess - process to be added
	 */

	public void enPQueue(Process myProcess){
		pq.getHeapArray().add(myProcess);
		pq.maxHeapify(0);
	}
	
	/**
	 * Removes the highest priority process from the queue and resorts the queue
	 * @return
	 */

	public Process dePQueue(){
		
		Process retVal = pq.getHeapArray().remove(0);
		pq.maxHeapify(0);

		return retVal;
	}
	
	/**
	 * Cycles through each Process in the queue and checks if the priority should be increased
	 * 
	 * @param timeToIncrementPriority	- time a process must sit before being incremented
	 * @param maxLevel	- max priority level
	 */

	public void update(int timeToIncrementPriority, int maxLevel) {
		if(!isEmpty()){

			for (int i = 0; i < pq.getHeapArray().size(); i++){			//for each process

				Process currentProcess = pq.getHeapArray().get(i);		

				if (currentProcess.getTimeNotProcessed() >= timeToIncrementPriority && currentProcess.getPriority() < maxLevel){	//check if time has passed and is not at max level

					currentProcess.incrementPriority();				//increments priority level
					currentProcess.resetTimeNotProcessed();			//resets incremental counter

				}
			}
		}

	}
	
	/**
	 * Checks to see if the priority queue is empty
	 * @return true if empty
	 */

	public boolean isEmpty() {

		boolean retVal = false;

		if(pq.getHeapArray().size() == 0){
			retVal = true;
		}

		return retVal;
	}

}
