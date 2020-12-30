package algorithm.sort;

public class MergeSort{
    private static void mergeSort(int[] arr, int l, int r){
        if(l==r)
            return;
        int m = (l+r)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        merge(arr, l, m+1, r);
    }
    private static void merge(int[] arr, int l, int m, int r){
        int[] left = new int[m-l];
        int[] right = new int[r-m+1];
        int k=l;
        for(int i=l;i<m;i++)
            left[i-l] = arr[i];
        for(int i=m;i<=r;i++)
            right[i-m] = arr[i];
        int i=0;
        int j=0;
        while(i<m-l&&j<r-m+1){
            if(left[i]<right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
        while(i<m-l)
            arr[k++] = left[i++];
        while(j<r-m+1)
            arr[k++] = right[j++];
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        mergeSort(arr,0,arr.length-1);
        for(int e:arr)
            System.out.print(e+" ");
        System.out.println();
    }
}