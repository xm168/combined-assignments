package com.cooksys.ftd.assignments.control;

import java.util.Arrays;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * The Fibonacci sequence is simply and recursively defined: the first two elements are `1`, and
 * every other element is equal to the sum of its two preceding elements. For example:
 * <p>
 * [1, 1] =>
 * [1, 1, 1 + 1]  => [1, 1, 2] =>
 * [1, 1, 2, 1 + 2] => [1, 1, 2, 3] =>
 * [1, 1, 2, 3, 2 + 3] => [1, 1, 2, 3, 5] =>
 * ...etc
 */
public class Fibonacci {

    /**
     * Calculates the value in the Fibonacci sequence at a given index. For example,
     * `atIndex(0)` and `atIndex(1)` should return `1`, because the first two elements of the
     * sequence are both `1`.
     *
     * @param i the index of the element to calculate
     * @return the calculated element
     * @throws IllegalArgumentException if the given index is less than zero
     */
	
	
    public static int atIndex(int i) throws IllegalArgumentException {
    	
    	int limit = 1000;
    	
    	int[] series = new int[limit];
    	series[0]=1;
    	series[1]=1;
   	
    	if(i >= 0 ) {
    		for(int j=2; j<=i; j++){
    			series[j] = series[j-1] + series[j-2];
    		}
    	}else{
    		throw new IllegalArgumentException();
    	}
		return series[i];
		}
    

    /**
     * Calculates a slice of the fibonacci sequence, starting from a given start index (inclusive) and
     * ending at a given end index (exclusive).
     *
     * @param start the starting index of the slice (inclusive)
     * @param end   the ending index of the slice(exclusive)
     * @return the calculated slice as an array of int elements
     * @throws IllegalArgumentException if either the given start or end is negative, or if the
     *                                  given end is less than the given start
     */
    public static int[] slice(int start, int end) throws IllegalArgumentException {
    	
    	if(start < 0 || end < 0 || end < start)
        throw new IllegalArgumentException();
    	
    	int size=100;
    	
    	int[] series = new int[size];
    	series[0]=1;
    	series[1]=1;
    	
    	int[] slices = new int[end-start];
         
        for (int i = 2; i < size; i++) { 
        	series[i] = series[i-1] + series[i-2];
        	}

        if(start>=0 && end>=0 && end>start){
        	for (int j = start; j < end; j++) {
        		if(start<end){
        			
        		}
        		slices[j-start] = series[j];
            }
        }else if(start==0 && end==0) slices = new int[]{};
        
        else{
        	throw new IllegalArgumentException();	
        }
        return slices;
    }

    /**
     * Calculates the beginning of the fibonacci sequence, up to a given count.
     *
     * @param count the number of elements to calculate
     * @return the beginning of the fibonacci sequence, up to the given count, as an array of int elements
     * @throws IllegalArgumentException if the given count is negative
     */
    public static int[] fibonacci(int count) throws IllegalArgumentException {
    	if(count<0)
        throw new IllegalArgumentException();
        
        int[] fibonacci = new int[count];
        int[] aSlice;
        int last;
        
        aSlice = slice(0, count);
        last = atIndex(count);
        
        for(int i=0; i<count; i++){
        	if(i == count) fibonacci[i] = last;
        	else
        		fibonacci[i] = aSlice[i];
        	}
    	if(count ==0)
    		fibonacci = new int[]{};
    	
    	return fibonacci;
    }
}
