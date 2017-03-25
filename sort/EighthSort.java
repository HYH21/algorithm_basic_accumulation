package algorithm_basic_accumulation.sort;

/**
 * Created by HYH on 2017/3/15.
 * 常见的排序算法
 */
public class EighthSort {

    /**
     * 插入排序
     * avg:O(n^2)、best:O(n)、worst:O(n^2)
     * isStable：true
     * Space:O(1)
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * 希尔排序(Shell)，插入排序的改进，抓住插入排序在数组基本排好序的情况下性能较好
     * avg:O(n^1.3)、best:O(n)、worst:O(n^2)
     * isStable：false
     * Space:O(1)
     *
     * @param arr
     */
    public static void shellInsertSort(int[] arr) {
        int shell = 3;
        while (shell >= 1) {
            for (int i = shell; i < arr.length; i += shell) {
                int key = arr[i];
                int j = i - shell;
                while (j >= 0 && arr[j] > key) {
                    arr[j + shell] = arr[j];
                    j -= shell;
                }
                arr[j + shell] = key;
            }
            shell--;
        }
    }

    /**
     * 直接选择排序
     * avg:O(n^2)、best:O(n^2)、worst:O(n^2)
     * isStable：false
     * Space:O(1)
     *
     * @param arr
     */
    public static void directSelectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    /**
     * 堆排序
     * avg:O(nlogn)、best:O(nlogn)、worst:O(nlogn)
     * isStable：false
     * Space:O(1)
     */

    /**
     * 冒泡排序
     * avg:O(n^2)、best:O(n)、worst:O(n^2)
     * isStable：true
     * Space:O(1)
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }

    /**
     * 快速排序
     * avg:O(nlogn)、best:O(nlogn)、worst:O(n^2)
     * isStable：false
     * Space:O(nlogn)
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        int flag;
        if (start < end) {
            flag = partition(arr, start, end);
            quickSort(arr, start, flag - 1);
            quickSort(arr, flag + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int key = arr[start];
        // 当start == end的时候，退出循环
        while (start < end) {
            while (start < end && arr[end] >= key) {
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start] <= key) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = key;
        return start;
    }

    /**
     * 归并排序
     * avg:O(nlogn)、best:O(nlogn)、worst:O(nlogn)
     * isStable：true
     * Space:O(n)
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        int[] assistArr = new int[arr.length];
        mergeSort(arr , assistArr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] srcArr, int[] assistArr, int start, int end) {
        // 分到最小则结束递归
        if (start >= end) return;

        // 分割成两半进行归并
        int len = end - start, mid = (len >> 1) + start;
        int startLeft = start, endLeft = mid;
        int startRight = mid + 1, endRight = end;
        mergeSort(srcArr, assistArr, startLeft, endLeft);
        mergeSort(srcArr, assistArr, startRight, endRight);

        int index = start;
        // 归并
        while(startLeft <= endLeft && startRight <= endRight) {
            assistArr[index++] = srcArr[startLeft] < srcArr[startRight] ?
                    srcArr[startLeft++] : srcArr[startRight++];
        }
        while(startLeft <= endLeft) {
            assistArr[index++] = srcArr[startLeft++];
        }
        while(startRight <= endRight) {
            assistArr[index++] = srcArr[startRight++];
        }

        // 复制到源数组，可以优化，减少复制
        for(index = start; index <= end; index++ ) {
            srcArr[index] = assistArr[index];
        }
    }

    /**
     * 基数排序、桶排序
     * avg:O(d(r+n))、best:O(d(r+n))、worst:O(d(rd+n))
     * r:关键字基数、n:关键字个数、d:长度
     * isStable：true
     * Space:O(rd+n)
     */
}
