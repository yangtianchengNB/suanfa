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

    public void selectionSort(int[]nums){
        int length=nums.length;
        //最小值的索引
        int index;
        for(int i=0;i<length;i++){
            index=i;
            for(int j=i+1;j<length;j++){
                //寻找最小的值
                if(nums[j]<nums[index]){
                    index=j;
                }
            }
            int tem=nums[i];
            nums[i]=nums[index];
            nums[index]=tem;
        }
    }


    public static void heapSort(int arr[]) {
        int temp = 0;

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);

        }


    }


    public static void adjustHeap(int arr[], int i, int length) {

        int temp = arr[i];//先取出当前元素的值，保存在临时变量
        //开始调整.
        //说明:k=i*2+1k是i结点的左子结点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > arr[i]) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;


    }

    public static void main(String[] args) {
        int[] arr = {5,2,8,3,5,1,8,3};
        Paixu paixu = new Paixu();
        paixu.kuaiPai(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println("dev_suanfa");
    }
}
