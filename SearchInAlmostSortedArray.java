package com.dp;

public class SearchInAlmostSortedArray {

	public static void main(String[] args) {
		//int arr[]={10, 3, 40, 20, 50, 80, 70};
		//int key=40;
		int arr[]={3, 2, 10, 4, 40};
		int key=3;
		System.out.println(search(arr,key,0,arr.length-1));
	}

	private static int search(int[] arr, int key, int start, int end) {
		if(start>end)
			return -1;
		int mid=(start+end)/2;
		if(key==arr[mid])
			return mid;
		else if(key<arr[mid]){
			if(arr[mid+1]==key)
				return mid+1;
			return search(arr,key,start,mid-1);
		}
		else{
			if(arr[mid-1]==key)
				return mid-1;
			return search(arr,key,mid+1,end);
		}
		
	}

}
