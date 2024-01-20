package backtrack;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class GoodPlacement {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long n=2021041820210418l;
		long ans=0;
		List<Long> list=new ArrayList<Long>();
		for(long i=1;i*i<=n;i++) {
			if(n%i==0) {
				list.add(i);
				if(n/i!=i) {
					list.add(n/i);
				}
			}
		}
		for(long i=0;i<list.size();i++) {
			for(long j=0;j<list.size();j++) {
				for(long z=0;z<list.size();z++) {
					ans+=list.get((int) i)*list.get((int) j)*list.get((int) z)==n? 1:0;
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}
}