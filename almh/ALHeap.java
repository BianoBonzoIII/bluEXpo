/*****************************************************
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap {

    //instance vars
    private ArrayList<Integer> _heap; 

    /*****************************************************
    * default constructor  ---  inits empty heap
    *****************************************************/
    public ALHeap() {
        _heap = new ArrayList();
    }



    /*****************************************************
    * toString()  ---  overrides inherited method
    * Returns either 
    * a) a level-order traversal of the tree (simple version)
    * b) ASCII representation of the tree (more complicated, more fun)
    *****************************************************/
    public String toString() {
        String s = "";
        int ctr = 0;
        int max = 1;
        for (Integer x : _heap) {
            s += x + " ";
            ctr ++;
            if ( ctr == max ) {
                s += "| ";
                ctr = 0;
                max *= 2;
            }
        }
        return s;
    }//O(n)


    /*****************************************************
    * boolean isEmpty()
    * Returns true if no meaningful elements in heap, false otherwise
    *****************************************************/
    public boolean isEmpty() {
        return _heap.isEmpty();
    }//O(1)


    /*****************************************************
    * Integer peekMin()
    * Returns min value in heap
    * Postcondition: Heap remains unchanged.
    *****************************************************/
    public Integer peekMin(){
        return _heap.get(0);
    }//O(1)


    /*****************************************************
    * add(Integer) 
    * Inserts an element in the heap
    * Postcondition: Tree exhibits heap property.
    *****************************************************/
    public void add( Integer addVal ){
        boolean added = false;
        for (int i = 0; i < _heap.size(); i ++)
            if ( _heap.get(i) == null ) {
                _heap.set(i, addVal);
                added = true;
                break;
            }
        if ( !added )
            _heap.add( addVal );
        int i = _heap.indexOf( addVal );
        while ( _heap.get(i).compareTo( _heap.get( (i-1)/2 )) < 0 ) {
            swap( i, (i-1)/2 );
            i = (i-1)/2;
        }
    }//O(logn)


    /*****************************************************
    * removeMin()  ---  means of removing an element from heap
    * Removes and returns least element in heap.
    * Postcondition: Tree maintains heap property.
    *****************************************************/
    public Integer removeMin(){
        if (isEmpty()) return null;
        int min = _heap.get(0);
        int i = 0;
        while ( minChildPos(i) != -1 ) {
            swap( i, minChildPos(i) );
            i = minChildPos(i);
        }
        _heap.set(i, null);
        while ( !isEmpty() && _heap.get( _heap.size() - 1) == null )
            _heap.remove( _heap.size() - 1 );
        return min;
    }//O(logn)


    /*****************************************************
    * minChildPos(int)  ---  helper fxn for removeMin()
    * Returns index of least child, or 
    * -1 if no children, or if input pos is not in ArrayList
    * Postcondition: Tree unchanged
    *****************************************************/
    private int minChildPos( int pos ) {
        int pos1 = pos * 2 + 1;
        int pos2 = pos * 2 + 2;
        if ( pos1 >= _heap.size() )
            return -1;
        if ( pos2 >= _heap.size() || _heap.get(pos2) == null )
            return pos1;
        if ( _heap.get(pos1) == null )
            return pos2;
        return _heap.indexOf( minOf( _heap.get(pos1), _heap.get(pos2) ));
    }//O(1)
  

    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b ){
        if ( a.compareTo(b) < 0 )
            return a;
        else
            return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 ){
        _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
    }
    //********************************************



    //main method for testing
    public static void main( String[] args ){
    
      ALHeap pile = new ALHeap();

      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);

      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class ALHeap
