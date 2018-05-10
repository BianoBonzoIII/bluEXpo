//bluEXpo - Brandon Chong, William Lu, Brian Lin
//APCS pd 2
//Lab 3

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {

    private ArrayList<String> _queue;

    // End --> Right   Front --> Left 
    public ArrayPriorityQueue() {
	_queue = new ArrayList<String>();
    }

    // Adds element to the end of the array
    public void add( String x ) {
	_queue.add( x );
    }

    // Checks whether array is empty
    public boolean isEmpty() {
	return _queue.isEmpty();
    }

    // Returns the element with the least priority (Early Alphabet Letters)
    public String peekMin() { 
	int index = 0;
	for( int i = 0; i < _queue.size(); i++ )
	    if ( _queue.get( i ).compareTo( _queue.get( index ) ) < 0 )
		index = i;
	return _queue.get( index );
    }

    // Removes and returns the element with the least priority
    public String removeMin() {
	int index = 0;
	for( int i = 0; i < _queue.size(); i++ )
	    if ( _queue.get( i ).compareTo( _queue.get( index ) ) < 0 )
		index = i;
	return _queue.remove( index );
    }

    public String toString() {
	String result = "[ ";
	for ( int i = 0; i < _queue.size(); i++ ) {
	    result += _queue.get(i) + " ";
	}
	result += "]";
	return result;
    }
    
    public static void main(String[] args) {
	ArrayPriorityQueue bip = new ArrayPriorityQueue();
	
	System.out.println( "===================================" );
	System.out.println( "Adding Elements to bip...\n" );
	bip.add( "foo" );
	bip.add( "moo" );
	System.out.println( "Empty? --> " + bip.isEmpty() );
	System.out.println( "\nbip: \n" + bip );
	System.out.println( "Least Priority: " + bip.peekMin() );
	System.out.println( "\nRemoving Minimum...\n");
	bip.removeMin();
	System.out.println( "bip: \n" + bip );
	System.out.println( "\nAdding More to bip...\n" );
	bip.add( "goo" );
	bip.add( "hoo" );
	bip.add( "doo" );
	System.out.println( "bip: \n" + bip );
	System.out.println( "Least Priority: " + bip.peekMin() );
	System.out.println( "\nRemoving Minimum...\n");
	bip.removeMin();
	System.out.println( "bip:\n " + bip );
	System.out.println("====================================");
    }
}
