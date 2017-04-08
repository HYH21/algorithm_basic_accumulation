package algorithm_basic_accumulation.exam.wanmeishijie;

import java.util.Scanner;

/**
 * Created by HYH on 2017/3/29.
 *
 * 年会游戏：
 * 使用动态规划求解背包问题
 */
public class two {


    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt())
        {
            int count = cin.nextInt();
            int[] rewardValue = new int[count];
            int[] rewardWeight = new int[count];
            for(int i = 0; i < count; i++) {
                rewardValue[i] = cin.nextInt();
            }
            for(int i = 0; i < count; i++) {
                rewardWeight[i] = cin.nextInt();
            }
            int maxWeight = cin.nextInt();
            System.out.println(reward(maxWeight, count, rewardWeight, rewardValue));
        }
    }

    public static int reward(int max_weight, int count, int[] weight, int[] value) {
        int arr[][] = new int[count + 1][max_weight + 1];

        for (int i = 1; i < count + 1; i++) {
            for (int j = 1; j < max_weight + 1; j++) {
                if (weight[i - 1] <= j) {
                    if (arr[i - 1][j] < (arr[i - 1][j - weight[i - 1]] + value[i - 1]))
                        arr[i][j] = arr[i - 1][j - weight[i - 1]] + value[i - 1];
                    else
                        arr[i][j] = arr[i - 1][j];
                } else
                    arr[i][j] = arr[i - 1][j];
            }
        }
        return arr[count][max_weight];
    }
}
