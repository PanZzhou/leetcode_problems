package com.pan.leetcode.heap;

//堆排序
public class HeapSort {
    private int[] heap;
    public HeapSort(int[] heap){
        this.heap=heap;
        System.out.println("初始数组");
        sout();
        System.out.println();
    }
    private void buildHeap(){
        for (int i = heap.length/2; i > 0 ; --i)
            adjustHeap(i,heap.length);
        System.out.println("建堆后：");
        sout();
        System.out.println();
    }
    private void adjustHeap(int index,int end){
        int temp = heap[index-1];
        for (int i = 2*index; i <= end; i = 2*index) {
            if(i+1<=end&&heap[i]>heap[i-1]) i++;
            if(heap[i-1]<temp)
                break;
            heap[index-1]=heap[i-1];
            index=i;
        }
        heap[index-1]=temp;
    }
    public void sort(){
        buildHeap();
        for (int i = heap.length; i >1 ; --i) {
            swap(1,i);
            adjustHeap(1,i-1);
        }
        System.out.println("堆排序后：");
        sout();
    }
    private void swap(int i,int j){
        int temp = heap[i-1];
        heap[i-1] = heap[j-1];
        heap[j-1] = temp;
    }
    public void sout(){
        for (int i : heap) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
