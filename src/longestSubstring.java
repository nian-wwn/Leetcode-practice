/**
 * 395. 至少有 K 个重复字符的最长子串
 *给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 */
public class longestSubstring {
    //方法一 分治

    /**
     * 对于字符串 ss，如果存在某个字符 \textit{ch}ch，
     * 它的出现次数大于 00 且小于 kk，则任何包含 \textit{ch}ch 的子串都不可能满足要求。
     * 也就是说，我们将字符串按照 \textit{ch}ch 切分成若干段，则满足要求的最长子串一定出现在某个被切分的段内，而不能跨越一个或多个段。
     * 因此，可以考虑分治的方式求解本题。
     *
     */
    public int longestSubstring1(String s, int k) {
        int n = s.length();
        return dfc(s, 0, n - 1, k);
    }

    public int dfc(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        //统计每个字符在字符串中出现的次数
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return r - l + 1;
        }

        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }

            int length = dfc(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "abacb";
        longestSubstring test = new longestSubstring();
        System.out.println(test.longestSubstring1(s, 2));
    }
}
