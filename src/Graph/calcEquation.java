package Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class calcEquation {
    public double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();

        UnionFind unionFind = new UnionFind(2 * equationsSize);
        //第一步：预处理，将变量的值与id进行映射，使得并查集的底层使用数组实现，方便编码。
        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;

        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String val1 = equation.get(0);
            String val2 = equation.get(1);

            if (!hashMap.containsKey(val1)) {
                hashMap.put(val1, id);
                id++;
            }
            if (!hashMap.containsKey(val2)) {
                hashMap.put(val2, id);
                id++;
            }
            unionFind.union(hashMap.get(val1), hashMap.get(val2), values[i]);
        }

        //第二步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if (id1 == null || id2 == null) {
                res[i] = -1.0;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }

        }
        return res;
    }

    private class UnionFind {
        private int[] parent;

        /**
         * 指向父节点的权值
         */
        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            //初始化
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
        }

        /**
         * 路径压缩
         */
        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }
}

