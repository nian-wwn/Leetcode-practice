public class findTheDifference {
    public char findTheDifference1(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return c;
            }
        }
        return ' ';
    }
}
