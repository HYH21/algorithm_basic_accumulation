package algorithm_basic_accumulation.exam._360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by HYH on 2017/3/25.
 *
 * 任务列表：机器会执行主要任务和临时任务，临时任务只有在主要任务不执行的时候执行，
 * 并多个临时任务可以在一个机器时间里面执行，且只需要一个机器时间
 *
 * 输入：
 * 5 6
 * 1 2 3 5 6
 * 3
 * 2
 * 1
 * 4
 * 5
 * 6
 *
 * 输出：
 * 4
 * 4
 * 4
 * 4
 * 7
 * 7
 *
 * 实现：遍历主要任务的执行时间，找出CPU空闲时间表，遍历临时任务的输入，直接得出结果
 * 只打到了AC：47%
 */
public class three {

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        List<Bean> list = new ArrayList<>();
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            int preInt = cin.nextInt();
            int lastInt = preInt;
            for (int i = 1; i < n; i++) {
                int num = cin.nextInt();
                lastInt = num;

                if (num - preInt <= 1) {
                    preInt = num;
                    continue;
                }
                list.add(new Bean(preInt, num));
                preInt = num;
            }

            for (int j = 0; j < m; j++) {
                int inTime = cin.nextInt();
                boolean isSuc = false;
                for (int i = 0; i < list.size(); i++) {
                    if (inTime <= list.get(i).start + 1) {
                        System.out.println(list.get(i).start + 1);
                        isSuc = true;
                    }
                    if (inTime > list.get(i).start + 1 && inTime < list.get(i).end) {
                        System.out.println(inTime);
                        isSuc = true;
                    }
                    if (isSuc) {
                        break;
                    }
                }
                if (!isSuc) {
                    System.out.println(lastInt + 1);
                }
            }
        }
    }

    private static class Bean {
        int start;
        int end;

        public Bean(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
