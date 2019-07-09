package gfuzan.sort;

import java.util.List;;

/**
 * 堆排序
 * @author gfuzan
 *
 */
public class HeapSort {

    /**
     * 执行排序
     * @param array 原数组
     * @return 排序后数组
     */
    public static <T extends Comparable<? super T>> List<T> run(List<T> array) {
        if (array == null) {
            throw new NullPointerException("排序数组不能为空");
        }

        heapInit(array);

        for (int size = array.size(); size > 0;) {
            // 移除堆顶元素并让堆的最后一个元素补位
            T e = array.get(size - 1);
            array.set(size - 1, array.get(0));
            array.set(0, e);
            heapAdjust(array, 1, --size);
        }

        return array;
    }

    /**
     * 初始化堆
     * @param array 数组
     */
    private static <T extends Comparable<? super T>> void heapInit(List<T> array) {
        int size = array.size();

        for (int i = size >> 1; i > 0; i--) {
            heapAdjust(array, i, size - i + 1);
        }
    }

    /**
     * 堆调整
     * @param array 数组
     * @param headIndex 堆头索引,起始值 1
     * @param endIndex 堆大小
     * @return  是否调整
     */
    private static <T extends Comparable<? super T>> void heapAdjust(List<T> array, int headIndex, int size) {

        if (size <= 1) {
            return;
        }

        int eIndex = headIndex;
        T e = array.get(eIndex - 1);
        int endIndex = headIndex + size - 1;

        for (int i = eIndex << 1; i <= endIndex;) {
            int maxIndex = i;
            T min = null;
            // 找到最大子节点的索引
            if (1 + i <= endIndex && (array.get(i).compareTo(array.get(i - 1))) > 0) {
                maxIndex = i + 1;
            }

            // 父节点比子节点中最大的一个小
            if (e.compareTo((min = array.get(maxIndex - 1))) < 0) {
                // 交换
                array.set(eIndex - 1, min);
                array.set(maxIndex - 1, e);
                // 设置比较节点索引
                eIndex = maxIndex;
                // 最小节点的左子节点的索引
                i = maxIndex << 1;
            } else {
                break;
            }
        }
    }
}
