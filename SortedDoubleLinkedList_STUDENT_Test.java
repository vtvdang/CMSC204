import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class SortedDoubleLinkedList_STUDENT_Test {

    private SortedDoubleLinkedList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new SortedDoubleLinkedList<Integer>(Comparator.naturalOrder());
    }

    @Test
    public void testAdd() {
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(4);
        assertEquals(1, list.getFirst().intValue());
        assertEquals(5, list.getLast().intValue());
        assertEquals(5, list.getSize());
    }

    @Test
    public void testIterator() {
        list.add(3);
        list.add(1);
        list.add(2);
        ListIterator<Integer> iterator = list.iterator();
        assertEquals(1, iterator.next().intValue());
        assertEquals(2, iterator.next().intValue());
        assertEquals(3, iterator.next().intValue());
    }

    @Test
    public void testIteratorRemove() {
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);
        ListIterator<Integer> iterator = list.iterator();
        iterator.next();
        assertThrows(UnsupportedOperationException.class, () -> {
            iterator.remove();
        });
    }

    @Test
    public void testIteratorNext() {
        list.addToEnd(1);
        ListIterator<Integer> iterator = list.iterator();
        iterator.next();
        assertThrows(NoSuchElementException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testIteratorPrevious() {
        list.addToEnd(1);
        ListIterator<Integer> iterator = list.iterator();
        assertThrows(NoSuchElementException.class, () -> {
            iterator.previous();
        });
    }
}