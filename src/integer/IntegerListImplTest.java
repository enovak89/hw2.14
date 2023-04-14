package integer;

import exceptions.ElementNotFoundedException;
import exceptions.IncorrectArgumentException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(IntegerListParameterResolver.class)
class IntegerListImplTest {

    private final IntegerListImpl integerListImpl;

    public IntegerListImplTest(IntegerListImpl integerListImpl) {
    this.integerListImpl = integerListImpl;
    }

    @Test
    void addByItemCorrect() {
        assertEquals(111, integerListImpl.add(111));
    }

    @Test
    void addByItemWithIncorrectItem() {
        assertThrows(IncorrectArgumentException.class, () -> integerListImpl.add(null));
    }

    @Test
    void addByIndexCorrect() {
        assertEquals(111, integerListImpl.add(0,111));
    }

    @Test
    void addByIndexWithIncorrectItem() {
        assertThrows(IncorrectArgumentException.class, () -> integerListImpl.add(0,null));
    }

    @Test
    void addByIndexWithIncorrectIndex() {
        assertThrows(IncorrectArgumentException.class, () -> integerListImpl.add(-1,111));
    }

    @Test
    void setCorrect() {
        assertEquals(111, integerListImpl.set(0, 111));
    }

    @Test
    void setWithIncorrectIndex() {
        assertThrows(IncorrectArgumentException.class, () -> integerListImpl.set(-1, 111));
    }

    @Test
    void setWithIncorrectItem() {
        assertThrows(IncorrectArgumentException.class, () -> integerListImpl.set(-1, null));
    }

    @Test
    void removeCorrect() {
        integerListImpl.add(111);
        integerListImpl.add(222);
        assertEquals(222, integerListImpl.remove(1));
    }

    @Test
    void removeWithIncorrectIndex() {
        integerListImpl.add(111);
        integerListImpl.add(222);
        assertThrows(IncorrectArgumentException.class, () -> integerListImpl.remove(-1));
    }

    @Test
    void removeWithIncorrectElement() {
        integerListImpl.add(111);
        integerListImpl.add(222);
        assertThrows(ElementNotFoundedException.class, () -> integerListImpl.remove(2));
    }

    @Test
    void containsCorrect() {
        integerListImpl.add(111);
        integerListImpl.add(222);
        assertTrue(integerListImpl.contains(222));
    }

    @Test
    void containsWithIncorrectItem() {
        integerListImpl.add(111);
        integerListImpl.add(222);
        assertThrows(IncorrectArgumentException.class, () -> integerListImpl.contains(null));
    }

    @Test
    void indexOfCorrect() {
        integerListImpl.add(111);
        integerListImpl.add(222);
        assertEquals(1, integerListImpl.indexOf(222));
    }

    @Test
    void indexOfWithIncorrectItem() {
        integerListImpl.add(111);
        integerListImpl.add(222);
        assertThrows(IncorrectArgumentException.class, () -> integerListImpl.indexOf(null));
    }


    @Test
    void lastIndexOfCorrect() {
        integerListImpl.add(111);
        integerListImpl.add(222);
        assertEquals(1, integerListImpl.indexOf(222));
    }

    @Test
    void lastIndexOfWithIncorrectItem() {
        integerListImpl.add(111);
        integerListImpl.add(222);
        assertThrows(IncorrectArgumentException.class, () -> integerListImpl.indexOf(null));
    }

    @Test
    void getCorrect() {
        integerListImpl.add(111);
        integerListImpl.add(222);
        assertEquals(222, integerListImpl.get(1));
    }

    @Test
    void getWithIncorrectIndex() {
        integerListImpl.add(111);
        integerListImpl.add(222);
        assertThrows(IncorrectArgumentException.class, () -> integerListImpl.get(-1));
    }

    @Test
    void testEqualsCorrect() {
        integerListImpl.add(111);
        integerListImpl.add(222);
        IntegerListImpl integerListForEquals = new IntegerListImpl(3);
        integerListForEquals.add(111);
        integerListForEquals.add(222);
        assertTrue(integerListImpl.equals(integerListForEquals));
    }

    @Test
    void testEqualsWithIncorrectIntegerList() {
        integerListImpl.add(111);
        integerListImpl.add(222);
        assertThrows(IncorrectArgumentException.class, () -> integerListImpl.equals(null));
    }

    @Test
    void sizeCorrect() {
        integerListImpl.add(111);
        integerListImpl.add(222);
        assertEquals(2, integerListImpl.size());
    }

    @Test
    void isEmptyCorrect() {
        assertTrue(integerListImpl.isEmpty());
    }

    @Test
    void clearCorrect() {
        integerListImpl.add(111);
        integerListImpl.add(222);
        integerListImpl.clear();
        assertTrue(integerListImpl.isEmpty());

    }

    @Test
    void toArray() {
        integerListImpl.add(111);
        integerListImpl.add(222);
        Integer[] expectedArray = {111, 222, null, null, null, null, null, null, null, null};
        assertEquals(Arrays.toString(expectedArray), Arrays.toString(integerListImpl.toArray()));
    }


}