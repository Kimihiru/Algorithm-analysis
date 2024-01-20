package divideAndConquer;
import java.util.Scanner;
public class TrailingZeroes {
	public static long trailingZeroes(long n) {
		long ans=0;
		while(n!=0) {
			n/=5;
			ans+=n;
		}
		return ans;
	}
	public static long getF(long num) {
        long ans=0;
        while(num>0) {
            ans+=num/5;
            num/=5;
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(trailingZeroes(5));
		Scanner sc=new Scanner(System.in);
		long K=sc.nextLong();
        long l=0,r=(long) 9e18;
        while(l<r) {
            long mid=(l+r)/2;
            if(getF(mid)>=K) {
                r=mid;
            }
            else {
                l=mid+1;
            }
        }
        if(getF(l)==K) {
            System.out.println(l);
        }
        else {
            System.out.println(-1);
        }
        sc.close();
	}
}