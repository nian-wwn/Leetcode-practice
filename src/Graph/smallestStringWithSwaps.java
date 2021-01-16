package Graph;
/**
 * @title 1202. 交换字符串中的元素
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 *
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class smallestStringWithSwaps {
    public String smallestStringWithSwaps1(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) {
            return s;
        }
        int len = s.length();
        UnionFind unionFind = new UnionFind(len);
        for (List<Integer> pair : pairs) {
            int index1 = pair.get(0);
            int index2 = pair.get(1);
            unionFind.union(index1, index2);
        }

        char[] charArray = s.toCharArray();
        Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            if (hashMap.containsKey(root)) {
                hashMap.get(root).offer(charArray[i]);
            } else {
                PriorityQueue<Character> minHeap = new PriorityQueue<>();
                minHeap.offer(charArray[i]);
                hashMap.put(root, minHeap);

            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            stringBuilder.append(hashMap.get(root).poll());

        }
        return stringBuilder.toString();


    }

    private class UnionFind {
        private int[] parent;
        /**
         * 指向父节点的权值
         */
        private int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            //初始化
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        //合并
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (rank[rootX] == rank[rootY]) {
                parent[rootX] = rootY;
                rank[rootY]++;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
            }
        }

        /**
         * 路径压缩
         */
        //查询
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);//将每个节点的父节点设为根节点
            }
            return parent[x];
        }

    }
}
