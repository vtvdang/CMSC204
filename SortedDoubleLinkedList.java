import java.util.Comparator;
import java.util.ListIterator;

/**
 * 
 * @author Vivian Dang
 * CMSC 204
 * Assignment 3
 *
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>
{
    
    private Comparator<T> comparator;
/**
 * Creates an empty list that is associated with the specified comparator
 * @param comparableObject 
 */
    public SortedDoubleLinkedList(Comparator<T> comparableObject )
    {
        comparator = comparableObject;
    }

    /**
     * Inserts the specified element at the correct position in the sorted list.
     * @param data
     */
    
    public void add(T data) {
        Node<T> temp = new Node<>(data);

        if (listSize == 0 || comparator.compare(data, tail.dataNode) > 0) {
            if (listSize > 0) {
                tail.next = temp;
                tail = temp;
            } else {
                head = temp;
                tail = temp;
            }
        } else {
            Node<T> currentNode = head;
            Node<T> previousNode = null;
            int comparison = 0;
            
            while (currentNode != null && (comparison = comparator.compare(data, currentNode.dataNode)) > 0) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            
            if (comparison == 0 || comparison < 0) {
                temp.next = currentNode;
                if (previousNode != null) {
                    previousNode.next = temp;
                } else {
                    head = temp;
                }
            } else if (currentNode == tail) {
                tail.next = temp;
                tail = temp;
            }
        }

        listSize++;
    }   
    
    /**
     * @param data 
     */
    public void addToEnd(T data)throws UnsupportedOperationException{
        throw new UnsupportedOperationException();}
  /**
   * @param data
   * @return reference to the current object
   * @throws UnsupportedOperationException
   */
    public void addToFront(T data)throws UnsupportedOperationException{
        throw new UnsupportedOperationException();}
    
    /**
     * Creates and returns a new list iterator
     * @param T
     * @return New iterator
     */ 
    public ListIterator<T> iterator()
    {
        return super.iterator();
    }
}