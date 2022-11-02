
package PL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author DEI-ESINF
 */
public class Utils {
    public static <E extends Comparable<E>> Iterable<E> sortByBST(List<E> listUnsorted) {
        List<E> output = listUnsorted;

        int n = output.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++)
                if (output.get(j).compareTo(output.get(j + 1)) > 0) {
                    E temp = output.get(j);
                    output.set(j, output.get(j + 1));
                    output.set(j + 1, temp);

                }
        }

        return new Iterable<E>() {
            @Override
            public Iterator<E> iterator() {
                return (Iterator<E>) output;
            }
        };
//        return new Iterable<E>() {
//            @Override
//            public Iterator<E> iterator() {
//
//                return new Iterator<E>() {
//                    @Override
//                    public boolean hasNext() {
//                        return false;
//                    }
//
//                    @Override
//                    public E next() {
//                        return null;
//                    }
//                }
//
//            }
//        };
    }

