package Tanxin;

/**
 * title 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 */
public class removeDuplicateLetters {
    //贪心+栈
    public String removeDuplicateLetters1(String s) {
        boolean[] vis = new boolean[26]; //记录字符是否出现在栈中
        int[] num = new int[26];
        //统计字符最后一次出现的位置及数量
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer str = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //ch是否已经存在于栈中，如果存在，
            if (!vis[ch - 'a']) {
                //如果栈不为空，且当前字符在栈顶字符之前
                while (str.length() > 0 && str.charAt(str.length() - 1) > ch) {
                    //并且字符串中还有栈顶元素，则将栈顶元素删除
                    if (num[str.charAt(str.length() - 1) - 'a'] > 0) {
                        vis[str.charAt(str.length() - 1) - 'a'] = false;
                        str.deleteCharAt(str.length() - 1);
                    } else {
                        //如果栈顶元素只有一个，留在栈中，直接下个字符
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                str.append(ch);
            }
            num[ch - 'a']--;
        }
        return str.toString();
    }

}
