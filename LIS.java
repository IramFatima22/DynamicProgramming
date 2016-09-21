package com.dp;

import java.util.Arrays;

public class LIS {
	static int maxLIS;
	public static void main(String[] args) {
		int arr[]={ 10, 22, 9, 33, 21,50,41,60,80};
		int n=arr.length;
		int lis[]=new int[n];
		Arrays.fill(lis, 1);
		findLISDP(arr,n,lis);
	}
	private static void findLISDP(int[] arr, int n, int[] lis) {
		for(int i=0;i<n;i++){
			for(int j=0;j<i;j++){
				if(arr[j]<arr[i] && lis[j]+1>lis[i])
					lis[i]=lis[j]+1;
			}
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			max=Math.max(max, lis[i]);
		}
		System.out.println(max);
		
	}
}