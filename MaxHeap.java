import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Implements an ArrayList-based maxHeap. 
 * 
 * @author Keener
 *
 * @param <T> Generic Type - requires an object that implements Comparable on itself
 */

public class MaxHeap<T extends Comparable<T>> {

	private ArrayList<T> heapArray;		//the underlying arrayList of the maxHeap
	private int size;					//size of the maxHeap

	/**
	 * Constructor - takes in an arrayList to build the maxHeap
	 * @param heapArray - arrayList to be used
	 */

	public MaxHeap(ArrayList<T> heapArray){

		size = heapArray.size();
		this.heapArray = heapArray;

	}

	/**
	 * Checks if a left child exists
	 * 
	 * @param parent index
	 * @return true if child exists
	 */


	public boolean hasLeftChild(int index){
		boolean retVal = size >= (index+1)*2;	// int+1 converts 0-based array to 1-based position, then checks for double that value to find left child

		return retVal;
	}

	/**
	 * Checks if a right child exists
	 * 
	 * @param parent index
	 * @return true if child exists
	 */

	public boolean hasRightChild(int index){
		boolean retVal = size >= ((index+1)*2) + 1; // int+1 converts 0-based array to 1-based position, then checks for double that value, plus one
		// to find left child

		return retVal;
	}

	/**
	 * Returns index of left child from a given parent index
	 * @param int - parent index
	 * @return int - child index
	 */

	public int getLeftChildIndex(int parentIndex){
		int retVal = 0;
		int position = parentIndex + 1;			//converts index to position (0 based to 1 based)

		if(hasLeftChild(parentIndex)){			//only occurs if LC exists

			retVal = position * 2;				//calculates position 
			retVal = retVal - 1;				//converts back to index

		} else {
			throw new NoSuchElementException("No left child");		//if no LC throw NSEE
		}

		return retVal;
	}

	/**
	 * Returns index of right child from a given parent index
	 * @param int - parent index
	 * @return int - child index
	 */

	public int getRightChildIndex(int parentIndex){
		int retVal = 0;
		int position = parentIndex + 1;				//converts index to position (0 based to 1 based)

		if(hasRightChild(parentIndex)){				//only occurs if RC exists

			retVal = (position * 2) + 1;			//calculate position of child
			retVal = retVal - 1;					//convert back to index

		} else {
			throw new NoSuchElementException("No right child");			//if no RC throw NSEE
		}

		return retVal;
	}

	/**
	 * Calculates index of parent
	 * 
	 * @param childIndex - index of child
	 * @return	int - index of parent
	 */

	public int getParent(int childIndex){
		int retVal = 0;
		int position = childIndex + 1;			//convert to position

		if(position != 1){						// as long as not first position

			retVal = position / 2;				//calculate position
			retVal = retVal - 1;				//convert to index

		} else {
			throw new NoSuchElementException("No parent");	//if position 1, throw NSEE
		}

		return retVal;

	}

	/**
	 * Checks a node and all descendants to make sure all values are in max-heap order
	 * 
	 * Recursively sorts through all descendants - call maxHeapify(0) to sort an entire array.
	 * 
	 * @param index - given index
	 */

	public void maxHeapify(int index){

		if(size != 0){								//only do if non-empty array
			T parent = heapArray.get(index);

			if(hasRightChild(index) && hasLeftChild(index)){			//if given node has both left and right children
				int rightIndex = getRightChildIndex(index);					
				int leftIndex = getLeftChildIndex(index);



				if (heapArray.get(rightIndex).compareTo(heapArray.get(leftIndex)) == 1){	//if right child is larger than left
					T child = heapArray.get(rightIndex);

					if(parent.compareTo(child) == -1){	//and right child is larger than parent

						heapArray.remove(index);			//remove the parent
						heapArray.add(index, child);		//add child in parent's position
						heapArray.remove(rightIndex);		//remove the original child
						heapArray.add(rightIndex, parent);	// add parent in child's position
					}

					maxHeapify(rightIndex);			//recursively check the children of this node
					maxHeapify(leftIndex);


				} else if (heapArray.get(rightIndex).compareTo(heapArray.get(leftIndex)) == -1){		//if left child is larger than right
					T child = heapArray.get(leftIndex);

					if(parent.compareTo(child) == -1){												//if left is larger than parent
						heapArray.remove(index);			//remove the parent
						heapArray.add(index, child);		//add child in parent's position
						heapArray.remove(leftIndex);		//remove the original child
						heapArray.add(leftIndex, parent);	// add parent in child's position
					}
					
					maxHeapify(rightIndex);			// recursively check children of this node
					maxHeapify(leftIndex);
				}

			} else if(!hasRightChild(index) && hasLeftChild(index)){		//if node only has left child
				int leftIndex = getLeftChildIndex(index);

				T child = heapArray.get(leftIndex);

				if(parent.compareTo(child) == -1){							//if left child is larger than parent
					heapArray.remove(index);			//remove the parent
					heapArray.add(index, child);		//add child in parent's position
					heapArray.remove(leftIndex);		//remove the original child
					heapArray.add(leftIndex, parent);	// add parent in child's position
				}
				
				maxHeapify(leftIndex);				//recursively check the child of this node



			}
		}
	}
	
	/**
	 * provides underlying ArrayList to modify
	 * @return	ArrayList used as maxHeap
	 */

	public ArrayList<T> getHeapArray(){
		return heapArray;
	}

	/**
	 * Rebuilds the entire max heap - same as calling maxHeapify(0)
	 */
	
	public void buildMaxHeap(){
		if(size != 0){
			maxHeapify(0);
		}
	}

}
