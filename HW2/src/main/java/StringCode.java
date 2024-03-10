import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adjacent chars that are the same.
     *
     * @param str is the input string
     * @return max run length
     */
    public static int maxRun(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        int max = 1;
        int curr = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                curr++;
                if (curr > max) {
                    max = curr;
                }
            } else {
                curr = 1;
            }
        }

        return max;
    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     *
     * @param str is the input string
     * @return blown up string
     */
    public static String blowup(String str) {
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                if (i != str.length() - 1) {
                    char temp = str.charAt(i + 1);
                    int times = Character.getNumericValue(c);
                    for (int j = 0; j < times; j++) {
                        ans += temp;
                    }
                } else {
                    ans += "";
                }
            } else {
                ans += c;
            }
        }

        return ans;
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        HashSet<String> s = new HashSet<String>();
        for (int i = 0; i < a.length() - len + 1; i++) {
            s.add(a.substring(i, i + len - 1));
        }

        for (String str : s) {
            if (b.contains(str)) {
                return true;
            }
        }

        return false;
    }
}
