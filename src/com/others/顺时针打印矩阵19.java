package com.others;


/**
 * 来源：剑指offer 29
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 */
public class 顺时针打印矩阵19 {
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2, 3, 4, 1},
                {5, 6, 7, 8, 1},
                {9, 10,11,12, 1},
                {13,14,15,16, 1},
                {13,14,15,16, 1}
        };
        int left = 0;
        int right = array.length-1;
        int on = 0;
        int bottom = array[0].length-1;
        while (left < right  || on < bottom) {
            //从左到右
            for (int a=left; a<=right; a++) {
                System.out.print(array[on][a] + " ");
            }
            System.out.println();
            on++;

            //从上到下
            for (int b=on; b<=bottom; b++) {
                System.out.print(array[b][right] + " ");
            }
            System.out.println();
            right--;

            //从右到左
            for (int c=right; c>=left; c--) {
                System.out.print(array[bottom][c] + " ");
            }
            System.out.println();
            bottom--;

            //从下到上
            for (int d=bottom; d>=on; d--) {
                System.out.print(array[d][left] + " ");
            }
            System.out.println();
            left++;
        }


    }

}
