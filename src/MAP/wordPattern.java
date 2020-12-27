package MAP;
/**
 *
 * title 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律.
 *
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 */

import java.util.HashMap;
import java.util.Map;

public class wordPattern {
    //双哈希表
    public boolean wordPattern1(String pattern, String str) {
        Map<String, Character> str1 = new HashMap<String, Character>();
        Map<Character, String> str2 = new HashMap<Character, String>();
        //
        int m = str.length();
        int i = 0;
        for (int p = 0; p < pattern.length(); p++) {
            //获取pattern的第一个字符
            char c = pattern.charAt(p);
            if (i >= m) {
                return false;
            }
            int j = i;
            while (j < m && str.charAt(j) != ' ') {
                j++;
            }
            //substring(i,j) 提取i和j之间的字符
            //取得str的第一个字符串
            String tmp = str.substring(i, j);

            if (str1.containsKey(tmp) && str1.get(tmp) != c) {
                return false;
            }
            if (str2.containsKey(c) && !tmp.equals(str2.get(c))) {
                return false;
            }
            str1.put(tmp, c);
            str2.put(c, tmp);
            i = j + 1;

        }
        return i >= m;
    }

    //单哈希表
    public boolean wordPattern2(String pattern, String s) {
        Map<Character, String> str = new HashMap<Character, String>();
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (!str.containsKey(pattern.charAt(i))) {
                if (str.containsValue(arr[i])) {
                    return false;
                }
                str.put(pattern.charAt(i), arr[i]);
            } else {
                if (!str.get(pattern.charAt(i)).equals(arr[i])) {
                    return false;
                }
            }


        }
        return true;
    }

//    public static void main(String[] args) {
//        String str = "dog cat";
//        char ch = str.charAt(0);
//        String tmp = str.substring(0, 3);
//        String[] arr = str.split(" ");
//        System.out.println(ch + tmp);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//
//    }


}
