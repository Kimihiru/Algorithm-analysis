package dp;

import java.util.Arrays;

public class Bag {
	public static int zeroOneBag(int[] weight,int[] value,int n,int c) {
		int[][] dp=new int[n+1][c+1];
		for(int i=0;i<dp.length;i++) {
			dp[i][0]=0;
		}
		for(int i=0;i<dp[0].length;i++) {
			dp[0][i]=0;
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=c;j++) {
				if(j-weight[i-1]<0) {//容量不足时
					dp[i][j]=dp[i-1][j];
				}
				else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]]+value[i-1]);
				}
			}
		}
		return dp[n][c];
	}
	public static int maxRotateFunction(int[] nums) {
		int n=nums.length;
		int sum=Arrays.stream(nums).sum();
		int[] dp=new int[n];
		for(int i=0;i<n;i++) {
			dp[0]+=i*nums[i];
		}
		int ans=Integer.MIN_VALUE;
		for(int i=1;i<n;i++) {
			dp[i]=dp[i-1]+sum-n*nums[n-i];
		}
		for(int i=0;i<n;i++) {
			ans=Math.max(ans, dp[i]);
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] weight= {5,3,2,10,4,8};//重量
		int[] value= {4,8,15,1,6,3};//价值
		int n=6;//最多可装物品个数
		int c=20;//最大容量
		System.out.println(zeroOneBag(weight,value,n,c));
	}
}