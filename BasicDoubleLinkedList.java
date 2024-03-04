import java.util.*;

/** 
 * @author Vivian Dang
 * CMSC 204 Assignment 3
 */



/**
 * Generic Node Class
 * @param <T>
 */
public class BasicDoubleLinkedList<T> extends Object implements Iterable<T>
{
    
    protected Node<T> head;
    protected Node<T> tail;
    protected int listSize;   
       
    /**
     * Generic Node Class
     * @param <T>
     */
    	@SuppressWarnings("hiding")
		protected class Node<T>
        {
    		protected T dataNode;
            protected Node<T> next;   
    		protected Node<T> prev;

    		public Node(T data)
    		{
    			this.dataNode = data;
    			this.next = null;
    			this.prev = null;   		
            }
        }
  
    //Begin actual class	
    public BasicDoubleLinkedList()
    {
        head = null;
        tail = null;
        listSize = 0;
    }

    /**
     * Adds an element to the front of the list
     * @param data - the data for the Node within the linked list
     */
    public void addToFront(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        
        if (listSize == 0) {
            tail = newNode;
        }
        listSize++;
    }

    
/**
 * Adds an element to the end of the list 
 * @param data
 * for the Node within the linked list
 */
    public void addToEnd(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (listSize == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        listSize++;
    }
   
    /**
     * Returns but does not remove the first element from the list 
     * @return the data element or null
     */
    
    public T getFirst()
    {
        if (listSize > 0) {
            return head.dataNode;
        } else {
            return null;
        }
    }


/**
 * Returns but does not remove the last element from the list 
 * @return the data element or null
 */
    public T getLast()
    {
        if (listSize > 0) {
            return tail.dataNode;
        } else {
            return null;
        }
    }

    /**
     * Returns the value of the variable used to keep track of size
     * @return the size of the linked list
     */
      public int getSize()
      {
          return listSize;
      }
      public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException
      {
          // Return new list iterator
          return new DoubleLinkedListIterator();
      }
      /**
       * Removes the first instance of toRemove from the list
       * @param toRemove the data element to be removed
       * @param comparator the comparator to determine equality of data elements
       */
    
      public void remove(T toRemove, Comparator<T> comparator) {
    	    Node<T> currentNode = head;
    	    Node<T> previousNode = null;

    	    while (currentNode != null) {
    	        if (comparator.compare(currentNode.dataNode, toRemove) == 0) {
    	            if (currentNode == head) {
    	                head = head.next;
    	                if (head == null) {
    	                    tail = null; // Update tail if head becomes null
    	                }
    	            } else {
    	                previousNode.next = currentNode.next;
    	                if (currentNode == tail) {
    	                    tail = previousNode; // Update tail if the last node is removed
    	                }
    	            }
    	            listSize--;
    	            return;
    	        }
    	        previousNode = currentNode;
    	        currentNode = currentNode.next;
    	    }
    	}


      
      /**
       * Removes and returns the first element from the list. 
       * If there are no elements the method returns null. 
       * @return data or null
       */
      public T retrieveFirstElement() {
    	    if (listSize == 0) {
    	        return null;
    	    }
    	    
    	    Node<T> currentNode = head;
    	    head = head.next;
    	    listSize--;
    	    return currentNode.dataNode;
    	}

/**
 * Retrieves the last element from the list
 * @return data or null
 */
      public T retrieveLastElement() {
    	    if (listSize == 0) {
    	        return null;
    	    }  
    	    Node<T> currentNode = head;
    	    Node<T> previousNode = null;
    	    
    	    while (currentNode != tail) {
    	        previousNode = currentNode;
    	        currentNode = currentNode.next;
    	    }

    	    if (previousNode == null) {
    	        head = null;
    	        tail = null;
    	    } else {
    	        previousNode.next = null;
    	        tail = previousNode;
    	    }

    	    listSize--;
    	    return currentNode.dataNode;
    	}

/**
 * Returns an arraylist of the items in the list
 * @return an arraylist of the items in the list
 */
      public ArrayList<T> toArrayList() {
    	    ArrayList<T> newList = new ArrayList<>(listSize);
    	    Node<T> currentNode = head;

    	    while (currentNode != null) {
    	        newList.add(currentNode.dataNode);
    	        currentNode = currentNode.next;
    	    }
    	    return newList;
    	}
 
    
    /**
     * A generic inner class named DoubleLinkedListIterator that 
     * implements java’s ListIterator interface (for the iterator method) 
     * @param current
     * @param prev
     *
     */
    
    public class DoubleLinkedListIterator implements ListIterator<T>
    {
    private Node<T> current;
    private Node<T> prev;
    /**
     * @param current
     * @param prev
     */
    public DoubleLinkedListIterator()
    {
    current = head;
    prev = null;
    }
    
    
    /**
     * 
     * *Detects whether there is something after the current position
     * @return True if there is, otherwise false
     * @param next
     */
    public boolean hasNext()
    {
        return current != null;
    }

    /**
     * Retrieves the next entry in the collection and advances the iterator by one 
      @return A reference to the next entry in the iteration
      @throws NoSuchElementException
     * @param T
     * @return data 
     */
    public T next()
    {
    if(current!= null)
	    {
	    T data = (T) current.dataNode;
	    prev = current;
	    current= current.next;
    if(current!= null) current.prev = prev;
	    return data;
    }
    else
	    throw new NoSuchElementException();
    }  
    
    /** Retrieves the previous entry in the list and moves this iterator back by one 
    @return A reference to the previous entry in the iteration
    @throws NoSuchElementException */
    public T previous() {
        if (prev != null) {
            T returnData = current.dataNode;
            current = prev;
            prev = current.prev;
            return returnData;
        } else {
            throw new NoSuchElementException();
        }
    }
    
    /**
     * Detects whether there is something before the first entry in the list
     * @return True if there is, otherwise returns false
     */
    public boolean hasPrevious() {
        return prev != null;
    }

    @Override
    /**
     * This operation is not supported.
     * @throws UnsupportedOperationException 
     */
    public int nextIndex() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    /**
     * This operation is not supported.
     * @throws UnsupportedOperationException 
     */
    public int previousIndex() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    /**
     * This operation is not supported.
     *
     * @param arg0 
     * @throws UnsupportedOperationException 
     */
    public void add(T arg0) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    /**
     * This operation is not supported.
     *
     * @param arg0 
     * @throws UnsupportedOperationException 
     */
    public void set(T arg0) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    /**
     * This operation is not supported.
     * @throws UnsupportedOperationException
     */
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    	}
    }
}