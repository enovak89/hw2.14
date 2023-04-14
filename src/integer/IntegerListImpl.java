package integer;

import exceptions.ElementNotFoundedException;
import exceptions.IncorrectArgumentException;
import exceptions.MaxArrayLengthAchievedException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

    private final Integer[] integerArray;
    private final Integer[] integerArrayCapasityTen = new Integer[10];
    private final int arrayMaxLength;
    private int count = 0;

    public IntegerListImpl(int arrayMaxLength) {
        this.integerArray = integerArrayCapasityTen;
        this.arrayMaxLength = arrayMaxLength;
    }

    private void insertSort() {
        System.out.println(Arrays.toString(integerArray));
        for (int i = 1; i < count; i++) {
            Integer temp = integerArray[i];
            int j = i;
            while (j > 0 && integerArray[j - 1] >= temp) {
                integerArray[j] = integerArray[j - 1];
                j--;
            }
            integerArray[j] = temp;
        }
    }

    private boolean binarySearch(Integer item) {
        System.out.println(Arrays.toString(integerArray));
        int minIndex = 0;
        int maxIndex = count - 1;
        while (minIndex <= maxIndex) {
            int midIndex = minIndex + (maxIndex - minIndex) / 2;
            if (item.equals(integerArray[midIndex])) {
                System.out.println(midIndex);
                return true;
            }
            if (integerArray[midIndex] < item) {
                minIndex = midIndex + 1;
            } else {
                maxIndex = midIndex - 1;
            }
        }
        return false;
    }

    private void checkArgument(Integer num) {
        if (num == null) {
            throw new IncorrectArgumentException("Некорректная строка");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > count) {
            throw new IncorrectArgumentException("Некорректный индекс");
        }
    }

    private void checkArray() {
        if (count >= arrayMaxLength) {
            throw new MaxArrayLengthAchievedException("Достигнут максимальный размер массива: " + arrayMaxLength);
        }
    }

    public Integer add(Integer item) {
        checkArgument(item);
        checkArray();
        return integerArray[count++] = item;
    }

    public Integer add(int index, Integer item) {
        checkArgument(item);
        checkIndex(index);
        Integer[] arrayStringTemp = Arrays.copyOfRange(integerArray, index, integerArray.length - 1);
        integerArray[index] = item;
        System.arraycopy(arrayStringTemp, 0, integerArray, index + 1, arrayStringTemp.length);
        count++;
        return item;
    }

    public Integer set(int index, Integer item) {
        checkArgument(item);
        checkIndex(index);
        integerArray[index] = item;
        return item;
    }

    public Integer remove(int index) {
        checkIndex(index);
        if (integerArray[index] != null) {
            Integer elementTemp = integerArray[index];
            System.arraycopy(integerArray, index + 1, integerArray, index, count - index);
            count--;
            return elementTemp;
        } else {
            throw new ElementNotFoundedException("Элемент не найден");
        }
    }

    public boolean contains(Integer item) {
        checkArgument(item);
        insertSort();
        return binarySearch(item);
    }

    public int indexOf(Integer item) {
        checkArgument(item);
        int index = -1;
        for (int i = 0; i < integerArray.length; i++) {
            if (integerArray[i] != null && integerArray[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int lastIndexOf(Integer item) {
        checkArgument(item);
        int index = -1;
        for (int i = integerArray.length - 1; i >= 0; i--) {
            if (integerArray[i] != null && integerArray[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Integer get(int index) {
        checkIndex(index);
        return integerArray[index];
    }

    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new IncorrectArgumentException("Введите непустой список");
        }
        for (int i = 0; i < integerArray.length; i++) {
            if (integerArray[i] == null && otherList.toArray()[i] == null
                    || integerArray[i].equals(otherList.toArray()[i])) {
            } else {
                return false;
            }
        }
        return true;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < integerArray.length; i++) {
            integerArray[i] = null;
        }
        count = 0;
    }

    public Integer[] toArray() {
        return integerArray;
    }

}
