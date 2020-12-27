package MAP;

import java.util.HashMap;
import java.util.Map;

public class isIsomorphic {
    public boolean isIsomorphic1(String s, String t) {
        Map<Character, Character> str1 = new HashMap<Character, Character>();
        Map<Character, Character> str2 = new HashMap<Character, Character>();
        int m = s.length();
        int n = t.length();
        if (m != n) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            if ((str1.containsKey(x) && str1.get(x) != y) || (str2.containsKey(y) && str2.get(y) != x)) {
                return false;
            }
            str1.put(x,y);
            str2.put(y,x);
        }
        return true;
    }
}
