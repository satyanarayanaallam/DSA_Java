package com.dsa.hashmap;

import java.util.HashMap;

public class PairSumUnsorted {
    public static void main(String args[]){

    }
    //Given an array of integers, return the indexes of any two numbers that add up to target
    //The order of the indexes are not matter
    private int[] pairSumUnsorted(int[] nums,int target){
        if(nums==null || nums.length<2) return new int[0];
        HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(map.containsKey(complement)) return new int[]{map.get(complement),i};
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
