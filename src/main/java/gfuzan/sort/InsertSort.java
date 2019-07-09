package gfuzan.sort;

import java.util.List;

/**
 * 插入排序
 * @author gfuzan
 *
 */
public class InsertSort {

    /**
     * 执行排序
     * @param array 原数组
     * @return 排序后数组
     */
    public static <T extends Comparable<? super T>> List<T> run(List<T> array) {
        if (array == null) {
            throw new NullPointerException("排序数组不能为空");
        }

        int size = array.size();

        if (size > 1) {
            // 选取元素
            for (int i = 1; i < size; i++) {
                T e = array.get(i);
                // 比较
                for (int j = 0; j < i; j++) {
                    if (e.compareTo(array.get(j)) < 0) {
                        // 元素后移
                        for (int k = i; k > j; k--) {
                            array.set(k, array.get(k - 1));
                        }
                        // 插入
                        array.set(j, e);
                        break;
                    }
                }
            }
        }

        return array;
    }
}
