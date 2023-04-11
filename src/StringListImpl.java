import exceptions.ElementNotFoundedException;
import exceptions.ImpossibleToInsertElementException;
import exceptions.IncorrectArgumentException;
import exceptions.MaxArrayLengthAchievedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class StringListImpl {

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
        if (index < 0 || index > stringArray.length - 1) {
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
        if (stringArray[stringArray.length - 1] != null) {
            throw new ImpossibleToInsertElementException("Невозможно сдвинуть элементы массива для вставки нового элемента");
        }
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
            stringArray[index] = null;
            count--;
            return item;
        }
    }

    public String remove(int index) {
        checkIndex(index);
        if (stringArray[index] != null) {
            String elementTemp = stringArray[index];
            stringArray[index] = null;
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

    int lastIndexOf(String item) {
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

    public boolean equals(StringListImpl otherList) {
        if (otherList == null) {
            throw new IncorrectArgumentException("Введите непустой список");
        }
        for (int i = 0; i < stringArray.length - 1; i++) {
            if (stringArray[i] == null && otherList.getStringArray()[i] == null
                    || stringArray[i].equals(otherList.getStringArray()[i])) {
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
        for (int i = 0; i < stringArray.length - 1; i++) {
            if (stringArray[i] != null) {
                return false;
            }
        }
        return true;
    }

    public String[] getStringArray() {
        return stringArray;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        StringListImpl that = (StringListImpl) o;
//        return count == that.count && Arrays.equals(stringArray, that.stringArray);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = Objects.hash(count);
//        result = 31 * result + Arrays.hashCode(stringArray);
//        return result;
//    }
}
