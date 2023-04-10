import exceptions.IncorrectArgumentException;
import exceptions.MaxArrayLengthAchievedException;

import java.util.ArrayList;

public class StringListImpl {

    private final String[] stringArray;
    private final int arrayMaxLength;

    public StringListImpl(String[] stringArray, int arrayMaxLength) {
        this.stringArray = stringArray;
        this.arrayMaxLength = arrayMaxLength;
    }

    private static void checkArgument(String string) {
        if (string == null) {
            throw new IncorrectArgumentException("Некорректная строка");
        }
    }

    private void checkArray() {
        if (stringArray.length >= arrayMaxLength) {
            throw new MaxArrayLengthAchievedException("Достигнут максимальный размер массива: " + arrayMaxLength);
        }
    }

    public String add(String item) {
      checkArgument(item);
      checkArray();
      return stringArray[stringArray.length - 1] = item;
    }

}
