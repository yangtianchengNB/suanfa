package com.crx.suanfa;

import java.util.Arrays;

public class Paixu {

    public void kuaiPai(int[] nums,int i ,int j){
        if (i > j||!(i>=0&&i<nums.length)||!(j>=0&&j<nums.length)){
            return;
        }
        int i1 = i,j1 = j,k = nums[i];
        while (i<j){
            if (nums[j]>=k){
                j--;
            }else if (nums[i]<=k){
                i++;
            }else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[i1] = nums[j];
        nums[j] = k;
        kuaiPai(nums,i1,j-1);
        kuaiPai(nums,j+1,j1);
    }

    public static void myBubblesort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if(array[j] > array[j+1]){
                    int tmp = 0;
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,2,8,3,5,1,8,3};
        Paixu paixu = new Paixu();
        paixu.kuaiPai(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
