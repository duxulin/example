package com.dxl.example.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * @ClassName Sort
 * @Author duxl
 * @Date 2019/9/29 1:57 下午
 * @Description TODO
 **/
public class Sort {

    @Test
    public void test() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        bubbleSort(nums);
//        selectedSort(nums);
        quickSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " , ");
        }
    }


    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void selectedSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);

    }

    public static void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0 || left >= right || left < 0) {
            return;
        }
        int j = left;
        int k = right;
        int base = arr[left];
        int tmp;

        while (j < k) {
            while (j < k && arr[j] <= base) {
                j++;
            }
            while (j < k && arr[k] >= base) {
                k--;
            }
            if (j < k) {
                tmp = arr[j];
                arr[j] = arr[k];
                arr[k] = tmp;
            }
        }
        arr[left] = arr[j];
        arr[j] = base;

        quickSort(arr, 0, left - 1);
        quickSort(arr, left + 1, right);

    }

}
