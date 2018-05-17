/*****************************************************
 * class RunMed
 * Implements a min heap and max using an ArrayList as underlying container
   to find the median of a stream of numbers

Algo: 
1.) Add the upper half of the stream of Integers to the maxHeap and add the
    lower half of the stream of Integers to the minHeap. If the next value is
    < root of maxHeap, add the value to maxHeap. If not, add to minHeap.  

2.) Remove from maxHeap and add those removed values to minHeap until the 
    heaps are balanced ( size difference < 2 )

3.) If the heap sizes are = --> return the median of the roots of both heaps 
    If the heap sizes are != --> return the root of maxHeap 
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

    /*****************************************************
     * getMedian()  ---  returns the median from a stream of ints
     * Postcondition: Stream of ints remain unchanged
     *****************************************************/
    public Integer getMedian() {
    }
    
    /*****************************************************
     * add(Integer) 
     * Inserts an element in the appropiate heap
     * Postcondition: Tree exhibits appropiate heap property.
     *****************************************************/
    public void add( Integer newVal ) {
    }
    
    //main method for testing
    public static void main( String[] args )
    {
	RunMed beck = new RunMed();
	
	for (int i = 0; i < 5; i++) { // 5 total elements
	    Integer call = new Integer( (int) (Math.random() * 10) );
	    beck.add( call );
	}
	System.out.println( ALHeapMin );
	System.out.println( ALHeapMax );
	System.out.println( beck.getMedian() );

	for (int i = 0; i < 5; i++) { // 8 total elements
	    Integer bop = new Integer( (int) (Math.random() * 10) );
	    beck.add( bop );
	}
	System.out.println( ALHeapMin );
	System.out.println( ALHeapMax );
	System.out.println( beck.getMedian() );

	for (int i = 0; i < 5; i++) { // 15 total elements
	    Integer sha = new Integer( Math.pow( ((int) (Math.random() * 10)), 2 ) ); // square a random number
	    beck.add( sha );
	}
	System.out.println( ALHeapMin );
	System.out.println( ALHeapMax );
	System.out.println( beck.getMedian() );	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class RunMed
