package com.dp;

public class MinCostPath {

	public static void main(String[] args) {
			int arr[][]={{1,2,3},{4,8,2},{1,5,3}};
			int r=arr.length;
			int c=arr[0].length;
			System.out.println(findMinPath(arr,r-1,c-1));
			findMinPathDP(arr,r,c);
	}

	private static void findMinPathDP(int[][] arr, int r, int c) {
		int map[][]=new int[r][c];
		map[0][0]=arr[0][0];
		for(int i=1;i<r;i++){
			map[i][0]=map[i-1][0]+arr[i][0];
		}
		for(int j=1;j<c;j++){
			map[0][j]=map[0][j-1]+arr[0][j];
		}
		for(int i=1;i<r;i++){
			for(int j=1;j<c;j++){
				map[i][j]=arr[i][j]+Math.min(map[i-1][j], Math.min(map[i-1][j-1], map[i][j-1]));
			}
		}
		System.out.println(map[r-1][c-1]);
	}

	private static int findMinPath(int[][] arr, int r, int c) {
		if(r==0 && c==0)
			return arr[r][c];
		if(r<0 || c<0)
			return Integer.MAX_VALUE;
		return arr[r][c]+Math.min(findMinPath(arr, r-1, c),
				Math.min(findMinPath(arr, r-1, c-1),findMinPath(arr,r,c-1)));
	}

}
