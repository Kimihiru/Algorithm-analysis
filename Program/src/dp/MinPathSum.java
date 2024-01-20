package dp;
/*
  * 最优子结构sum=grid[0][0]+(grid[i-1][j]或grid[i][j-1])
  * 状态转移方程dp[i][j]=min(dp[i][j-1], dp[i-1][j])+grid[i][j];
 */
public class MinPathSum {
	public static int minPathSum(int[][] grid) {
		int m=grid.length;
		int n=grid[0].length;
		int[][] dp=new int[m][n];
		dp[0][0]=grid[0][0];//初始化dp[0][0]
		for(int i=1;i<m;i++)//初始化dp[i][0],向右走
			dp[i][0]=dp[i-1][0]+grid[i][0];
		for(int i=1;i<n;i++)//初始化dp[0][j],向下走
			dp[0][i]=dp[0][i-1]+grid[0][i];
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				dp[i][j]=Math.min(dp[i][j-1], dp[i-1][j])+grid[i][j];//计算最优值
			}
		}
		return dp[m-1][n-1];
	}
	public static void main(String[] args) {
		int[][] grid= {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(minPathSum(grid));
	}
}