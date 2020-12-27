import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 贪心算法
 *
 * @title 767. 重构字符串
 * <p>
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 */
public class reorganizeString {
    public String reorganizeStr(String S) {
        int n = S.length();
        int maxCount = 0;
        if (n < 2) {
            return S;
        }
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            count[c - 'a']++;
            maxCount = Math.max(maxCount, count[c - 'a']);
        }
        if (maxCount > (n + 1) / 2) {
            return "";
        }
        //PriorityQueue 是基于优先堆的无界队列，其中的元素可默认自然排序或通过compare比较器在队列实例化时排序
        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return count[o2 - 'a'] - count[o1 - 'a'];
            }
        });

        for (char c = 'a'; c <= 'z'; c++) {
            if (count[c - 'a'] > 0) {
                queue.offer(c);
            }
        }

        StringBuffer sb = new StringBuffer();
        while (queue.size() > 1) {
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            int index1 = letter1 - 'a', index2 = letter2 - 'a';

            count[index1]--;
            count[index2]--;

            if (count[index1] > 0) {
                queue.offer(letter1);
            }
            if (count[index2] > 0) {
                queue.offer(letter2);
            }

        }
        if (queue.size() > 0) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }


}
