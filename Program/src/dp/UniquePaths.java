package dp;
//×´Ì¬×ªÒÆ·½³Ìdp[i][j]=dp[i-1][j]+dp[i][j-1]
public class UniquePaths {
	public static int uniquePaths(int m,int n) {
		int[][] dp=new int[m][n];
		int a=dp.length;
		int b=dp[0].length;
		for(int i=0;i<a;i++) {
			dp[i][0]=1;
		}
		for(int i=0;i<b;i++) {
			dp[0][i]=1;
		}
		for(int i=1;i<a;i++) {
			for(int j=1;j<b;j++) {
				dp[i][j]=dp[i][j-1]+dp[i-1][j];
			}
		}
		return dp[m-1][n-1];
	}
	public static void main(String[] args) {
		System.out.println(uniquePaths(3,7));
	}
}