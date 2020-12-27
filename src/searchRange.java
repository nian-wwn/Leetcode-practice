/**
 * @title 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 方法一 ：暴力遍历
 * 使用暴力遍历没能利用已经排序的特点
 * 方法二：二分查找
 */
public class searchRange {
    public int[] searchRange1(int[] nums, int target) {
        int len = nums.length;
        int j = 0;
        int[] result = new int[len];
        int[] t = new int[2];
        for (int i = 0; i < len; i++) {
            if (target == nums[i]) {
                result[j] = i;
                j = j + 1;
            }
        }
        if (j == 0) {
            t[0] = -1;
            t[1] = -1;
        } else {
            t[0] = result[0];
            //注意j的最后取值
            t[1] = result[j - 1];
        }

        return t;
    }

    //二分法
    public static int[] searchRange2(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false) - 1;

        if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target) {
            return new int[]{leftIndex, rightIndex};
        } else {
            return new int[]{-1, -1};
        }
    }


    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (right - left + 1) / 2 + left;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
