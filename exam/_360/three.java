package algorithm_basic_accumulation.exam._360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by HYH on 2017/3/25.
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
