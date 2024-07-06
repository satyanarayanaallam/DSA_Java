package com.dsa.union;

import java.util.Arrays;
import java.util.Scanner;

/*

 */
class Relation{
    int p;
    int q;
    Relation(int p,int q){
        this.p=p;
        this.q=q;
    }
}
public class SocialNetworkConnectivity {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        Relation[] relations =new Relation[m];
        for(int i=0;i<m;i++){
            int p= sc.nextInt();
            int q= sc.nextInt();
            Relation relation =new Relation(p,q);
            relations[i]=relation;
        }
        Network network=new Network(n,relations);
        System.out.println(network.getEarliestTime());
        //network.printArrays();
    }
}
class Network{
    int[] members;
    Relation[] relations;
    int[] size;
    int relationSize;
    int componentCount;
    Network(int n,Relation[] relations){
        members=new int[n];
        relationSize= relations.length;
        this.relations=relations;
        this.size=new int[n];
        for(int i=0;i<n;i++){
            members[i]=i;
            size[i]=0;
        }
        componentCount = n;
    }
    public int getEarliestTime(){
      //Todo
       for(int i=0;i<relationSize;i++){
           int rootP = root(relations[i].p);
           int rootQ = root(relations[i].q);
           if(rootP!=rootQ){
               union(relations[i]);

               if(isConnected(relations[i])){
                   componentCount--;
                   if (componentCount == 1) {
                       return i;
                   }
                   return i;
               }
           }

       }
       return -1;
    }
    private void union(Relation relation){
        int i=root(relation.p);
        int j=root(relation.q);
        if(i!=j){
            if(size[i]<size[j]){
                members[i]=j;
                size[j]=size[i]+size[j];
            }else{
                members[j]=i;
                size[i]=size[i]+size[j];
            }
        }
        printArrays();
    }
    private boolean isConnected(Relation relation){
        return root(relation.p)==root(relation.q);
    }

    private int root(int p){
        while(p!=members[p]) p=members[p];
        return p;
    }

    public void printArrays(){
        System.out.println(Arrays.toString(members));
    }
}
