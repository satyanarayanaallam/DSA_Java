package com.dsa.arrays;

public class RemoveDuplicatesFromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int i=1,k=1;
        while(i<nums.length){
            if(nums[i]!=nums[i-1]) nums[k++]=nums[i];
            i++;
        }
        return k;
    }
}
