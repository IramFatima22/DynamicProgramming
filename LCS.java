package com.dp;

public class LCS {

	public static void main(String[] args) {
		String s1="ABCDGH";
		String s2="AEDFHR";
		//String s1="AGGTAB";
		//String s2="GXTXAYB";
		int n1=s1.length();
		int n2=s2.length();
		System.out.println(findLCS(s1,s2,n1,n2));
		findLCSDP(s1,s2,n1,n2);
	}

	private static void findLCSDP(String s1, String s2, int n1, int n2) {
		int map[][]=new int[n1+1][n2+1];
		for(int i=0;i<=n1;i++){
			for(int j=0;j<=n2;j++){
				if(i==0 || j==0)
					map[i][j]=0;
				else if(s1.charAt(i-1)==s2.charAt(j-1))
					map[i][j]=1+map[i-1][j-1];
				else
					map[i][j]=Math.max(map[i-1][j], map[i][j-1]);
			}
		}
		System.out.println(map[n1][n2]);
		
	}

	private static int findLCS(String s1, String s2, int n1, int n2) {
		if(n1==0 || n2==0)
			return 0;
		if(s1.charAt(n1-1)==s2.charAt(n2-1))
			return 1+findLCS(s1, s2, n1-1, n2-1);
		return Math.max(findLCS(s1, s2, n1-1, n2), findLCS(s1, s2, n1, n2-1));
	}

}
