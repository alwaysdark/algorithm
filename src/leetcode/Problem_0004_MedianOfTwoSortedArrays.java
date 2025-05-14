package leetcode;

public class Problem_0004_MedianOfTwoSortedArrays {
	
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int size = nums1.length + nums2.length;
		boolean even = (size & 1) == 0;
		if (nums1.length != 0 && nums2.length != 0) {
			if (even) {
				return (double) (findKthNum(nums1, nums2, size / 2) + findKthNum(nums1, nums2, size / 2 + 1)) / 2D;
			} else {
				return findKthNum(nums1, nums2, size / 2 + 1);
			}
		} else if (nums1.length != 0) {
			if (even) {
				return (double) (nums1[(size - 1) / 2] + nums1[size / 2]) / 2;
			} else {
				return nums1[size / 2];
			}
		} else if (nums2.length != 0) {
			if (even) {
				return (double) (nums2[(size - 1) / 2] + nums2[size / 2]) / 2;
			} else {
				return nums2[size / 2];
			}
		} else {
			return 0;
		}
	}

	/*
	 * 这个方法是获得任意长度两个数组拼起来之后的新数组的第k大小的数，k从1开始计算
	 * 分为三种情况：
	 * 1、当k小于等于短数组长度，直接从两个数组分别截取k长度，然后调用getUpMedian获得的上中位数即是整体的第k大小的数
	 * 2、当k大于短数组长度且小于等于长数组长度，需要手动扣掉长数组左边多的那个数，如果 longs[k - s - 1] >= shorts[s - 1]，longs[k - s - 1]即是第k大小的数，否则调用getUpMedian
	 * 3、当k大于长数组长度，需要分别扣掉短和长数组左边的一个值才能调getUpMedian，否则淘汰的加上getUpMedian返回的上中位数达不到k
	*/
	public static int findKthNum(int[] arr1, int[] arr2, int kth) {
		int[] longs = arr1.length >= arr2.length ? arr1 : arr2;
		int[] shorts = arr1.length < arr2.length ? arr1 : arr2;
		int l = longs.length;
		int s = shorts.length;
		if (kth <= s) {
			return getUpMedian(shorts, 0, kth - 1, longs, 0, kth - 1);
		}
		if (kth > l) {
			if (shorts[kth - l - 1] >= longs[l - 1]) {
				return shorts[kth - l - 1];
			}
			if (longs[kth - s - 1] >= shorts[s - 1]) {
				return longs[kth - s - 1];
			}
			return getUpMedian(shorts, kth - l, s - 1, longs, kth - s, l - 1);
		}
		// 第2段
		if (longs[kth - s - 1] >= shorts[s - 1]) {
			return longs[kth - s - 1];
		}
		return getUpMedian(shorts, 0, s - 1, longs, kth - s, kth - 1);
	}

	/*
	 * 这个方法需要两个有序数组的区间等长，否则不能调用该方法，这个方法是获得两个数组拼在一起新数组的上中位数
	 * 分为两种情况：
	 * 1、数组长度为偶数
	 *    a、如果两个数组上中位数相等，直接返回，为两个数组拼起来的数组的上中位数
	 *    b、如果 A[mid1] > B[mid2]; 将A的e1 = mid1，B的s2 = mid2+1
	 *    c、否则相反
	 * 2、数组长度为奇数
	 *    a、和偶数情况一直，如果两个数组上中位数相等，直接返回，为两个数组拼起来的数组的上中位数
	 *    b、如果 A[mid1] > B[mid2]；需要单独校验 B[mid2] >= A[mid1 - 1],直接返回结果B[mid2];如果不满足，将A的e1 = mid1 - 1，B的s2 = mid2+1
	 *    c、相反
	*/
	public static int getUpMedian(int[] A, int s1, int e1, int[] B, int s2, int e2) {
		int mid1 = 0;
		int mid2 = 0;
		while (s1 < e1) {
			mid1 = (s1 + e1) / 2;
			mid2 = (s2 + e2) / 2;
			if (A[mid1] == B[mid2]) {
				return A[mid1];
			}
			if (((e1 - s1 + 1) & 1) == 1) { // 奇数长度
				if (A[mid1] > B[mid2]) {
					if (B[mid2] >= A[mid1 - 1]) {
						return B[mid2];
					}
					e1 = mid1 - 1;
					s2 = mid2 + 1;
				} else { // A[mid1] < B[mid2]
					if (A[mid1] >= B[mid2 - 1]) {
						return A[mid1];
					}
					e2 = mid2 - 1;
					s1 = mid1 + 1;
				}
			} else { // 偶数长度
				if (A[mid1] > B[mid2]) {
					e1 = mid1;
					s2 = mid2 + 1;
				} else {
					e2 = mid2;
					s1 = mid1 + 1;
				}
			}
		}
		return Math.min(A[s1], B[s2]);
	}
}
