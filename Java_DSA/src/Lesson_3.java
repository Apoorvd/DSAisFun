import java.util.*;


// Arrays
// https://docs.oracle.com/javase/7/docs/technotes/guides/vm/performance-enhancements-7.html
public class Lesson_3 {
    public static void main(String[] args) {
        int[] values = {1,2,3}; // 12 bytes (object header) on a 64-bit machine with compressedOops
        // compressedOops uses 32 bit pointers on a 64 bit machine. Rest read it from above link
        // length = 4 bytes i.e array.length is established with 4 byte required mem as soon as u make an array object
        // 3 x 4 bytes for values
        // 12 + 4 + 12 = 28 ~ 32 ( rounded upto nearest 8 byte multiple)
        // O(n) space value for length n array
        int[] larger = new int[1000]; // 12 bytes (object header) on a 64-bit machine with compressedOops
        // length = 4 bytes
        // 1000 x 4 bytes
        // 12 + 4 + 4000 = 4016 (already multiple of 8)
        short[] smaller; // 2 bytes per entry
        byte[] bytes; // 2 bytes per entry

        char[] c;

        String[] name = {"John", "Dane", "Dora"};
        String[] newNames = new String[name.length + 1];
        System.arraycopy(name, 0 , newNames, 0, 2);// first source then source pos, then destination, start pos on destination, the number
        // of elements to be copied is last parameter

        newNames[name.length] = "Heinz";

        System.out.println(newNames[2]);
        System.out.println(newNames[3]);

        // array points to a huge blob of mem
        // allocate mem all together
        // good thing is if u want to go from beg to end , it is very quick specially in primitive array
        // if u have objects but when they are primitive they are really fast
        // for a linked structure they can present all over the place in the mem so u have to swap pages in and out, and it is really expensive if the linked structure is growing
        // its cost of swapping your object into the cache
        // and your mem is not accessed from the main mem, it is accessed from cache mem, while this is faster the cache mem will remain full while reading the data


        //multidimensional array

        int[][][][] quadro = {{{{1,2},{3,4}}}};
        int[][][] sub = quadro[0];
        int[][] subsub = sub[0];
        int[] subsubsub = subsub[0];
        int subsubsubsub = subsubsub[0];

        System.out.println(subsubsubsub);
        System.out.println(quadro[0][0][1][1]);
        // for each array u will have another array as an element of the array

        // prefer single over multidim array
        // java loads aya into mem into cache like structure

    }
}
