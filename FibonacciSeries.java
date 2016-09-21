package com.dp;

import java.util.HashMap;

public class FibonacciSeries {

	public static void main(String[] args) {
		int n=15;
		//int res=fib(n);
		//System.out.println(res);
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		int res1=fibDP(n,map);
		System.out.println(res1);
		
		int map1[]=new int[n+1];
		int res2=fibDP2(n,map1);
		System.out.println(res2);
	}

	private static int fibDP2(int n, int[] map1) {
		map1[0]=0;
		map1[1]=1;
		for(int i=2;i<=n;i++){
			map1[i]=map1[i-1]+map1[i-2];
		}
		return map1[n];
	}


	private static int fibDP(int n,HashMap<Integer,Integer> map) {
		if(map.containsKey(n))
			return map.get(n);
		if(n<=1)
			map.put(n, n);
		else
			map.put(n,fibDP(n-1, map)+fibDP(n-2, map));
		return map.get(n);
		
	}

	private static int fib(int n) {
		if(n<=1)
			return n;
		return fib(n-1)+fib(n-2);	
	}
}
