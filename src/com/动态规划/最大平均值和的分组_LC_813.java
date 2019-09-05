package com.动态规划;

/**
 * 我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。
 * 注意我们必须使用 A 数组中的每一个数进行分组，并且分数不一定需要是整数。
 * 示例:
 * 输入:
 * A = [9,1,2,3,9]
 * K = 3
 * 输出: 20
 *
 * 解释:
 * A 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * 我们也可以把 A 分成[9, 1], [2], [3, 9].
 * 这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
 *
 * https://blog.csdn.net/qq_38595487/article/details/84202289
 */
public class 最大平均值和的分组_LC_813 {

    public static void main(String[] args) {

        int[] A = new int[]{9,1,2,3,9};
        int K = 3;
        System.out.println(getMax(A, K));
        //System.out.println(largestSumOfAverages(A,K));

    }



    static double getMax (int[] A, int K) {
        int len  = A.length;
        //step 1 构造求和数组
        double sum[] = new double[len];
        sum[0] = A[0];
        for (int s=1; s<len; s++) {
            sum[s] = sum[s-1] + A[s];
        }

        //step 2
        double[][] dp = new double[K][len];
        for (int i=0; i<K; i++) {
            for (int j=0; j<len; j++) {
                if (i == 0) {
                    dp[i][j] = sum[j] / (j+1);
                } else {
                    dp[i][j] = dp[i-1][j];
                    for (int r=j-1; r>=0; r--) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][r] + (sum[j]-sum[r])/(j-r));
                    }
                }
            }
        }

        return dp[K-1][len-1];
    }

    static void print(int [] array) {
        for (int i=0;i<array.length;i++) {
            System.out.print(array[i] + ", ");
        }
    }


}
