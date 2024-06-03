package com.dsa.stacks;

import java.util.Stack;

/**Stack Min: How would you design a stack which, in addition to push and pop,
 *  has a function min which returns the minimum element? Push,
 *  pop and min should all operate in 0(1 ) time.
 */

public class StackWithMin extends Stack<Integer> {
    Stack<Integer> s2;
    public StackWithMin(){
        s2=new Stack<Integer>();
    }
    public void push(int value){
        if(value<=minQ()){
            s2.push(value);
        }
        super.push(value);
    }
    public int popQ(){
        int value= super.pop();
        if(value==minQ()){
            s2.pop();
        }
        return value;
    }
    public int minQ(){
        if(s2.isEmpty()){
            return Integer.MAX_VALUE;
        }
            return s2.peek();
    }
}
