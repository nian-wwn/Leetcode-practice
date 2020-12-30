package MAP;

import java.util.HashMap;
import java.util.Map;

public class twoSum {
    /**
     * @title 1. 两数之和
     * <p>
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     */
    //哈希表法 时间复杂度 O（N）
    public int[] two_Sum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
