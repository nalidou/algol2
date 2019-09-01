package com.数组;

/**
 * 来源：剑指offer 06
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class 旋转数组的最小数字 {

    public static void main(String[] args) {
        int [] arr = new int[] {3,4,5,6,7,0,1,2,2,3};
        int [] arr2 = new int[] {1,1,1,0,1,1,1};
        System.out.println(getMin(arr));
    }

    static int getMin(int arr[]){
        if (arr==null || arr.length==0) {return 0;}

        int start = 0;
        int end = arr.length-1;
        int mid = (end+start)/2;

        while (start+1 != end) {
            System.out.println(start + "-" + mid + "-" + end);
            if (arr[mid] >= arr[start]) {
                //mid 在前半段
                start = mid;
                mid = (end+start)/2;
            } if (arr[mid] <= arr[end]) {
                //mid 在后半段
                end = mid;
                mid = (end+start)/2;
            }
        }
        return arr[end];
    }
}
