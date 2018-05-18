/*****************************************************
 * class RunMed
 * Implements a min heap and max using an ArrayList as underlying container
   to find the median of a stream of numbers

Algo: 
1.) Add the upper half of the stream of Integers to the bigVals and add the
    lower half of the stream of Integers to the lilVals. If the next value is
    < root of bigVals, add the value to bigVals. If not, add to lilVals.  

2.) Remove from bigVals and add those removed values to lilVals until the 
    heaps are balanced ( size difference < 2 )

3.) If the heap sizes are = --> return the median of the roots of both heaps 
    If the heap sizes are != --> return the root of bigVals 
*****************************************************/

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class RunMed
{

    //instance vars
    private ALHeapMin lilVals;
    private ALHeapMax bigVals;
    
    /*****************************************************
     * default constructor  ---  inits 2 empty heaps
     *****************************************************/
    public RunMed() {
	lilVals = new ALHeapMin();
	bigVals = new ALHeapMax();
    }

    /*****************************************************
     * getMedian()  ---  returns the median from a stream of ints
     * Postcondition: Stream of ints remain unchanged
     *****************************************************/
    public double getMedian() {
	double med;
        if (bigVals.size() == 0){
	    throw new NoSuchElementException();
	}if (bigVals.size() == lilVals.size()){
	    med = (bigVals.peekMax() + lilVals.peekMin()) / 2.0;
	}else{
	    med = bigVals.peekMax();
	}
        return med;
    }
    
    /*****************************************************
     * add(Integer) 
     * Inserts an element in the appropiate heap
     * Postcondition: Tree exhibits appropiate heap property.
     *****************************************************/
    public void add( Integer newVal ) {
	if( bigVals.size() == 0){
	    bigVals.add(newVal);
	}else if( newVal < bigVals.peekMax()){
	    bigVals.add(newVal);
	}else{
	    lilVals.add(newVal);
	}
	if( Math.abs(bigVals.size() - lilVals.size()) >= 2){
	    if( lilVals.size() <= bigVals.size()){
		lilVals.add(bigVals.removeMax());
	    }else{
		bigVals.add(lilVals.removeMin());
	    }
	}
    }
    
    //main method for testing
    /*
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
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	}//end main()*/
}//end class RunMed
