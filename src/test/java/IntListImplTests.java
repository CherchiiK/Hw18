import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class IntListImplTests {

    private IntListImpl intList;

    @Before
    public void setUp() {
        intList = new IntListImpl();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);


    }

    @Test
    public void listIsEmpty() {
        IntListImpl emptyList = new IntListImpl();
        Assertions.assertEquals(0, emptyList.size(), "They must be equal");
    }

    @Test
    public void rightIndexes() {
        int[] array = new int[]{1, 2, 3, 4};

        Assertions.assertArrayEquals(intList.toArray(), array, "They must be equal");
    }

    @Test
    public void removeByIndex() {
        int i = intList.getByIndex(3);
        intList.removeByIndex(2);
        int j = intList.getByIndex(2);
        Assertions.assertEquals(i, j, "They must be equal");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void wrongIndexElement() throws ArrayIndexOutOfBoundsException {

        intList.getByIndex(intList.size() + 10);


    }

    @Test
    public void subListMethodReturnSubString() {
        int[] arrayFromSubList = intList.subList(0, 2).toArray();
        int[] expectedArray = new int[]{1, 2};
        Assertions.assertArrayEquals(expectedArray, arrayFromSubList, "They must be equal");
    }

    @Test
    public void sizeByUserValues() {
        Assertions.assertEquals(4, intList.size(), "They must be equals");


    }

    @Test
    public void listCapacity() {
        Assertions.assertEquals(10, intList.capacity(), "They must be equals");
    }

    @Test
    public void listContains() {
        Assertions.assertTrue(intList.contains(1), "This element must be contains in list");
        Assertions.assertFalse(intList.contains(8), "This element does not contains in list");
    }

    @Test
    public void listIsNotUpdateByArraysMethod() {
        int[] array = intList.toArray();
        array[2] = 20;
        Assertions.assertNotEquals(array, intList.toArray(), "They must be not equal");
    }
}

