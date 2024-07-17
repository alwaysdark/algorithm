public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {3,4,7,5,6,2,1,9,8};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, nums.length - 1);
        for (int i : nums){
            System.out.print(i + " ");
        }
    }
    
    public void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi){
            int pi = partition(arr, lo, hi);
            quickSort(arr, lo, pi - 1);
            quickSort(arr, pi + 1 , hi);
        }
    }

    public int partition(int[] arr, int lo, int hi) {
        int pivot = lo;
        int index = lo + 1;
        for (int i = index ; i <= hi; i++){
            if (arr[i] < arr[pivot]){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
        int temp = arr[index - 1];
        arr[index - 1] = arr[lo];
        arr[lo] = temp;
        return index - 1;
    }
}
