package com.dsa.two.pointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TripletSum {
    public static void main(String args[]){

    }
    /*
    public ArrayList<ArrayList<Integer>> triplet_sum(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> triplets=new ArrayList<ArrayList<Integer>>();
        if(nums.size()<=2) return triplets;
        Collections.sort(nums);
        for(int i=0;i<nums.size()-2;i++){
            ArrayList<ArrayList<Integer>> pairs=getPairSumTarget(i+1,nums.get(i));
            if(!pairs.isEmpty()) triplets.addAll(pairs);
        }
        return triplets;
    }

    private static ArrayList<ArrayList<Integer>> getPairSumTarget(int start, int target){
        ArrayList<ArrayList<Integer>> pairs=new ArrayList();
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
*/
}
