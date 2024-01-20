package greedy;
public class MaxProfit {
	public static int maxProfit(int[] prices) {
		int profitMax=0;
		int n=prices.length;
		int[] greedy=new int[n];
		for(int i=1;i<n;i++) {
			greedy[i]=prices[i-1]-prices[i];
		}
		for(int i=0;i<greedy.length;i++) {
			if(greedy[i]<0) {
				profitMax+=greedy[i];
			}
		}
		return -profitMax;
	}
	public static void main(String[] args) {
		int[] prices= {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
		int n=prices.length;
		int[] greedy=new int[n];
		for(int i=1;i<n;i++) {
			greedy[i]=prices[i-1]-prices[i];
			System.out.print(greedy[i]+" ");
		}
	}
}