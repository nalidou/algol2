package com.LeetCode.p1;

import java.util.*;

public class 两数之和01 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,5,5,7,11,15};
        int target = 22;
        //int[] res = twoSum(nums, target);
        int[] res = twoSum2(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }

    //方法2：hash映射
    public static int[] twoSum2(int[] nums, int target) {
        int res[] = new int[2];
        Map<Integer, List<Integer>> map = new HashMap<Integer,List<Integer>>();
        for (int i=0; i<nums.length; i++) {
            Integer item = nums[i];

            //相同的key，解决hash冲突
            List<Integer> list;
            if (map.containsKey(item)) {
                list = map.get(item);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(nums[i], list);
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer cur = iterator.next();
            Integer next = target - cur;
            if (map.containsKey(next)){
                List<Integer> curList = map.get(cur);
                List<Integer> nextList = map.get(next);
                if (curList == nextList) {
                    res[0] = curList.get(0);
                    res[1] = curList.get(1);
                } else {
                    res[0] = curList.get(0);
                    res[1] = nextList.get(0);
                }
                return res;
            }
        }
        return res;
    }

    //方法1：暴露破解
    public static int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        for (int i=0; i<nums.length; i++) {
            res[0] = i;
            for (int j=0;j<nums.length;j++) {
                if (nums[j] == target-nums[i]) {
                    res[1] = j;
                    return res;
                }
            }
        }

        return res;
    }
}
