import java.io.*;
import java.util.*;


// Time Complexity
public class Lesson_1 {
    volatile static int value;// Volatile keyword is quite useful remember that

    public static void main(String... args) {
        for (int i = 0; i < 3; i++) {
            testAll();
        }

    }

    private static void testAll() {
        // constant time O(1) e.g. hashing
        value = 42;
        // linear time O(n) e.g. searching a list
        for (int n = 100_000_000; n <= 1_600_000_000 && n > 0; n *= 2) {
            linearComplexity(n);
        }
        // quadratic time O(n*n) e.g. bubble sort
        for (int n = 1_000; n <= 100_000 && n > 0; n *= 2) {
            quadraticComplexity(n);
        }
        // logarithmic time O(log n) e.g. tree search
        for (long n = 1_000_000_000L; n <= 1_000_000_000_000L && n > 0; n *= 2) {
            logarithmicComplexity(n);
        }

        // quasilinear time O(n * log n) e.g. merge sort
    }

    private static void linearComplexity(int n) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            value = i;
        }
        time = System.currentTimeMillis() - time;
        System.out.println(n + " time = " + time);
    }

    private static void quadraticComplexity(int n) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                value = j;
            }
        }
        time = System.currentTimeMillis() - time;
        System.out.println(n + " time = " + time);
    }
    private static void logarithmicComplexity(long n) {
        int steps = 0;
        long time = System.currentTimeMillis();
        for (long i = 1; i < n; i *= 2) {
            value = (int) i;
            steps++;
        }
        time = System.currentTimeMillis() - time;
        System.out.println(n + " time = " + time + " steps = " + steps);
    }
}
