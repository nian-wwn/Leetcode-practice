import java.util.ArrayList;
import java.util.List;

/**
 * title 228. 汇总区间
 *给定一个无重复元素的有序整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 */

public class summaryRanges {
    public List<String> summaryRanges1(int[] nums) {
        int n = nums.length;
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            list.add(temp.toString());
        }
        return list;
    }
}
