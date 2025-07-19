package com.dsa.two.pointers;

public class PairSumSorted {
    public static void main(String args[]){
        int[] nums=new int[]{-5,-2,3,4,6};
        int target= 7;
        int[] output=getPairSum(nums, target);
        for(int i=0;i<output.length;i++){
            System.out.println(output[i]);
        }
    }
    private static int[] getPairSum(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<right){
            int sum=nums[left]+nums[right];
            if(sum==target) return new int[]{left,right};
            else if (sum<target) left++;
            else right--;
        }
        return new int[2];
    }
}
