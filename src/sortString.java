/**
 *
 * @title 1370. 上升下降字符串
 *
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 *
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 *
 *
 */
public class sortString {
    public String sort_String(String s){
        int[] table = new int[26];
        for (int i = 0; i<s.length();i++){
            table[s.charAt(i)-'a']++;
        }
        /**
         *  StringBuffer是可变类，和线程安全的字符串操作类，任何对它指向的字符串的操作都不会产生新的对象。
         *  每个StringBuffer对象都有一定的缓冲区容量，当字符串大小没有超过容量时，不会分配新的容量，当字符串大小超过容量时，会自动增加容量
         */
        StringBuffer ret = new StringBuffer();
        while (ret.length()<s.length()){
            for (int j = 0;j<26;j++){
                if (table[j]>0){
                    ret.append((char)(j+'a'));
                    table[j]--;
                }
            }
            for (int i = 25;i>=0;i--){
                if (table[i]>0){
                    ret.append((char)(i+'a'));
                    table[i]--;
                }
            }
        }
        return ret.toString();
    }
}
