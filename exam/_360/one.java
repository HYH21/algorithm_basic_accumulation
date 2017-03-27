package algorithm_basic_accumulation.exam._360;

import java.util.Scanner;

/**
 * Created by HYH on 2017/3/25.
 */
public class one {

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt())
        {
            double sum = 0;
            int count = cin.nextInt();
            for(int i = 0; i < count; i++) {
                int num = cin.nextInt();
                int persent = cin.nextInt();
                sum += 1.000 * num * persent / 100;
            }
            System.out.println(String.format("%.3f", sum));
        }
    }
}
