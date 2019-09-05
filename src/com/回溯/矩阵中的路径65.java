package com.回溯;


/**
 * 来源：剑指offer 65
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如在下面的3x4的矩阵中包含一条字符串"bcced"的路径（路径中的字母用斜体表示）。
 * 但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *
 * 下面代码是自己写的，不完全正确
 */
public class 矩阵中的路径65 {

    public static void main(String[] args) {
        String [][] array = new String[][]{
                {"a", "b", "c", "d"},
                {"s", "f", "c", "s"},
                {"a", "d", "e", "e"},
        };
        String [] road = new String[] {"a", "b", "c", "c", "e", "e", "s", "d"};
        boolean result = findRoad(array, road);
        System.out.println(result);
    }

    static boolean findRoad (String[][] array, String[] road) {
        int row = 0;//行
        int col = 0;//列
        int rowTotal = array.length;
        int colTotal = array[0].length;
        int roadIndex = 0;

        for (row=0; row<rowTotal; row++) {
            for (col=0;col<colTotal; col++){
                String item = array[row][col];
                String roadItem = road[0];
                if (item.equals(roadItem)) {
                    int[][] tmp = new int[rowTotal][colTotal];
                    tmp[row][col] = 1;
                    if (findRound(array, row, col, rowTotal, colTotal, road, 1, tmp)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean findRound(String[][] array, int r, int c, int rowT, int colT, String[] road, int roadIndex, int[][] tmp) {
        if (road.length == roadIndex) {
            return true;
        }
        String roadItem = road[roadIndex];
        String on = findOn(array, r, c, rowT, colT, tmp);
        String bottom = findBottom(array, r, c, rowT, colT, tmp);
        String left = findLeft(array, r, c, rowT, colT, tmp);
        String right = findRight(array, r, c, rowT, colT, tmp);

        boolean isOn = false;
        boolean isBottom = false;
        boolean isLeft = false;
        boolean isRight = false;
        if (roadItem.equals(on)) {
            isOn =  findRound(array, r-1, c, rowT, colT, road, roadIndex+1, tmp);
        }
        if (roadItem.equals(bottom)) {
            isBottom = findRound(array, r+1, c, rowT, colT, road, roadIndex+1, tmp);
        }
        if (roadItem.equals(left)) {
            isLeft = findRound(array, r, c-1, rowT, colT, road, roadIndex+1, tmp);
        }
        if (roadItem.equals(right)) {
            isRight = findRound(array, r, c+1, rowT, colT, road, roadIndex+1, tmp);
        }
        return isOn || isLeft || isBottom || isRight;
    }

    static String findOn(String[][] array, int r, int c, int rowT, int colT, int[][] tmp) {
        r = r - 1;
        if (r < 0 || tmp[r][c] == 1) {
            return null;
        }
        tmp[r][c] = 1;
        return array[r][c];
    }

    static String findBottom(String[][] array, int r, int c, int rowT, int colT, int[][] tmp) {
        r = r + 1;
        if (r > rowT - 1 || tmp[r][c] == 1) {
            return null;
        }
        tmp[r][c] = 1;
        return array[r][c];
    }

    static String findLeft(String[][] array, int r, int c, int rowT, int colT, int[][] tmp) {
        c = c - 1;
        if (c < 0 || tmp[r][c] == 1) {
            return null;
        }
        tmp[r][c] = 1;
        return array[r][c];
    }

    static String findRight(String[][] array, int r, int c, int rowT, int colT, int[][] tmp) {
        c = c + 1;
        if (c > colT-1 || tmp[r][c] == 1) {
            return null;
        }
        tmp[r][c] = 1;
        return array[r][c];
    }



}
