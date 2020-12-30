package algorithm.sort;

public class HeapSort {
    private static void heapSort(int[] nums){
        buildHeap(nums);
        for(int i=nums.length-1;i>=0;i--){
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
    }
    private static void heapify(int[] nums,int n,int i){
        if(i>=n)
            return;
        int max = i;
        if(2*i+1<n&&nums[2*i+1]>nums[max])
            max = 2*i+1;
        if(2*i+2<n&&nums[2*i+2]>nums[max])
            max = 2*i+2;
        if(max!=i){
            swap(nums, i, max);
            heapify(nums, n, max);
        }
    }

    private static void buildHeap(int[] nums){
        for(int i=(nums.length-2)/2;i>=0;i--)
            heapify(nums, nums.length, i);
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {-4,0,7,4,9,-5,-1,0,-7,-1};
        heapSort(arr);
        for(int e:arr)
            System.out.print(e+" ");
        System.out.println();
    }
}
