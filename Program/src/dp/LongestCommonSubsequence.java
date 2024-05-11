package dp;
public class LongestCommonSubsequence {
	public static int longestCommonSubsequence(String text1, String text2) {
		char[] x=text1.toCharArray();
		char[] y=text2.toCharArray();
		int m=x.length;
		int n=y.length;
		int[][] c=new int[m+1][n+1];
		for(int i=1;i<=m;i++) {
			c[i][0]=0;
		}
		for(int i=1;i<=n;i++) {
			c[0][i]=0;
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(x[i-1]==y[j-1]) {
					c[i][j]=c[i-1][j-1]+1;
				}
				else {
					c[i][j]=Math.max(c[i-1][j],c[i][j-1)];
				}
			}
		}
		return c[m][n];
	}
	public static void main(String[] args) {
		String text1="abcde";
		String text2="ace";
		System.out.println(longestCommonSubsequence(text1,text2));
	}
}
