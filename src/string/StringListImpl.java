package string;

import exceptions.ElementNotFoundedException;
import exceptions.IncorrectArgumentException;
import exceptions.MaxArrayLengthAchievedException;

import java.util.Arrays;

public class StringListImpl implements StringList{

    private final String[] stringArray;
    private final String[] stringArrayCapasityTen = new String[10];
    private final int arrayMaxLength;
    private int count = 0;

    public StringListImpl(int arrayMaxLength) {
        this.stringArray = stringArrayCapasityTen;
        this.arrayMaxLength = arrayMaxLength;
    }

    private void checkArgument(String string) {
        if (string == null) {
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

    public String add(String item) {
        checkArgument(item);
        checkArray();
        return stringArray[count++] = item;
    }

    public String add(int index, String item) {
        checkArgument(item);
        checkIndex(index);
        String[] arrayStringTemp = Arrays.copyOfRange(stringArray, index, stringArray.length - 1);
        stringArray[index] = item;
        System.arraycopy(arrayStringTemp, 0, stringArray, index + 1, arrayStringTemp.length);
        count++;
        return item;
    }

    public String set(int index, String item) {
        checkArgument(item);
        checkIndex(index);
        stringArray[index] = item;
        return item;
    }

    public String remove(String item) {
        checkArgument(item);
        int index = -1;
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] != null && stringArray[i].equals(item)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new ElementNotFoundedException("Элемент не найден");
        } else {
            System.arraycopy(stringArray, index + 1, stringArray, index, count - index);
            count--;
            return item;
        }
    }

    public String remove(int index) {
        checkIndex(index);
        if (stringArray[index] != null) {
            String elementTemp = stringArray[index];
            System.arraycopy(stringArray, index + 1, stringArray, index, count - index);
            count--;
            return elementTemp;
        } else {
            throw new ElementNotFoundedException("Элемент не найден");
        }
    }

    public boolean contains(String item) {
        checkArgument(item);
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] != null && stringArray[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(String item) {
        checkArgument(item);
        int index = -1;
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] != null && stringArray[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int lastIndexOf(String item) {
        checkArgument(item);
        int index = -1;
        for (int i = stringArray.length - 1; i >= 0; i--) {
            if (stringArray[i] != null && stringArray[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public String get(int index) {
        checkIndex(index);
        return stringArray[index];
    }

    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IncorrectArgumentException("Введите непустой список");
        }
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] == null && otherList.toArray()[i] == null
                    || stringArray[i].equals(otherList.toArray()[i])) {
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
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = null;
        }
        count = 0;
    }

    public String[] toArray() {
        return stringArray;
    }

}
