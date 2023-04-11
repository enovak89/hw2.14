import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        StringListImpl array = new StringListImpl(8);
        System.out.println(array.add("A"));
        System.out.println(array.add("B"));
        System.out.println(array.add("C"));
        System.out.println(Arrays.toString(array.getStringArray()));
        System.out.println(array.add(8, "AA"));
        System.out.println(Arrays.toString(array.getStringArray()));
        System.out.println(array.add(0, "BB"));
        System.out.println(Arrays.toString(array.getStringArray()));
        System.out.println(array.set(9, "CC"));
        System.out.println(array.set(5, "CC"));
        System.out.println(Arrays.toString(array.getStringArray()));
        System.out.println(array.remove("A"));
        System.out.println(Arrays.toString(array.getStringArray()));
        System.out.println(array.remove(3));
        System.out.println(Arrays.toString(array.getStringArray()));
        System.out.println(array.contains("CC"));
        System.out.println(array.indexOf("CC"));
        System.out.println(array.lastIndexOf("CC"));
        System.out.println(array.get(5));
        StringListImpl otherArray = new StringListImpl(8);
        StringListImpl otherArray1 = new StringListImpl(8);
        otherArray1.add("A");
        otherArray.add("AA");
        System.out.println(Arrays.toString(otherArray1.getStringArray()));
        System.out.println(Arrays.toString(otherArray.getStringArray()));
        System.out.println(otherArray1.equals(otherArray));
        System.out.println(array.size());
        System.out.println(array.isEmpty());
        array.clear();
        System.out.println(Arrays.toString(array.getStringArray()));
        System.out.println(Arrays.toString(array.toArray()));


    }


}