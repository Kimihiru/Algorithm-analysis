package dp;
import java.util.*;
public class DpJump {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=3,m=5;
		int[][] x= {{-4,-5,-10,-3,1},
					{7,5,-9,3,-10},
					{10,-2,6,-10,-4}};
		int[][] dp=new int[n][m];
		dp[0][0]=x[0][0];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(i==0&&j==0) {
					continue;
				}
				int y=Integer.MIN_VALUE;
				if(i-1>=0) {
					y=Math.max(y, dp[i-1][j]);
				}
				if(i-2>=0) {
					y=Math.max(y, dp[i-2][j]);
				}
				if(i-3>=0) {
					y=Math.max(y, dp[i-3][j]);
				}
				if(j-1>=0) {
					y=Math.max(y, dp[i][j-1]);
				}
				if(j-2>=0) {
					y=Math.max(y, dp[i][j-2]);
				}
				if(j-3>=0) {
					y=Math.max(y, dp[i][j-3]);
				}
				dp[i][j]=x[i][j]+y;
			}
		}
		System.out.println(dp[n-1][m-1]);
		sc.close();
	}
}