package com.array;

/**
 * 来源：剑指offer 01
 * 在一个二维数组矩阵中[行列相等]，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class 二维数组中的查找 {

    public static void main(String[] args) {
        int [][] arr = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {4, 5, 6, 7, 8, 9},
                {7, 8, 9, 10,11,12},
                {10,11,12,13,14,15},
                {11,12,13,14,15,16},
                {14,15,16,17,18,19}
        };
        System.out.println(hasNum(arr,7));

    }

    static boolean hasNum(int [][] arr, int num){
        if (arr == null) {return false;}
        int row = 0;
        int col = arr.length-1;


        while (col >= 0 && row<=arr.length-1) {

            //获取矩阵右上角的数字
            int ro = arr[row][col];
            System.out.println("["+row+","+col+"]" + " " + ro);

            if (ro == num) {
                return true;
            } else if (ro > num) {
                //ro所在列的所有数字全部都大于num,排除ro所在的列
                col--;

            } else {
                //ro所在行的所有数字全部都小于num,排除ro所在的行
                row++;
            }
        }

        return false;
    }




}
