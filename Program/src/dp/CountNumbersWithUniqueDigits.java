package dp;
public class CountNumbersWithUniqueDigits {
	public static int countNumbersWithUniqueDigits(int n) {
		if(n<2) {
			return (int) (Math.pow(10, n)-0);
		}
		int ans=10,current=9;
		for(int i=0;i<n-1;i++) {
			current*=9-i;
			ans+=current;
		}
		return ans;
	}
	public static int dpCountNumbersWithUniqueDigits(int n) {
		int[] dp=new int[n+1];
		dp[0]=1;dp[1]=10;
		if(n<2) {
			return (int) (Math.pow(10, n)-0);
		}
		for(int i=2;i<=n;i++) {
			dp[i]=dp[i-1]+((dp[i-1]-dp[i-2])*(10-(i-1)));
		}
		return dp[n];
	}
}