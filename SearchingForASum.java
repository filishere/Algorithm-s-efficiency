package project;

import java.util.HashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class SearchingForASum {
	public static void main(String[] args) {
	int list[] = { -3, 1, 2, 4, 6, 12};       
		int sum = 50;
		System.out.println(hasPair_BruteForce(list, sum));
		System.out.println(hasPair_BinarySearch(list, sum));
		System.out.println(hasPair_FromBothEnds(list, sum));
		System.out.println(hasPair_HashSet(list, sum));
	}

	
	public static boolean hasPair_BruteForce( int[] list, int sum ) {
	
		for(int i = 0; i < list.length; i++) {      
			for(int j = i + 1; j < list.length;j++) {
				if( list[i] + list[j] == sum) {     
					return true;
				}
			}
		}
		return false;
	}

	
    public static boolean hasPair_BinarySearch( int[] list, int sum ) {
    	
    	for(int i = 0; i < list.length; i++) {                   
    	
    		if( BinarySearch.binarySearch(list, sum - list[i]) > 0) { 
    			return true;
    		}
    	}




		return false;
	}

    public static boolean hasPair_FromBothEnds( int[] list, int sum ) {
    	int lastIndex = list.length - 1;
    	int firstIndex = 0;
    	while( lastIndex > firstIndex) {         
    		int currentSum = list[lastIndex] + list[firstIndex];    
    		if(currentSum > sum) {                          
    			lastIndex--;
    		} else if (currentSum < sum) {                
    			firstIndex++;
    		} else {          
    			return true;
    		}
         }
    	return false;
    }

    public static boolean hasPair_HashSet( int[] list, int sum ) {
    	Set<Integer> rests = new HashSet<Integer>();      
    	for(int i = 0; i < list.length; i++) {        
    		if(rests.contains(list[i])) {        
    			return true;
    		}

    		rests.add(sum - list[i]);                
    	}

	return false;
    }
}
