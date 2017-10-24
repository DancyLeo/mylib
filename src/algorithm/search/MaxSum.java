package algorithm.search;

import java.util.ArrayList;
import java.util.Iterator;

public class MaxSum {
	
	
	public static  int[] maxsum(int[] x) {
		
		int max=0;
		int sum=0 ;
		int begin=0;
		int left=0;
		int right=0;
		
		for(int i=0 ;i<x.length ;i++) {
			
			if(sum>0) {
			sum = sum + x[i] ;
			
			
			}
			else {
			sum = x[i];
			begin=i ;
			}
			if(sum>max) {
			max = sum ;
			left=begin;
			right=i+1;
			
			}
		}
		
		int[] a= {max,left,right};
		return a ;
	}
	
	public static void main(String[] args) {
		int[] a = {-1,2,-4,5,2,9,-3} ;
		int[] maxlist = maxsum(a) ;
		System.out.println("max=" + maxlist[0]);
		for(int i=maxlist[1];i<maxlist[2];i++) {
			System.out.print(" " + a[i]);
		}
		}
	}
