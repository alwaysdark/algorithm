package basic;

public class BinarySearch {
    /**
     * 二分查找方法
     * @param array 已排序的int数组（升序）
     * @param target 要查找的目标值
     * @return 如果找到目标值，返回其索引；否则返回-1
     */
    public static int binarySearch(int[] array, int target) {
        // 检查数组是否为空
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止溢出，等同于(left + right)/2

            if (array[mid] == target) {
                return mid; // 找到目标值，返回索引
            } else if (array[mid] < target) {
                left = mid + 1; // 目标值在右半部分
            } else {
                right = mid - 1; // 目标值在左半部分
            }
        }

        return -1; // 未找到目标值
    }
}
