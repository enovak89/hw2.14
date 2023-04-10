import java.sql.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        StringListImpl array = new StringListImpl(new String[3], 3);
        System.out.println(array.add("A"));
        System.out.println(array.add("B"));
        System.out.println(array.add("C"));
        System.out.println(array.getStringArray()[0]);
        System.out.println(array.getStringArray()[1]);
        System.out.println(array.getStringArray()[2]);

    }
}