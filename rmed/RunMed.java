/*****************************************************
 * class RunMed
 * Implements a min heap and max using an ArrayList as underlying container
   to find the median of a stream of numbers
*****************************************************/

import java.util.ArrayList;

public class RunMed
{

    //instance vars
    private ALHeapMin minHeap;
    private ALHeapMax maxHeap;
    
    /*****************************************************
     * default constructor  ---  inits 2 empty heaps
     *****************************************************/
    public RunMed() {
	minHeap = new ALHeapMin();
	maxHeap = new ALHeapMax();
    }

    //main method for testing
    public static void main( String[] args )
    {

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class RunMed
