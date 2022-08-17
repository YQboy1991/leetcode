package com.yq.leetcode;

import java.util.LinkedList;

/**
 * @author BaoLei Li
 * @date 2022/8/16
 **/
public class TuDFS {

    public static class Graph { // 无向图
        private int v; // 顶点的个数
        private LinkedList<Integer> adj[]; // 邻接表
        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }
        public void addEdge(int s, int t) { // 无向图一条边存两次
            adj[s].add(t);
            adj[t].add(s);
        }

        boolean found = false; // 全局变量或者类成员变量

        public void dfs(int s, int t) {
            found = false;
            boolean[] visited = new boolean[v];
            int[] prev = new int[v];
            for (int i = 0; i < v; ++i) {
                prev[i] = -1;
            }
            recurDfs(s, t, visited, prev);
            print(prev, s, t);
        }
        private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
            if (found == true) {
                return;
            }
            visited[w] = true;
            if (w == t) {
                found = true;
                return;
            }
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    recurDfs(q, t, visited, prev);
                }
            }
        }
        private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
            if (prev[t] != -1 && t != s) {
                print(prev, s, prev[t]);
            }
            System.out.print(t + " ");
        }
    }

    public static void main(String[] args) {
        final Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(2, 5);
        graph.addEdge(4, 6);
        graph.addEdge(6, 7);
        graph.addEdge(5, 7);

        graph.dfs(0, 6);

    }
}
