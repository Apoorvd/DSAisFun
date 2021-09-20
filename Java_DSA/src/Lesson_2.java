import java.io.*;
import java.util.*;

//Space Complexity
// A new introduction to Object predefined class

public class Lesson_2 {
    public static void main(String[] args) {
        Object o[] = new Object[10];// space O(10)
        o[1] = 2.00;
        o[2] = "hello";
        o[3] = 1;
        o[4] = 'c';
        o[5] = "World";


        // space O(1)
        Holder dup = new Holder();
        Holder h = new Holder("Hello");
        h.setNext(new Holder(o[5]));
         dup = h;
        h = h.next;
        h.setNext(new Holder(o[1]));

        for(Holder iter = dup; iter != null; iter = iter.next)
        {
            System.out.println(iter.o);
        }
    }
    static class Holder{
        private Object o;
        private Holder next;

        public Holder()
        {
            o = null;
            next = null;
        }
        public Holder(Object o)
        {
            this.o = o;
        }

        public void setNext(Holder next)
        {
            this.next = next;
        }
    }
}

