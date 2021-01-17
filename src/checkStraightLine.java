public class checkStraightLine {
    /**
     * @title 1232. 缀点成线
     * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点
     * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
     *
     */
    //数学方法，避免除法
    public boolean checkStraightLine1(int[][] coordinates) {
        int n = coordinates.length;
        int X = coordinates[0][0], Y = coordinates[0][1];
        for (int i = 0; i < n; i++) {
            coordinates[i][0] -= X;
            coordinates[i][1] -= Y;
        }

        int A = coordinates[1][1], B = -coordinates[1][0];

        for (int i = 2; i < n; i++) {
            if (coordinates[i][0]*A + B*coordinates[i][1] != 0){
                return false;
            }
        }
        return true;
    }
}
