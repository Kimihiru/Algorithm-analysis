package dp;
public class NumSquares {
	public static int numSquaresByDp(int n) {
		int[] dp=new int[n+1];
		for(int i=1;i<=n;i++) {
			int minValue=Integer.MAX_VALUE;
			for(int j=1;j*j<=i;j++) {
				minValue=Math.min(minValue, dp[i-j*j]);
			}
			dp[i]=minValue+1;
		}
		return dp[n];
	}
	//四平方和定理
	public static int numSquaresByMath(int n) {
		if(isNumSquareSelf(n)) {
			return 1;
		}
		if(check4(n)) {
			return 4;
		}
		for(int i=1;i*i<=n;i++) {
			int j=n-(i*i);
			if(isNumSquareSelf(j)) {
				return 2;
			}
		}
		return 3;
	}
	
	public static boolean isNumSquareSelf(int n) {
		int x=(int) Math.sqrt(n);
		return n==x*x;
	}
	
	// 判断是否能表示为 n=4^k*(8m+7)
	public static boolean check4(int n) {
		while(n%4==0) {
			n/=4;
		}
		return n%8==7;
	}
	public static void main(String[] args) {
		int n=12;
		System.out.println(numSquaresByMath(n));
	}
}