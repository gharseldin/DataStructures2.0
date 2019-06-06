package linkedlists;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static junit.framework.TestCase.assertEquals;

@RunWith(value = Parameterized.class)
public class LinkedListTest {

    @Parameterized.Parameter
    public ImplementationType type;


    public LinkedList<Integer> list;

    @Parameterized.Parameters(name = "{index}: Implementation type -{0}")
    public static Object[] data(){
        return new Object[]{
                ImplementationType.STANDARD,
                ImplementationType.CIRCULAR,
                ImplementationType.DOUBLY
        };
    }

    @Before
    public void setup(){
        switch (type){
            case STANDARD:
                list = new SinglyLinkedList<>();
                break;
            case CIRCULAR:
                list = new CircularlyLinkedList<>();
                break;
            case DOUBLY:
                list = new DoublyLinkedList<>();
        }
    }

    @Test
    public void initialListIsEmpty() {
        assertEquals(true, list.isEmpty());
    }

    @Test
    public void addingElementToStartWillCreateNonEmptyList() {
        list.addFirst(12);
        assertEquals(1, list.size());
        assertEquals(false, list.isEmpty());
    }

    @Test
    public void addingElementFirstGivesFirst(){
        list.addFirst(15);
        int first = list.first();
        assertEquals(15, first);
    }

    @Test
    public void addingElementToEndWillCreateNonEmptyList() {
        list.addLast(12);
        assertEquals(false, list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test
    public void addingElementsAtBeginningAndEnd(){
        list.addFirst(1);
        list.addLast(5);
        list.addFirst(0);
        list.addLast(6);
        int first = list.first();
        int last = list.last();
        assertEquals(4, list.size());
        assertEquals(0, first);
        assertEquals(6, last);
    }

    @Test
    public void gettingFirstElementWillReturnTheElement(){
        list.addLast(7);
        int temp = list.removeFirst();
        assertEquals(7, temp);
    }

    @Test
    public void removingFirstReducesSize(){
        list.addLast(10);
        list.addLast(12);
        list.addLast(13);
        assertEquals(3, list.size());
        list.removeFirst();
        assertEquals(2, list.size());
    }

    @Test
    public void removingFirstElementreturnsBackToEmtpy(){
        list.addLast(1);
        assertEquals(false, list.isEmpty());
        list.removeFirst();
        assertEquals(true, list.isEmpty());
    }

}
