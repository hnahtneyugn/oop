
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {
    private List<T> rules;

    /**
     * Constructs a new Taboo using the given rules (see handout.)
     *
     * @param rules rules for new Taboo
     */
    public Taboo(List<T> rules) {
        this.rules = rules;
    }

    /**
     * Returns the set of elements which should not follow
     * the given element.
     *
     * @param elem is the element whose other elements should not follow
     * @return elements which should not follow the given element
     */
    public Set<T> noFollow(T elem) {
        HashSet<T> s = new HashSet<T>();
        if (!rules.contains(elem)) {
            return Collections.emptySet();
        } else {
            Iterator<T> it = rules.iterator();
            T curr;
            T next;
            while (it.hasNext()) {
                curr = it.next();
                if (curr.equals(elem) && it.hasNext()) {
                    next = it.next();
                    if (next != null) {
                        s.add(next);
                    }
                }
            }
            return s;
        }
    }

    /**
     * Removes elements from the given list that
     * violate the rules (see handout).
     *
     * @param list collection to reduce
     */
    public void reduce(List<T> list) {
        Iterator<T> it = list.iterator();
        T curr = list.get(0);
        while (it.hasNext()) {
            T next = it.next();
            if (curr != null & next != null && rules.contains(curr) && noFollow(curr).contains(next)) {
                list.remove(next);
            } else {
                curr = next;
            }
        }
    }
}
