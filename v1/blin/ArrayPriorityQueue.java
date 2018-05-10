/*
  Brian Lin 
  APCS2 pd2 
  HW46 - Arrr, There Be Priorities Here Matey
  2018-05-09
*/

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {
    private ArrayList<String> _data;

    // End --> Right   Front --> Left 
    public ArrayPriorityQueue() {
	_data = new ArrayList();
    }

    // Adds element to the end of the array
    public void add( String x ) {
	_data.add( x );
    }

    // Checks whether array is empty
    public boolean isEmpty() {
	if ( _data.size() == 0 ) {
	    return true;
	}
	return false;
    }

    // Returns the element with the least priority (Early Alphabet Letters)
    public String peekMin() { 
	String temp = _data.get(0);
	for ( int i = 1; i < _data.size(); i++ ) {
	    if ( temp.compareTo( _data.get(i) ) > 0 ) { 
		temp = _data.get(i);
	    }
	}
	return temp;
    }

    // Removes and returns the element with the least priority
    public String removeMin() {
	int index = 0;
	String temp = _data.get(index);
	for ( int i = 1; i < _data.size(); i++ ) {
	    if ( temp.compareTo( _data.get(i) ) > 0 ) { 
		temp = _data.get(i);
		index = i;
	    }
	}
	_data.remove( index );
	return temp;
    }

    public String toString() {
	String result = "[ ";
	for ( int i = 0; i < _data.size(); i++ ) {
	    result += _data.get(i) + " ";
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
