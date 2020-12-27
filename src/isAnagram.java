import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @title 242. 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 方法一： 排序
 * 时间复杂度：O(n \log n)O(n log n)，
 * 空间复杂度：O(\log n)O(log n)
 * <p>
 * 方法二： 哈希表
 */


public class isAnagram {
    public boolean is_Anagram(String str1, String str2) {
        //两个字符长度不一样，肯定不相同
        if (str1.length() != str2.length()) {
            return false;
        }
        //将字符串存入数组中方便排序
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        //排序后直接比较
        return Arrays.equals(arr1, arr2);
    }

    public boolean is_Anagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] table = new int[26];

        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    //哈希表
    public boolean is_Anagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> table = new HashMap<Character, Integer>();
        //将s字符存入哈希表，key为字符，value为s中字符的个数
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch,table.getOrDefault(ch,0)+1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch,table.getOrDefault(ch,0)-1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }

}
