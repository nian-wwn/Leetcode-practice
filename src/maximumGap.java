import java.util.Arrays;
import java.util.Map;

/**
 * @title 164. 最大间距
 * <p>
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * <p>
 * 如果数组元素个数小于 2，则返回 0。
 *
 *
 */

public class maximumGap {
    //使用sort函数
    public int maxi_mumGap(int[] num) {
        int len = num.length;
        int max = Integer.MIN_VALUE;
        if (len < 2) {
            return 0;
        }
        Arrays.sort(num);
        for (int i = 1; i < len; i++) {
            int temp = num[i] - num[i - 1];
            max = Math.max(temp, max);
        }
        return max;
    }

    //使用基排序
    public int maxi_mumGap1(int[] num) {
        int n = num.length;
        if (n < 2) {
            return 0;
        }
        long exp = 1;
        //创建临时数组用来存储每次排完序的数组
        int[] buf = new int[n];
        //
        int maxValue = Arrays.stream(num).max().getAsInt();

        while (maxValue >= exp) {
            //创建桶
            int[] cnt = new int[10];
            //统计每个桶中的个数
            for (int i = 0; i < n; i++) {
                //digit为num数组中的第i位数
                int digit = (num[i] / (int) exp) % 10;
                cnt[digit]++;
            }
            //cnt[i]原本表示每个桶的数量，----》 在数组中的索引
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }
            //按低位大小进行排序，cnt[digit]-1 表示为排序后num[i]应该在的位置
            for (int i = n - 1; i >= 0; i--) {
                int digit = (num[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = num[i];
                cnt[digit]--;
            }
            //将临时数组buf拷贝给num
            System.arraycopy(buf, 0, num, 0, n);
            exp *= 10;
        }

        int ret = 0;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, num[i] - num[i - 1]);
        }
        return ret;
    }

//    //桶排序
//    public int maxi_mumGap2(int[] num){
//
//    }

}
