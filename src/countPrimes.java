/**
 * @title 204. 计数质数
 * <p>
 * 统计所有小于非负整数 n 的质数的数量。
 */
public class countPrimes {
    public int countPrimes1(int n) {
        int count = 0;
        if (n <= 1) {
            return 0;
        }

        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isPrimes(int n) {
        for (int j = 2; j <= Math.sqrt(n); j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        int n = 10;
        countPrimes t = new countPrimes();
        System.out.println(t.countPrimes1(n));
    }

}
