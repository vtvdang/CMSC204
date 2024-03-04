import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class BasicDoubleLinkedList_STUDENT_Test {

    private BasicDoubleLinkedList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new BasicDoubleLinkedList<>();
    }

    @Test
    public void testAddToFront() {
        list.addToFront(1);
        list.addToFront(2);
        assertEquals(2, list.getFirst().intValue());
    }

    @Test
    public void testAddToEnd() {
        list.addToEnd(1);
        list.addToEnd(2);
        assertEquals(2, list.getLast().intValue());
    }

    @Test
    public void testGetFirst() {
        list.addToFront(1);
        assertEquals(1, list.getFirst().intValue());
    }

    @Test
    public void testGetLast() {
        list.addToEnd(1);
        assertEquals(1, list.getLast().intValue());
    }

    @Test
    public void testGetSize() {
        list.addToFront(1);
        list.addToFront(2);
        list.addToFront(3);
        assertEquals(3, list.getSize());
    }

    @Test
    public void testRemove() {
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);
        Comparator<Integer> comparator = Comparator.naturalOrder();
        list.remove(2, comparator);
        assertEquals(2, list.getSize());
        assertEquals(1, list.getFirst().intValue());
        assertEquals(3, list.getLast().intValue());
    }

    @Test
    public void testRetrieveFirstElement() {
        list.addToFront(1);
        list.addToFront(2);
        assertEquals(2, list.retrieveFirstElement().intValue());
        assertEquals(1, list.getSize());
    }

    @Test
    public void testRetrieveLastElement() {
        list.addToEnd(1);
        list.addToEnd(2);
        assertEquals(2, list.retrieveLastElement().intValue());
        assertEquals(1, list.getSize());
    }

    @Test
    public void testToArrayList() {
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);
        ArrayList<Integer> arrayList = list.toArrayList();
        assertEquals(1, arrayList.get(0).intValue());
        assertEquals(2, arrayList.get(1).intValue());
        assertEquals(3, arrayList.get(2).intValue());
    }

    @Test
    public void testIterator() {
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);
        ListIterator<Integer> iterator = list.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals(1, iterator.next().intValue());
        assertEquals(true, iterator.hasNext());
        assertEquals(2, iterator.next().intValue());
        assertEquals(true, iterator.hasNext());
        assertEquals(3, iterator.next().intValue());
        assertEquals(false, iterator.hasNext());
    }

    @Test
    public void testIteratorRemove() {
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);
        ListIterator<Integer> iterator = list.iterator();
        iterator.next();
        assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Test
    public void testIteratorNext() {
        list.addToEnd(1);
        ListIterator<Integer> iterator = list.iterator();
        iterator.next();
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void testIteratorPrevious() {
        list.addToEnd(1);
        ListIterator<Integer> iterator = list.iterator();
        assertThrows(NoSuchElementException.class, iterator::previous);
    }
}