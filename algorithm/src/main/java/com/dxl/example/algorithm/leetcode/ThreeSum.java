package com.dxl.example.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName ThreeSum
 * @Author duxl
 * @Date 2019/9/29 11:24 上午
 * @Description 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 **/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        Set<Integer> set = new HashSet<>();
        set.addAll((ArrayList) Arrays.asList(nums));
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int one = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int two = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int three = nums[k];
                    if (one + two + three == 0) {
                        List<Integer> item = Arrays.asList(one, two, three);
                        if (!result.contains(item)) {
                            result.add(item);
                        }
                    }
                }

            }

        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        for (List arr : lists) {
            System.out.println(arr.toString());
        }
    }

}
