package gfuzan.sort;

import java.util.List;

/**
 * 冒泡排序
 * @author gfuzan
 *
 */
public class BubbleSort {

    /**
     * 执行排序
     * @param array 原数组
     * @return 排序后数组
     */
    public static <T extends Comparable<? super T>> List<T> run(List<T> array) {
        if (array == null) {
            throw new NullPointerException("排序数组不能为空");
        }

        int maxIndex = array.size() - 1;

        for (int i = 0; i < maxIndex; i++) {
            for (int j = maxIndex; j > i; j--) {
                T el = null, er = null;
                if ((el = array.get(j)).compareTo((er = array.get(j - 1))) < 0) {
                    // 交换
                    array.set(j, er);
                    array.set(j - 1, el);
                }
            }
        }

        return array;
    }
}
