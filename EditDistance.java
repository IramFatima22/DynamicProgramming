package com.dp;

public class EditDistance {

	public static void main(String[] args) {
		//String s1="cat";
		//String s2="cut";
		String s2="saturday";
		String s1="sunday";
		int n1=s1.length();
		int n2=s2.length();
		System.out.println(findEdits(s1,s2,n1,n2));
		findEditsDP(s1,s2,n1,n2);
	}

	private static void findEditsDP(String s1, String s2, int n1, int n2) {
		int map[][]=new int[n1+1][n2+1];
		for(int i=0;i<=n1;i++){
			for(int j=0;j<=n2;j++){
				if(i==0)
					map[i][j]=j;
				else if(j==0)
					map[i][j]=i;
				else if(s1.charAt(i-1)==s2.charAt(j-1))
					map[i][j]=map[i-1][j-1];
				else
					map[i][j]=1+Math.min(map[i-1][j], Math.min(map[i][j-1], map[i-1][j-1]));
			}
		}
		System.out.println(map[n1][n2]);
	}

	private static int findEdits(String s1, String s2, int n1, int n2) {
		if(n1==0 || n2==0)
			return n1==0?n2:n1;
		if(s1.charAt(n1-1)==s2.charAt(n2-1))
			return findEdits(s1, s2, n1-1, n2-1);
		return 1+Math.min(findEdits(s1, s2, n1, n2-1),
				Math.min(findEdits(s1, s2, n1-1, n2-1),findEdits(s1, s2, n1-1, n2)));
	}

}
