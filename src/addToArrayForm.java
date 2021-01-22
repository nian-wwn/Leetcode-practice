import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @title 989. 数组形式的整数加法
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 */
public class addToArrayForm {
    public List<Integer> addToArrayForm1(int[] A, int k) {
        List<Integer> res = new LinkedList<Integer>();
        int n = A.length;
        for (int i = n - 1; i >= 0; i--) {
            int sum = A[i] + k % 10;
            k = k / 10;
            if (sum >= 10) {
                k++;
                sum -= 10;
            }
            res.add(sum);
        }
        for (; k > 0; k /= 10) {
            res.add(k%10);
        }
        Collections.reverse(res);
        return res;

    }
}
