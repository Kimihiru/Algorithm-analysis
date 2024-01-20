package dp;

public class Rob {
	public static int rob(int[] nums) {
		int n=nums.length;
		int[] dp=new int[n+2];
		for(int i=n-1;i>=0;i--) {
			dp[i]=Math.max(nums[i]+dp[i+2], dp[i+1]);
		}
		return dp[0];
	}
	
//	 public static int rob2(int[] nums) {
//		 
//	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
