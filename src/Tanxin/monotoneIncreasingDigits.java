package Tanxin;

/**
 * title 738.单调递增的数字
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * <p>
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 */
public class monotoneIncreasingDigits {
    public int monotoneIncreasingDigits1(int nums) {
        //转化为字符串存入数组
        char[] strN = Integer.toString(nums).toCharArray();
        int i = 1;
        //获取第一个strN[i]>strN[i-1]的位置
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }

        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        //转化为int
        return Integer.parseInt(new String(strN));
    }
}
