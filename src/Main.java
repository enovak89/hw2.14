import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringListImpl array = new StringListImpl(new String[4], 5);
        System.out.println(array.add("AAA"));

    }
}