package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Author: Xiyao Li
 * Date: 2024/2/23 1:55
 */

public class Test {
    public static final String OP = "merge";
    public static final SortManager SORT_MANAGER = new SortManager();
    public static final int AMOUNT = 100000;

    public static void main(String[] args) {
//        构建一个由0-9按随机顺序组成的数组
        int[] nums = constructArray();
        int[] oldArray = Arrays.copyOf(nums, nums.length);

        long start = System.currentTimeMillis();
//        使用OP方法排序
        nums = SORT_MANAGER.sort(nums, OP);
        long end = System.currentTimeMillis();


//        打印排序结果
        printResult(oldArray, nums, start, end);
    }

    /**
     * 打印排序结果
     *
     * @param oldArray 排序前数组
     * @param newArray 排序后数组
     * @param start 开始时间
     * @param end 结束时间
     */
    private static void printResult(int[] oldArray, int[] newArray, long start, long end) {
        System.out.println(OP + " 耗时：" + String.format("%.4f", 1.0 * (end - start) / 1000) + "秒");
        System.out.print("排序前数组前100位：");
        for (int i = 0; i < 100; i++) {
            System.out.print(oldArray[i] + " ");
        }
        System.out.println();
        System.out.print("排序后数组前100位：");
        for (int i = 0; i < 100; i++) {
            System.out.print(newArray[i] + " ");
        }
    }

    /**
     * 构建一个由0-9按随机顺序组成的数组
     *
     * @return 随机数组
     */
    private static int[] constructArray() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < AMOUNT; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
