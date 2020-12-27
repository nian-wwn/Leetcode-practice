import java.util.*;

/**
 * title 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class groupAnagrams {
    //哈希表
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        //遍历每个字符进行排序
        for (String str : strs) {
            //排序
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
