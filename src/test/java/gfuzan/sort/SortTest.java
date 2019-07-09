package gfuzan.sort;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SortTest {

    private List<Integer> array = null;

    /**
     * 冒泡排序
     */
    @Test
    public void test_01() {
        array = Arrays.asList(5, 8, 6, 4, 9, 0, 2, 3, 1, 7);

        BubbleSort.run(array);

        printList("冒泡排序", array);
    }

    /**
     * 插入排序
     */
    @Test
    public void test_02() {
        array = Arrays.asList(5, 8, 6, 4, 9, 0, 2, 3, 1, 7);

        InsertSort.run(array);

        printList("插入排序", array);
    }

    /**
     * 快速排序
     */
    @Test
    public void test_03() {
        array = Arrays.asList(5, 8, 6, 4, 9, 0, 2, 3, 1, 7);

        QuickSort.run(array);

        printList("快速排序", array);
    }

    /**
    * 归并排序
    */
    @Test
    public void test_04() {
        array = Arrays.asList(5, 8, 6, 4, 9, 0, 2, 3, 1, 7);

        MergeSort.run(array);

        printList("归并排序", array);
    }

    /**
    * 堆排序
    */
    @Test
    public void test_05() {
        array = Arrays.asList(5, 8, 6, 4, 9, 0, 2, 3, 1, 7);

        HeapSort.run(array);

        printList("　堆排序", array);
    }

    private void printList(String method, List<?> array) {
        System.out.print(method + ": ");
        for (Object e : array) {
            System.out.print(e);
        }
        System.out.println();
    }
}
