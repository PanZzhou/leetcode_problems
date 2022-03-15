package com.pan.leetcode.sort;

public class sort {
    public void quickSort(int[] nums){
        quickSort(nums, 0, nums.length-1);
        printNums(nums);
    }
    //快速排序
    private void quickSort(int[] nums, int l, int r){
        if(r<=l) return;
        int low = l, high = r, pivot = nums[low];
        while(low<high){//相等即退出
            while(low<high && nums[high]>= pivot) high--;
            nums[low] = nums[high];
            while(low<high && nums[low]<=pivot) low++;
            nums[high] = nums[low];
        }
        //这个赋值步骤别忘了
        nums[low] = pivot;
        //递归子区间
        quickSort(nums, l, low-1);
        quickSort(nums, low+1, r);
    }

    public void mergeSort(int[] nums){
        mergeSort(nums, 0, nums.length-1);
        printNums(nums);
    }
    private void mergeSort(int[] nums, int low, int high){
        if(low >= high) return;
        int mid = (low + high)>>1;
        //先划分数组
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);
        //后把两个数组归并
        merge(nums, low, mid, high);
    }
    private void merge(int[] nums, int low, int mid, int high){
        int l = low, r = mid+1, index = 0;
        int arr[] = new int[high - low + 1];
        while(l<=mid && r<=high){
            if(nums[l]<=nums[r])
                arr[index++] = nums[l++];
            else
                arr[index++] = nums[r++];
        }
        while(l<=mid) arr[index++] = nums[l++];
        while(r<=high) arr[index++] = nums[r++];
        //复制回原数组
        l=low;
        for (int i = 0; i < high-low+1; i++) {
            nums[l++] = arr[i];
        }
    }

    //不适用下标迭代，使用容量
    public void heapSort(int[] nums){
        buildHeap(nums);
        for (int i = nums.length; i > 1; i--) {
            int temp = nums[0];
            nums[0] = nums[i-1];
            nums[i-1] = temp;
            adjustHeap(nums, 1, i-1);
        }
        printNums(nums);
    }
    //使用容量方便
    private void buildHeap(int[] nums){
        for (int i = nums.length/2; i > 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
    }

    private void adjustHeap(int[] nums, int k, int end){
        int orig = nums[k-1];
        for (int i = 2*k; i <= end; i*=2) {
            if(i<end && nums[i-1]<nums[i]) i++;
            //这里的条件容易错，要看orig的值，而不是nums[k-1]的值
            if(orig >= nums[i-1]) break;
            else{
                nums[k-1] = nums[i-1];
                k = i;
            }
        }
        //这一步千万不能忘记
        nums[k-1] = orig;
    }



    private void printNums(int[] nums){
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
