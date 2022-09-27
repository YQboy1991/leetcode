package com.yq.leetcode;

import java.util.Arrays;

/**
 * 预测赢家 || 石子游戏
 * @author BaoLei Li
 * @date 2022/9/22
 **/
public class PredictWinner {

    public static void main(String[] args) {
        int[] arr = new int[]{10,11,5,5,8};

        // 总分
        final int sum = Arrays.stream(arr).sum();
        int person1 = maxScore(arr, 0, arr.length - 1);
        System.out.println("person1:" + person1);
        System.out.println("person2:" + (sum-person1));

        // 问题:怎么打印 person1 每次应该拿的数
    }

    public static int maxScore(int[] arr, int left, int right) {
        int lScore = 0, rScore = 0;
        if (left == right){
//            System.out.println(arr[left]);
            return arr[left];
        }
//        if (right - left == 1){
//            lScore = arr[left];
//            rScore = arr[right];
//        }
        if (right - left >= 1){
            lScore = arr[left] + Math.min(maxScore(arr, left+2, right), maxScore(arr, left + 1,right -1));
            rScore = arr[right] + Math.min(maxScore(arr, left, right-2), maxScore(arr, left+1,right-1));
            // 打印每次取的数
//            if (lScore >= rScore){
//                System.out.println(arr[left]);
//            }else {
//                System.out.println(arr[right]);
//            }
        }
        return Math.max(lScore, rScore);
    }


}
