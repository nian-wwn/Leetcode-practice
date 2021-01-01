package Tanxin;

/**
 *
 */
public class canPlaceFlowers {
    public boolean canPlaceFlowers1(int[] nums) {
        int n = nums.length;
        int count = 0;
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    count += (i - prev - 2) / 2;
                }
                prev = i;
            }
        }
        if (prev < 0) {
            count += (n + 1) / 2;
        } else {
            count += (n - prev - 1) / 2;
        }
        return n <=count;
    }
}
