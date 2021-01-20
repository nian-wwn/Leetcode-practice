import java.util.Arrays;

/**
 * @title 628. 三个数的最大乘积
 *
 *
 */
public class maximumProduct {
    public int maximumProduct1(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int ret= Math.max(nums[len-1] * nums[len - 2] * nums[len - 3],nums[0]*nums[1]*nums[len-1]);
        return ret;
    }

}
