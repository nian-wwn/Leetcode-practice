/**
 * title 135.分发糖果
 *
 *老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 */
public class candy {
    public int candy(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[i - 1] && i < n) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        for (int i = n - 1; i >= 0; i++) {
            if (nums[i] > nums[i + 1] && i < n - 1) {
                right++;
            } else {
                right = 1;
            }
            ret = Math.max(left[i], right);
        }
        return ret;
    }
}
