import java.util.*;

public class Appearances {

    /**
     * Returns the number of elements that appear the same number
     * of times in both collections. Static method. (see handout).
     *
     * @return number of same-appearance elements
     */
    public static <T> int sameCount(Collection<T> a, Collection<T> b) {
        int count = 0;
        HashMap<T, Integer> map1 = new HashMap<T, Integer>();
        HashMap<T, Integer> map2 = new HashMap<T, Integer>();

        for (T i : a) {
            if (!map1.containsKey(i)) {
                map1.put(i, 1);
            } else {
                map1.put(i, map1.get(i) + 1);
            }
        }

        for (T i : b) {
            if (!map2.containsKey(i)) {
                map2.put(i, 1);
            } else {
                map2.put(i, map2.get(i) + 1);
            }
        }

        for (T i : map1.keySet()) {
            if (map2.containsKey(i) && map1.get(i).equals(map2.get(i))) {
                count++;
            }
        }

        return count;
    }

}
