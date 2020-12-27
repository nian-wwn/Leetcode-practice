/**
 * @title 321. 拼接最大数
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * <p>
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * <p>
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * <p>
 * <p>
 * 方法一：单调栈  满足从栈底到栈顶递减
 */
public class maxNumber {
    public int[] maxNum(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] maxSubSequence = new int[k];
        int start = Math.max(0, k - n), end = Math.min(k, m);

        for (int i = start; i <= end; i++) {
            int[] subsequence1 = maxSubSequence(nums1, i);
            int[] subsequence2 = maxSubSequence(nums2, k - i);
            int[] curMaxSubsequence = merge(subsequence1, subsequence2);
            if (compare(curMaxSubsequence, 0, maxSubSequence, 0) > 0) {
                System.arraycopy(curMaxSubsequence, 0, maxSubSequence, 0, k);
            }
        }
        return maxSubSequence;
    }

    public int[] maxSubSequence(int[] nums, int k) {
        int len = nums.length;
        int[] stack = new int[k];
        int top = -1;
        int remain = len - k;

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                remain--;
            }

        }
        return stack;
    }

    public int[] merge(int[] subsequence1, int[] subsequence2) {
        int x = subsequence1.length;
        int y = subsequence2.length;

        if (x == 0) {
            return subsequence2;
        }
        if (y == 0) {
            return subsequence1;
        }

        int mergeLength = x + y;
        int[] merged = new int[mergeLength];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < mergeLength; i++) {
            if (compare(subsequence1, index1, subsequence2, index2) > 0) {
                merged[i] = subsequence1[index1++];
            } else {
                merged[i] = subsequence2[index2++];
            }
        }
        return merged;
    }

    public int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;

        }
        return (x - index1) - (y - index2);
    }
}
