import java.util.*;

public class Lesson_4 {
    public static void main(String[] args) {
        // Arrays are the basic structure and list are the abstraction above that
        List<String> list = Arrays.asList("John","Mitali","Apoorv");
        System.out.println(list);
        String[] names = {"John","Mitali","Apoorv"};
        System.out.println(names);// it will print the package name and identity hashcode of the object

        list.set(1,"Queen");
        System.out.println(list);
        // list.add("Derik");
        // list.clear();
        // Error message
        /*
        Exception in thread "main" java.lang.UnsupportedOperationException
	    at java.base/java.util.AbstractList.add(AbstractList.java:153)
	    at java.base/java.util.AbstractList.add(AbstractList.java:111)
	    at Lesson_4.main(Lesson_4.java:13)
         */

        // It means that what u want to do is not feasible
        // Here u cannot modify list size by adding an extra element nor u can remove all elements. Cause the above define list
        // is immutable with respect to the size
        // U can only set an existing element to be different one
        //System.out.println(list);

        list = List.of("John","Mitali","Apoorv"); // this won't work in java 8 only java 9 and above
        // now this is totally immutable list

        //list.set(1,"Queen");

        // error
        /*
        Exception in thread "main" java.lang.UnsupportedOperationException
	    at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
	    at java.base/java.util.ImmutableCollections$AbstractImmutableList.set(ImmutableCollections.java:260)
	    at Lesson_4.main(Lesson_4.java:32)
         */
        System.out.println(list);

        // if the list contains only 0,1 or 2 elements then it stores it in direct field (or u can say direct variables)

        // list of 2 have criteria of random access, it means that u can access any element in constant time
        // its not an order of n for list of 2.
        // same amount of time for both element




    }
}
