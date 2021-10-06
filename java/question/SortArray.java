package com.huang.question;

public class SortArray {
    public static void main(String[] args) {
        int[] nums={5,2,3,1};
        int[] result=sortArray(nums);
        for (int num: result) {
            System.out.print(num+" ");
        }
    }
    //冒泡排序
    /*public static int[] sortArray(int[] nums) {
        if(nums==null||nums.length==1){
            return nums;
        }
        for(int j=0;j<nums.length;j++) {
            for (int i = 0; i < nums.length - 1-j; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
        return nums;
    }*/
    //插入排序
    /*public static int[] sortArray(int[] nums) {
        int flag=0;
        int temp=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<nums[flag]){
                int j=0;
                while (nums[j]<nums[i]&&j<i){
                    j++;
                }
                if(j==i){
                    break;
                }else if(j<i){
                    temp=nums[i];
                    for(int k=i;k>j;k--){
                        nums[k]=nums[k-1];
                    }
                    nums[j]=temp;
                }
//                for (int n: nums) {
//                    System.out.print(n+",");
//                }
            }
            flag=i;
//            System.out.println();
        }
        return nums;
    }*/
    //快速排序
    /*public static void sortArray(int[] nums,int l,int r) {
        if(l>r){
            return;
        }
        int i=l;
        int j=r;
        int temp=nums[i];
        while (i<j) {
            while (i<j&&nums[j]>=temp){
                j--;
            }
            if(i<j) {
                nums[i] = nums[j];
                i++;
            }
            while (i<j&&nums[i]<=temp){
                i++;
            }
            if(i<j) {
                nums[j] = nums[i];
                j--;
            }
//            for (int num: nums) {
//                System.out.print(num+",");
//            }
//            System.out.println();
        }
        nums[i]=temp;
        sortArray(nums,l,i-1);
        sortArray(nums,i+1,r);
    }*/
    //归并排序
    public static int[] sortArray(int[] nums) {
        int[] c=new int[nums.length];
        mergeSort(nums,0, nums.length-1, c);
        return c;
    }

    public static void merge(int[] a,int first,int end,int middle,int[] c){
        int m=middle;
        int n=end;
        int i=first,j=middle+1,k=0;

        while (i<=m&&j<=n){
            if(a[i]<=a[j]){
                c[k]=a[i];
                k++;
                i++;
            }else {
                c[k]=a[j];
                k++;
                j++;
            }
        }

        while (i<=m){
            c[k]=a[i];
            k++;
            i++;
        }

        while (j<=n){
            c[k]=a[j];
            k++;
            j++;
        }

        for (int l = 0; l < k; l++) {
            a[l+first]=c[l];
        }
    }

    public static void mergeSort(int[] nums,int first,int last,int[] temp){
        if (first<last){
            int middle=(first+last)/2;
            mergeSort(nums,first,middle,temp);
            mergeSort(nums,middle+1,last,temp);
            merge(nums,first,last,middle,temp);
        }
    }
}
