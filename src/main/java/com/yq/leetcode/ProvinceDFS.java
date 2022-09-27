package com.yq.leetcode;

/**
 * @author BaoLei Li
 * @date 2022/9/21
 **/
public class ProvinceDFS {

    public static void main(String[] args) {
        System.out.println(getProvince(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})); // 2
        System.out.println(getProvince(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}})); // 3
    }

    private static int getProvince(int[][] initCitys) {
        final int citys = initCitys.length;
        boolean[] visited = new boolean[citys];
        int provinces = 0;
        for (int i = 0; i < citys; i++) {
            if (!visited[i]){
                visited[i] = true;
                dfs(i,citys,initCitys,visited);
                provinces++;
            }
        }
        return provinces;
    }

    private static void dfs(int i, int citys, int[][] initCitys, boolean[] visited) {
        for (int j = 0; j < citys; j++) {
            if (initCitys[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(j, citys, initCitys, visited);
            }
        }
    }


}
