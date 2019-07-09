package gfuzan.sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 归并排序
 * @author gfuzan
 *
 */
public class MergeSort {

    /**
     * 执行排序
     * @param array 原数组
     * @return 排序后数组
     */
    public static <T extends Comparable<? super T>> List<T> run(List<T> array) {
        if (array == null) {
            throw new NullPointerException("排序数组不能为空");
        }

        divide(array, 0, (array.size() - 1) / 2, array.size() - 1);

        return array;
    }

    /**
     * 分解
     * @param array 数组
     * @param start 开始索引
     * @param mod 中间索引
     * @param end 结束索引
     */
    private static <T extends Comparable<? super T>> void divide(List<T> array, int start, int mod, int end) {
        if (mod < end) {
            divide(array, start, (start + mod) / 2, mod);
            divide(array, mod + 1, (end + mod + 1) / 2, end);
            merge(array, start, mod, end);
        }

    }

    /**
     * 合并
     * @param array 数组
     * @param start 开始索引
     * @param mod 中间索引
     * @param end 结束索引
     */
    private static <T extends Comparable<? super T>> void merge(List<T> array, int start, int mod, int end) {

        // 左队列
        Queue<T> leftQueue = new LinkedList<>();
        for (int i = start; i <= mod; i++) {
            leftQueue.add(array.get(i));
        }

        // 右队列
        Queue<T> rightQueue = new LinkedList<>();
        for (int i = mod + 1; i <= end; i++) {
            rightQueue.add(array.get(i));
        }

        int arrayIndex = start;
        for (; !leftQueue.isEmpty() && !rightQueue.isEmpty();) {

            // 左队列元素与右队列元素比较
            if (leftQueue.peek().compareTo(rightQueue.peek()) < 0) {
                array.set(arrayIndex++, leftQueue.poll());
            } else {
                array.set(arrayIndex++, rightQueue.poll());
            }
        }

        // 左队列复制完了
        if (leftQueue.isEmpty()) {
            for (; !rightQueue.isEmpty();) {
                // 将右队列剩余元素复制到原数组
                array.set(arrayIndex++, rightQueue.poll());
            }
        }

        // 右队列复制完了
        if (rightQueue.isEmpty()) {
            for (; !leftQueue.isEmpty();) {
                // 将左队列剩余元素复制到原数组
                array.set(arrayIndex++, leftQueue.poll());
            }
        }

    }
}