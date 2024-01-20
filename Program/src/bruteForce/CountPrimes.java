package bruteForce;

public class CountPrimes {
	public static int countPrimes(int n) {
		int count=0;
		for(int i=2;i<n;i++) {
			if(isPrimes(i)) {
				count++;
			}
		}
		return count;
	}
	public static boolean isPrimes(int n) {
		boolean ans=true;
		for(int i=2;i<n;i++) {
			if(n%i==0) {
				ans=false;
				break;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int n=499979;
		System.out.println(countPrimes(n));
	}
}
