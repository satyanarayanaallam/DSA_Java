package com.dsa.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairSumSorted {
    public static void main(String args[]){
        int[] nums=new int[]{-5,-2,3,4,6};
        int target= 7;
        int[] output=getPairSum(nums, target);
        for(int i=0;i<output.length;i++){
            System.out.println(output[i]);
        }

        test(new int[]{1, 2, 3, 4, 5, 6}, 7);           // multiple pairs
        test(new int[]{1, 2, 3, 9}, 10);                // one pair
        test(new int[]{1, 2, 3, 4}, 10);                // no pairs
        test(new int[]{}, 5);                           // empty array
        test(new int[]{5}, 5);                          // one element
        test(new int[]{2, 2, 2, 2}, 4);                 // all identical
        test(new int[]{-3, -1, 0, 2, 4, 5}, 1);         // with negatives
        test(new int[]{1, 1, 2, 3, 4, 4, 5}, 6);        // duplicates
        test(new int[]{3, 3, 3, 3}, 6);                 // all sum to target
    }

    private static void test(int[] nums, int target) {
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        List<List<Integer>> result = getPairsSum(nums, target);
        System.out.println("Pairs (indices): " + result);
        System.out.println("-------------------------------------");
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

    //Write a program that returns all the pair of indices that sums the target
    private static List<List<Integer>> getPairsSum(int[] nums,int target){
        List<List<Integer>> pairs=new ArrayList();
        if(nums==null || nums.length<2) return pairs;
        int left=0,right=nums.length-1;
        while(left<right){
            int sum=nums[left]+nums[right];
            if(sum<target){
                left++;
            }else if(sum>target){
                right--;
            }else{
                pairs.add(List.of(left,right));
                int currentLeft = nums[left];
                int currentRight = nums[right];
                while (left < right && nums[left] == currentLeft) left++;
                while (left < right && nums[right] == currentRight) right--;
            }
        }
        return pairs;
    }
}
