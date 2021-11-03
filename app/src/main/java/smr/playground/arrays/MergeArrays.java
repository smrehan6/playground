package smr.playground.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeArrays {

    public static void main(String[] args) {
        int[] a = {1, 2, 8, 9};
        int[] b = {1, 2, 5, 6, 77, 80, 90};
        int[] c = {1, 2,};

        mergeArrays(a, b, c);
    }

    static List<Integer> mergeArrays(int[] a, int[] b, int[] c) {
        List<Integer> result = new ArrayList<>();

        Arrays.sort(a);

        int p1, p2, p3 = 0;
        p1 = p2 = p3;
        List<Integer> temp = new ArrayList<>();

        boolean f1, f2, f3;

        while (p1 < a.length || p2 < b.length || p3 < c.length) {
            f1 = p1 < a.length;
            f2 = p2 < b.length;
            f3 = p3 < c.length;
            if (f1) {
                temp.add(a[p1]);
            }
            if (f2) {
                temp.add(b[p2]);
            }
            if (f3) {
                temp.add(c[p3]);
            }

            int min = Collections.min(temp);

            if (f1 && min == a[p1]) {
                p1++;
            }
            if (f2 && min == b[p2]) {
                p2++;
            }
            if (f3 && min == c[p3]) {
                p3++;
            }

            temp.clear();

//            result.add(min);
            if (result.size() > 0 && result.get(result.size() - 1) == min) {
                System.out.println("Already added: " + min);
            } else {
                System.out.println("Adding: " + min);
                result.add(min);
            }
        }

        System.out.println(result);

        return result;
    }
}
