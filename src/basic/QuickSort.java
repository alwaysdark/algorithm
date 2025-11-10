package basic;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {3,4,7,5,6,2,1,9,8};
        quickSort(nums);
        for (int i : nums){
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] equalArea = netherlandsFlag(arr, L, R);
        process(arr, L, equalArea[0] - 1);
        process(arr, equalArea[1] + 1, R);
    }
    /*
    * 荷兰国旗问题的目标是希望:小于num的全部移动到左边，等于num在中间，大于num在右边，执行流程是这样的：
    * 1、初始化小于区域的右边界在L-1,大于区域的左边界在R(R最后再移动位置)，num选择R
    * 2、while(当前位置<大于区域的左边界)不断循环，直到当前位置撞上大于区域的左边界，具体分为三种情况：
    *    a、等于num,i++
    *    b、小于num, 小于区域右边第一个数和i位置数做交换，小于区域往右扩一位，i++
    *    c、大于num，大于区域左边第一个数和i位置数做交换，大于区域往左扩一位，i在原地，因为交换后的i位置数还没看
    *    以上三种情况相当于:小于区域推着等于区域往右走，大于区域追着i，当i位置和大于区域左边界撞上，循环退出
    * 3、R和大于区域左边界做交换
    * 可得等于区域位 [less + 1, more]
    */
    // 荷兰国旗问题
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[] { -1, -1 };
        }
        if (L == R) {
            return new int[] { L, R };
        }
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);
        return new int[] { less + 1, more };
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // L..R partition arr[R] [ <=arr[R] arr[R] >arr[R] ]
        int M = partition(arr, L, R);
        process1(arr, L, M - 1);
        process1(arr, M + 1, R);
    }

    /*
    * partition每次调整对一个位置，小于等于num的全部移动到左边，大于num在右边，执行流程是这样的：
    * 1、初始化小于等于区域的右边界在L-1，num选择R
    * 2、while(当前位置<最后位置)不断循环，具体分为二种情况：
    *    a、小于等于num, 小于等于区域右边第一个数和i位置数做交换，小于等于区域往右扩一位，i++
    *    b、大于num,i++
    * 3、R和小于等于区域下一个位置做交换
    * 可得一个正确的位置lessEqual
    */
    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }
}
