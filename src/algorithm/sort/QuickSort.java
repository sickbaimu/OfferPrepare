package algorithm.sort;

import java.util.Random;

public class QuickSort{
    private static final Random RANDOM = new Random();
    public static void quicksort(int[] nums,int start,int end){
        if(start>=end)
            return;
        int p = partition(nums,start,end);
        quicksort(nums,start,p-1);
        quicksort(nums,p+1,end);
    }
    public static int partition(int[] nums,int start,int end){
        int randomIndex = RANDOM.nextInt(end-start + 1) + start;
        swap(nums,start,randomIndex);
        int l = start;
        int base = nums[start];
        for(int i=start+1;i<=end;i++)
            if(nums[i]<base){
                l++;
                swap(nums,i,l);
            }
        swap(nums,start,l);
        return l;
    }
    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {-4,0,7,4,9,-5,-1,0,-7,-1};
        quicksort(arr,0,arr.length-1);
        for(int e:arr)
            System.out.print(e+" ");
        System.out.println();
    }
}