package com.yq.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.google.common.collect.Lists;

/**
 * @author BaoLei Li
 * @date 2022/9/21
 **/
public class ProvinceBFS {

    public static void main(String[] args) {
//        System.out.println(getProvince(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})); // 2
//        System.out.println(getProvince(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}})); // 3

        Queue queue = new LinkedList<Integer>();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());
        System.out.println(queue.poll());


        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }

    private static int getProvince(int[][] initCitys) {
        final int citys = initCitys.length;
        boolean[] visited = new boolean[citys];
        int provinces = 0;
        for (int i = 0; i < citys; i++) {
            if (!visited[i]){
                visited[i] = true;
                bfs(i,citys,initCitys,visited, Lists.newArrayList());
                provinces++;
            }
        }
        return provinces;
    }

    private static void bfs(int i, int citys, int[][] initCitys, boolean[] visited, List<Integer> thisLevel) {
        for (int j = 0; j < citys; j++) {
            if (initCitys[i][j] == 1 && !visited[j]){
                visited[j] = true;
                thisLevel.add(j);
            }
        }
        while (thisLevel.iterator().hasNext() && !visited[thisLevel.iterator().next()]){
            bfs(thisLevel.iterator().next(), citys, initCitys, visited, Lists.newArrayList());
            thisLevel.remove(thisLevel.iterator().next());
        }
    }

}
