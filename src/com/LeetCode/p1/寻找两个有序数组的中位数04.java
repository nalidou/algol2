package com.LeetCode.p1;

public class 寻找两个有序数组的中位数04 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,5,7,7};
        int[] arr2 = new int[]{2,3,4,8,9};
        //1,2,2,3,4, 5,7,7,8,9
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length+nums2.length];
        int n1 = 0;
        int n2 = 0;
        int i = 0;
        for (; i<array.length; i++) {
            if (n1 < nums1.length && n2 < nums2.length) {
                int tmp = nums1[n1] < nums2[n2] ? nums1[n1++] : nums2[n2++];
                array[i] = tmp;
            } else {
                break;
            }
        }
        while (n1 < nums1.length) {
            array[i++] = nums1[n1++];
        }
        while (n2 < nums2.length) {
            array[i++] = nums2[n2++];
        }
        return array.length % 2 == 0 ?
                (array[array.length/2] + array[array.length/2-1]) / 2D :
                array[array.length/2];
    }
}
