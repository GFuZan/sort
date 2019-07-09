package gfuzan.sort;

import java.util.List;

/**
 * 快速排序
 * @author gfuzan
 *
 */
public class QuickSort {

    /**
     * 执行排序
     * @param array 原数组
     * @return 排序后数组
     */
    public static <T extends Comparable<? super T>> List<T> run(List<T> array) {

        if (array == null) {
            throw new NullPointerException("排序数组不能为空");
        }

        int start = 0;
        int end = array.size() - 1;

        sort(array, start, end);

        return array;
    }

    private static <T extends Comparable<? super T>> void sort(List<T> array, int start, int end) {

        if (start >= end) {
            return;
        }
        int l = start;
        int r = end;

        T e = array.get(l);
        T tmp = null;

        while (l < r) {
            while (l < r && e.compareTo((tmp = array.get(r))) < 0)
                r--;
            array.set(l, tmp);
            while (l < r && e.compareTo((tmp = array.get(l))) > 0)
                l++;
            array.set(r, tmp);
        }
        array.set(l, e);

        sort(array, start, --r);
        sort(array, ++l, end);

    }
}
