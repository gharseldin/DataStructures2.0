import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ArrayListTest {

    ArrayList<Integer> list;

    @Before
    public void setup() {
        list = new ArrayList<>(10);
    }

    @Test
    public void listShouldBeInitializedToTheCorrectSize() {
        assertEquals(0, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidLowerIndexShouldThrowIndexOutOfBoundException() {
        list.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidUpperIndexShouldThrowIndexOutOfBoundException() {
        list.get(list.size());
    }

    @Test
    public void initialArrayListIsEmpty() {
        assertEquals(true, list.isEmpty());
    }

    @Test
    public void weCanAddItemsToANonFullArrayList() {
        list.add(0, 999);
        int temp = list.get(0);
        assertEquals(999, temp);
    }

    @Test
    public void AddingElementToAFullArrayShouldDoubleItsSize() {
        for (int i = 0; i < 10; i++)
            list.add(i, 888);
        list.add(5, 777);
        int added = list.get(5);
        int shifted = list.get(10);
        assertEquals(777, added);
        assertEquals(888, shifted);
    }

    @Test
    public void addedElementsArePlacedInTheProperOrder() {
        for (int i = 0; i < 6; i++)
            list.add(i, i);
        list.add(2, 666);
        int added = list.get(2); //should be 666
        int shifted = list.get(3); //should be 2
        assertEquals(666, added);
        assertEquals(2, shifted);
    }

    @Test
    public void settingFunctionalityOfArrayList() {
        for (int i = 0; i < 10; i++)
            list.add(i, i);
        int oldValue = list.set(6, 666);
        int temp = list.get(6);
        assertEquals(666, temp);
        assertEquals(6, oldValue);
    }

    @Test
    public void removingAnElementFromAsizeOneArrayListLeavesItEmpty() {
        list.add(0, 15);
        int temp = list.remove(0);
        assertEquals(true, list.isEmpty());
        assertEquals(temp, 15);
    }
}
